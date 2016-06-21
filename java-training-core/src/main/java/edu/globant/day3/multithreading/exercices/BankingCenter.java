package edu.globant.day3.multithreading.exercices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BankingCenter {
	
	static final int MAX_THREADS = 5;
	
	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue<Customer> queue = new LinkedBlockingQueue<Customer>(); //queue where new customers will be waiting and from where tellers will retrieve them
		ArrayList<Runnable> tasks = new ArrayList<Runnable>();
		Random random = new Random();
		
		Thread enqueuer = new Thread(() -> {  //Thread which will enqueue new customers, simulating their arrival to the bank
			int i=1;
			while(true){
				try {  //we add it some delay so not to add lots of customers all the time
					Thread.sleep(random.nextInt(1000));
				} catch (Exception e) {
					e.printStackTrace();
				}
				int nextRandom = random.nextInt(3)+1; 
				String typeOfCustomer = "check";
				switch(nextRandom){ //the type of action which the client will make (each one has its duration/cost) is generated by a new random
					case 1:
						typeOfCustomer="borrow";
						break;
					case 2:
						typeOfCustomer="deposit";
						break;
					default:
						break;
				}
				try {
					queue.offer(new Customer(String.valueOf(i),typeOfCustomer));
					System.out.println("Client "+String.valueOf(i)+" is now at the queue, wanting to "+typeOfCustomer);
					i++;
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}
		});
		tasks.add(enqueuer);
		
		int numberOfTellers = random.nextInt(4)+1; //in each running of the program, a different amount of tellers will be available (a random number between 1-4)
		for (int i = 0; i < numberOfTellers; i++) {
			Thread teller = new Thread(() -> {  //Thread that simulates a teller
				Customer nextToAttend;
				while(true){
					nextToAttend=null;
					try {
						nextToAttend = queue.take();
						System.out.println("---"+String.format(Thread.currentThread().getName()+" attending client "+nextToAttend.getName()+", "
								+ "who wants to "+nextToAttend.getBankAction()));
						nextToAttend.makeAction();
					} catch (InterruptedException e) {
						e.printStackTrace(System.out);
					}
				}
			}, "Teller no "+(i+1));
			tasks.add(teller);
		}
		
		System.out.println("There are "+numberOfTellers+" tellers available");
		workWithThreadPool(queue, Executors.newFixedThreadPool(MAX_THREADS), (tasks.stream().toArray(Runnable[]::new))); 
	}
	
	public static void workWithThreadPool(BlockingQueue queue, ExecutorService executor, Runnable ... tasks) throws InterruptedException {
		System.out.println("Opening bank"); //The bank is opened
		for (Runnable task : tasks) {
			executor.execute(task);
		}
		executor.shutdown();
	    if (!executor.awaitTermination(20000, TimeUnit.MILLISECONDS)) {
	        System.out.println("Bank Closed");  //The bank is closed
	        if(queue.size()>0) System.out.println(queue+" have priority for tomorrow, since they got to enter the bank and got a number");
	        System.exit(0);
	    }
	}

	
}

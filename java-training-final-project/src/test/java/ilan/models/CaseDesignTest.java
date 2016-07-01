package ilan.models;

import static org.junit.Assert.*;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;

public class CaseDesignTest {

	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new CaseDesign(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new CaseDesign("");
	}
	
	@Test
	public void testCreation() {
		CaseDesign test = new CaseDesign("Test");
		assertThat("Case Design wasnt correctly instantiated",test.getName(),is("Test"));
	}
	
	@Test
	public void testToString() {
		CaseDesign test = new CaseDesign("Test");
		assertThat("To String method doesnt work as expected",
				test.toString(),equalTo("Name: "+test.getName()));
	}
}
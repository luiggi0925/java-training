$(document).ready(function(){ 
	
	$(document).on("click",".makeAlertRequest",function(){
		if (confirm('Confirm the order?')) {
			 var productId = this.id.split("_")[0].toString();
			 var quantity = this.id.split("_")[1];
			 var providerId = this.id.split("_")[2];
			 var casesJson += '{"'+productId+'":"'+quantity+'"}';
			 var jsonOrder = {
						    "requestCases":JSON.parse(casesJson),
						    "dateOfRequest":getCurrentDate()
			 };
			 $.ajax({
				   type: 'POST',
				   url: '/providers/'+providerId+'/order',
				   data: JSON.stringify(jsonOrder),
				   error: function() {
				      $('#result').html('<p>An error has occurred</p>');
				   },
				   success: function(data) {
					   
				   },
				   contentType: "application/json",
				   dataType: 'json'
			 });
		}
	});
	
	$(document).on("click",".makeRequest",function(){
		var providerId = this.id.split("_")[0];
		var quantity = $("#"+providerId+"_quantity");
		if ((quantity.val().length === 0) || (quantity.val()<=0)){
			alert("Must enter a quantity to order!");
			return false;
		}
		 if (confirm('Confirm the order?')) {
			 var design = $("#"+providerId+"_designSelect").val();
			 var device = $("#"+providerId+"_deviceSelect").val();
			 //obtain the product id
			 var quantity = $("#"+providerId+"_quantity").val();
			 var caseOrderDTO = {
					 dateOfRequest: getCurrentDate(),
					 requestCases : {
						 productId:quantity
					 }
			};
			 $.ajax({
				   url: '/providers/'+providerId+'/order',
				   data: {
					   caseOrderDTO: caseOrderDTO
				   },
				   error: function() {
				      $('#result').html('<p>An error has occurred</p>');
				   },
				   success: function(data) {
					   
				   },
				   type: 'PUT'
			});
		 }
	});
});

function getCurrentDate(){
	var today = new Date();
	var dd = today.getDate(); 
	if(dd<10) dd = "0"+dd;
	var mm = today.getMonth()+1; 
	if(mm<10) mm = "0"+mm;
	var yyyy = today.getFullYear(); 
	return (yyyy+"-"+mm+"-"+dd);
}

function constructJson(jsonKey, jsonValue){
	   var jsonObj = {"key1": jsonValue};
	   jsonObj[jsonKey] = "2";
	   return jsonObj;
}
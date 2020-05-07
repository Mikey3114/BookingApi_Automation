package datadrivenTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DataDriven_getBooking {
	//Getting All bookings 
	@Test(priority=1)
	void getAllBooking()
	{
		String baseUrl="https://restful-booker.herokuapp.com";
		RestAssured.baseURI=baseUrl;
		
		RequestSpecification https=RestAssured.given();
		
		//Headers
		https.headers("Content-Type","application/json");
		https.headers("Accept","application/json");
		
		//Get Method
		Response response=https.request(Method.GET,"/booking");
		
		String booking_Id=response.asString();
		
		//System.out.println(booking_Id);
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
		}
	 //Getting Booking details using parameters(firstname,lastname,checkindate,checkoutdate)
	@Test(priority=2,dataProvider="getBookingusername",dataProviderClass=Booking_dataProvider.class)
	void booking_username(String efirstname,String elastname,String echeckin,String echeckout) {
		
		String baseUrl="https://restful-booker.herokuapp.com";
		RestAssured.baseURI=baseUrl;
		
		RequestSpecification https=RestAssured.given();
		
		//JSONObject requestParams=new JSONObject();

		 
		//Headers
			https.headers("Content-Type","application/json");
			https.headers("Accept","application/json");
			
		//params
		  https.param("firstname",efirstname);
		  https.param("lastname",elastname);
		  
		  //if need search using checkin & checkout date
		 // https.param("checkin", echeckin);
		 // https.param("checkout", echeckout);
		  
		  
			
			//Get Method
			
	   Response	response=https.request(Method.GET,"/booking");
	   String booking_IdUsername=response.asString();
	  // System.out.println(booking_IdUsername);
	   
	   int statuscode=response.statusCode();
	   Assert.assertEquals(statuscode, 200);
	   
		
		
		
	}
	
	//Getting details using booking ID
	@Test(priority=3,dataProvider="getbookingId",dataProviderClass=Booking_dataProvider.class)
	void getbookingData_ID(String userId) {
		
		String baseUrl="https://restful-booker.herokuapp.com";
		RestAssured.baseURI=baseUrl;
		
		RequestSpecification https=RestAssured.given();
		
		//Headers
		https.headers("Content-Type","application/json");
		https.headers("Accept","application/json");
		
		//Params
		//https.param("id",userId);
		
		//Get method
		Response response=https.request(Method.GET,"/booking/"+userId);
		String responseBody_Id=response.asString();
		
		System.out.println(responseBody_Id);
		
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 200);
		
		
		}

}

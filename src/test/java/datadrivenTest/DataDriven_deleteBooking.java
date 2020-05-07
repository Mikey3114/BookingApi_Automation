package datadrivenTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DataDriven_deleteBooking {
	
	@Test(dataProvider="updateBooking",dataProviderClass=Booking_dataProvider.class)
  void delete_Booking(String userId) {
		
		String baseUrl="https://restful-booker.herokuapp.com";
		RestAssured.baseURI=baseUrl;
		
		RequestSpecification https=RestAssured.given();
		
		//Headers
		https.headers("Content-Type","application/json");
		https.headers("Accept","application/json");
		
		//Params
		//https.param("id",userId);
		
		//Get method
		Response response=https.request(Method.DELETE,"/booking/"+userId);
		String responseBody_Id=response.asString();
		
		System.out.println(responseBody_Id);
		
		int statuscode=response.statusCode();
		Assert.assertEquals(statuscode, 200);
		
		
		}

}

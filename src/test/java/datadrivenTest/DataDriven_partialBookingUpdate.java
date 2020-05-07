package datadrivenTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriven_partialBookingUpdate   {
	@Test(dataProvider="partialUpdateBooking",dataProviderClass=Booking_dataProvider.class)
	void partial_UpdateBooking(String userid,String userfirstname,String userlastname) {
		String baseUrl="https://restful-booker.herokuapp.com";
		RestAssured.baseURI=baseUrl;
		
		RequestSpecification https=RestAssured.given();
		JSONObject requestParams=new JSONObject();
		requestParams.put("firstname",userfirstname);
		requestParams.put("lastname",userlastname);
		
		https.headers("Content-Type","application/json");
		https.headers("Accept","application/json");
	    https.cookie("token","c870e9964ea8beb");
	    
	    //body
	     https.body(requestParams.toJSONString());
	     
	     //Put Method
	     Response response=https.request(Method.PUT,"/booking/"+userid);
	     
	     String partial_UpdatedResponse=response.asString();
	     System.out.println(partial_UpdatedResponse);
	     
	     int statuscode=response.statusCode();
	     Assert.assertEquals(statuscode, 200);
	}

}

package datadrivenTest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriven_updateBooking {
	
	
	@Test(dataProvider="updateBooking",dataProviderClass=Booking_dataProvider.class)
	void putBooking(String userId)
	{   
		String baseUrl="https://restful-booker.herokuapp.com";
		RestAssured.baseURI=baseUrl;
		
		RequestSpecification https=RestAssured.given();
		
	     JSONObject requestParams=new JSONObject();
	     JSONObject bookingdates=new JSONObject();
		bookingdates.put("checkin", "2020-05-12");
		bookingdates.put("checkout" ,"2020-06-12");
	    requestParams.put("firstname","Vinay");
		requestParams.put("lastname","Sharma");
		requestParams.put("totalprice","2000");
		requestParams.put("depositpaid",false);
		requestParams.put("bookingdates",bookingdates);
		requestParams.put("additionalneeds","dinner");
		
		//headers
		https.headers("Content-Type","application/json");
		https.headers("Accept","application/json");
	    https.cookie("token","091c914e8d44333");
		
		//body
		https.body(requestParams.toJSONString());
		
		//PUT Method
		Response response=https.request(Method.PUT,"/booking/"+userId);
		
		String updatedBody=response.asString();
		System.out.println(updatedBody);
		
		int statuscode=response.statusCode();
		
		Assert.assertEquals(statuscode,200);
		
		
		
		
	}

}

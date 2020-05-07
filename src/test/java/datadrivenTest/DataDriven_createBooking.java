package datadrivenTest;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class DataDriven_createBooking  {
	
	
	@Test(dataProvider="bookingcreatedata",dataProviderClass=Booking_dataProvider.class,priority=2)
	 void createBooking(String efirstname,String elastname,String etotalprice,String edepositpaid,String echeckindate,String echeckoutdate,String eadditonaldetails) {
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		RequestSpecification httprequest=RestAssured.given();
		
		JSONObject requestParams= new JSONObject();
		JSONObject bookingdates=new JSONObject();
		bookingdates.put("checkin", echeckindate);
		bookingdates.put("checkout" ,echeckoutdate);
		
		requestParams.put("firstname",efirstname);
		requestParams.put("lastname",elastname);
		requestParams.put("totalprice",etotalprice);
		requestParams.put("depositpaid",edepositpaid);
		requestParams.put("bookingdates",bookingdates);
		requestParams.put("additionalneeds",eadditonaldetails);
		
		//specifiying content type which is json
		httprequest.headers("Content-Type","application/json");
		//
		httprequest.headers("Accept","application/json");
		
		//passing body to the request
		httprequest.body(requestParams.toJSONString());
		
		//Post request
		Response response=httprequest.request(Method.POST,"/booking");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("Response body is:"+responseBody);

	    Assert.assertEquals(responseBody.contains(efirstname),true);
		Assert.assertEquals(responseBody.contains(elastname),true);
	    Assert.assertEquals(responseBody.contains(etotalprice),true);
	    Assert.assertEquals(responseBody.contains(edepositpaid),true);
        Assert.assertEquals(responseBody.contains(echeckindate),true);
		Assert.assertEquals(responseBody.contains(echeckoutdate),true);
	    Assert.assertEquals(responseBody.contains(eadditonaldetails),true); 
		
		int statuscode=response.getStatusCode();
		
		Assert.assertEquals(statuscode,200);
		
		
		
		
		
		
		
		
		 
	}

}

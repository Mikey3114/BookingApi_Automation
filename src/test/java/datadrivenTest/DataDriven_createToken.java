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

public class DataDriven_createToken {
	@Test(dataProvider="tokenCreate",dataProviderClass=Booking_dataProvider.class,priority=1)
	void createToken(String eusername,String epassword) {
		
		String baseUrl="https://restful-booker.herokuapp.com";
		
		RestAssured.baseURI=baseUrl;
		
		RequestSpecification https_1=RestAssured.given();
		
		JSONObject requestParam=new JSONObject();
		requestParam.put("username",eusername);
		requestParam.put("password",epassword);
	
		
		
		//headers
		https_1.headers("Content-Type","application/json");
		https_1.headers("Accept","application/json");
		
		//Body
		https_1.body(requestParam.toJSONString());
		
		//Post Rquest
		Response token_Response= https_1.request(Method.POST,"/auth");
		
		String token_ResponseBody=token_Response.getBody().asString();
		
		System.out.println("token is"+token_ResponseBody);
		
		//Assert.assertEquals(token_ResponseBody.contains("token:"),true);
		
		
		int statusCode=token_Response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	   
		
		
	}

}


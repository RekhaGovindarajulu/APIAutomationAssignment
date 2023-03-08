package com.APIAutomation;

import org.testng.annotations.Test;

import com.APIAutomation.constants.APIEndpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class APITest extends BaseAPITest {

	@Test
	public void testUserListAPI() {

		// RestAssured.baseURI = "https://reqres.in/api";
		// RestAssured.given().log().all().contentType(ContentType.JSON).get("/users?page=2")
		// .then().statusCode(200).log().all();

		log.info("Check list of users");
		RestAssured.given().spec(Spec).get(APIEndpoints.userListAPI).then().statusCode(200).log().all();

	}

	@Test
	public void testAddUserAPI() {

		String addUserPayload = "{\"name\": \"rachael\",\"job\": \"teacher\"}";

		// RestAssured.baseURI = "https://reqres.in/api";
		// RestAssured.given().log().all().body(addUserPayload).when().post("/api/users")
		// .then().statusCode(201).log().all();

		log.info("Add user");

		Response response = RestAssured.given().spec(Spec).body(addUserPayload).when().post(APIEndpoints.addUserAPI);

		log.debug(response.getStatusCode());
		log.debug(response.getTime());

		ResponseBody resp = response.getBody();
		System.out.println(resp.asString());
	}

}

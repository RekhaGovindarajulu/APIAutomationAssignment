package com.APIAutomation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.APIAutomation.constants.APIEndpoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseAPITest {

	protected static Logger log = LogManager.getLogger(APITest.class.getName());

	protected RequestSpecification Spec = new RequestSpecBuilder().setBaseUri(APIEndpoints.baseUrl)
			.setContentType(ContentType.JSON).build().log().all();

}

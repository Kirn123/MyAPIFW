package com.qa.api.basicAuth.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BasicAuthTest extends BaseTest {

	@Test
	public void basicAuthTest() {
		Response response = restClient.get(BASE_URL_BASIC_AUTH, BASIC_AUTH_ENDPOINT, null, null, AuthType.BASIC_AUTH,
				ContentType.ANY);
		Assert.assertTrue(
				response.getBody().asString().contains("Congratulations! You must have the proper credentials."));
	}

}

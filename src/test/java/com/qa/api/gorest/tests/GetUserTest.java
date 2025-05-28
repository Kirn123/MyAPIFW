package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.api.base.BaseTest;
import com.qa.api.constants.AuthType;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
@Epic("GoRest API Tests")
@Story("Get User Tests")
public class GetUserTest extends BaseTest{
	@Description("Base URL for GoRest API")
	@Owner("Kiran Narawade")
	@Severity(SeverityLevel.NORMAL)
	
	@Test
	public void getAllUsersTest() {
		ChainTestListener.log("Get all users test started");
		Response response = restClient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, null, null, AuthType.BEARER_TOKEN, ContentType.JSON);
		Assert.assertTrue(response.statusLine().contains("OK"));
	}
	
	
	@Test
	public void getAllUsersWithQueryParamTest() {
		ChainTestListener.log("Get all users with query params test started");
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("name", "naveen");
		queryParams.put("status", "active");		
		Response response = restClient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT, queryParams, null, AuthType.BEARER_TOKEN, ContentType.JSON);
		Assert.assertTrue(response.statusLine().contains("OK"));		
	}
	
	@Test (enabled = false)
	public void getSingleUserTest() {
		String userId = "7881422";
		Response response = restClient.get(BASE_URL_GOREST, GOREST_USERS_ENDPOINT+"/"+userId, null, null, AuthType.BEARER_TOKEN, ContentType.JSON);
		Assert.assertTrue(response.statusLine().contains("OK"));		
		Assert.assertEquals(response.jsonPath().getString("id"), userId);
	}
	
	

}
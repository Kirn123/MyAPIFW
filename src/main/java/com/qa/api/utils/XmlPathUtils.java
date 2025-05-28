package com.qa.api.utils;


import java.util.List;
import java.util.Map;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class XmlPathUtils {
	/**
	 * Converts the response body to an XmlPath object.
	 *
	 * @param response the Response object from RestAssured
	 * @return an XmlPath object representing the XML structure of the response
	 */
	
	private static XmlPath getXmlPath(Response response) {
        String responseBody = response.body().asString();
        return new XmlPath(responseBody);
    }

    public static <T> T read(Response response, String xmlPathExpression) {
        XmlPath xmlPath = getXmlPath(response);
        return xmlPath.get(xmlPathExpression);
    }

    public static <T> List<T> readList(Response response, String xmlPathExpression) {
        XmlPath xmlPath = getXmlPath(response);
        return xmlPath.getList(xmlPathExpression);
    }

   

}
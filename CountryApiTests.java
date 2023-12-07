package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class CountryApiTests {

    @Test
    public void positiveTestCase() {
        String countryName = "united"; // Set the country name you want to test

        Response response = RestAssured
                .given()
                .pathParam("name", countryName)
                .when()
                .get("https://restcountries.com/v3.1/name/{name}?fullText=true");

        response.then()
                .statusCode(200) // Check if the status code is 200 (OK)
                .body("size()", greaterThan(0)); // Check if the response body is not empty
    }
    @Test
    public void negativeTestCase() {
        String countryName = "nonexistentcountry"; // Set a non-existent country name

        Response response = RestAssured
                .given()
                .pathParam("name", countryName)
                .when()
                .get("https://restcountries.com/v3.1/name/{name}?fullText=true");

        response.then()
                .statusCode(404) // Check if the status code is 404 (Not Found)
                .body("size()", equalTo(0)); // Check if the response body is empty (no results found)
    }
}

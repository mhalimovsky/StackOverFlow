package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.requestSpecification;

public class BaseApi {

    public static RequestSpecification requestSpecification(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecification400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .build();

    }

    public static ResponseSpecification responseSpecification200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}


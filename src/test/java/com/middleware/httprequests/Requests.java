package com.middleware.httprequests;

import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class Requests {

    public Response postRequest(String endPoint, String body){
        return given()
                .body(body)
                .post(endPoint);

    }

    public Response putRequest(String endPoint, String body){
        return given()
                .body(body)
                .put(endPoint);

    }

    public Response getRequest(String endPoint) {
        return given()
                .get(endPoint);
    }

    public Response deleteRequest(String endPoint){
        return given()
                .body("test")
                .delete(endPoint);
    }
}

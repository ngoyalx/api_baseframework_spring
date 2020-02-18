package com.middleware.steps;
import com.middleware.enums.StatusCode;
import com.middleware.httprequests.Requests;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import com.middleware.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseSteps {

    @Autowired
    public Requests requests;

    @Autowired
    public JsonUtils jsonUtils;

    public Response response;
    public static final String createEmployeePaylodFileName =  System.getProperty("user.dir") + "/src/test/resources/payload/createEmployee.json";
    public static final String updateEmployeePaylodFileName =  System.getProperty("user.dir") + "/src/test/resources/payload/updateEmployee.json";

    public void validateAndAttachResponse(StatusCode expectedStatusCode, String attachmentName, Response response){
        Allure.addAttachment(attachmentName, response.asString());
        Assertions.assertEquals(expectedStatusCode.getStatusCode(), response.getStatusCode(), "Status code not matched");
    }
}

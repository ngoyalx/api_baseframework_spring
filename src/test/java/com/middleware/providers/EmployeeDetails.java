package com.middleware.providers;

import com.middleware.dto.createemployee.CreateEmployeeResponse;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDetails {

    private CreateEmployeeResponse createEmployeeResponse;

    public void setCreateEmployeeResponse(Response response){
        this.createEmployeeResponse = response.getBody().as(CreateEmployeeResponse.class);
    }

    public String getEmployeeName(){
        return createEmployeeResponse.getData().getName();
    }

    public String getEmployeeSalary(){
        return createEmployeeResponse.getData().getSalary();
    }
}

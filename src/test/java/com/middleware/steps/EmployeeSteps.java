package com.middleware.steps;

import com.middleware.httprequests.EndPoints;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import com.middleware.providers.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.middleware.enums.StatusCode.STATUS_OK;

@Component
public class EmployeeSteps extends BaseSteps {

    @Autowired
    private EmployeeDetails employeeDetails;

    @Autowired
    private EndPoints endPoints;

    @Step
    public EmployeeSteps whenICreateEmployee(){
        String createEmployeePayload = jsonUtils.readJSONFileAsString(createEmployeePaylodFileName);
        response = requests.postRequest(endPoints.createEmployeeEndpoint.get(), createEmployeePayload);
        validateAndAttachResponse(STATUS_OK, "create_employee_response", response);
        employeeDetails.setCreateEmployeeResponse(response);
        return this;
    }

    @Step
    public EmployeeSteps whenIUpdateEmployee(String employeeId){
        String updateEmployeePayload = jsonUtils.readJSONFileAsString(updateEmployeePaylodFileName);
        response = requests.postRequest(String.format(endPoints.updateEmployeeEndpoint.get(), employeeId), updateEmployeePayload);
        validateAndAttachResponse(STATUS_OK, "update_employee_response", response);
        return this;
    }

    @Step
    public EmployeeSteps whenIDeleteEmployee(String employeeId){
        response = requests.deleteRequest(String.format(endPoints.deleteEmployeeEndpoint.get(), employeeId));
        validateAndAttachResponse(STATUS_OK, "delete_employee_response", response);
        return this;
    }

    @Step
    public EmployeeSteps whenIRetrieveEmployeeList(){
        response = requests.getRequest(endPoints.employeeListEndpoint.get());
        validateAndAttachResponse(STATUS_OK, "retrieve_employee_list_response", response);
        return this;
    }

    @Step
    public EmployeeSteps thenIVerifyStatusCode(int expectedStatusCode){
        Assertions.assertEquals(expectedStatusCode, response.getStatusCode(), "Status code not matched");
        return this;
    }

    @Step
    public EmployeeSteps thenIVerifyEmployeeIsCreated(String expectedName, String expectedSalary){
        Assertions.assertEquals(expectedName, employeeDetails.getEmployeeName() , "Employee name not matched");
        Assertions.assertEquals(expectedSalary, employeeDetails.getEmployeeSalary() , "Employee salary not matched");
        return this;
    }

    @Step
    public EmployeeSteps thenIVerifyEmployeeIsUpdated(){
        return this;

    }

    @Step
    public EmployeeSteps thenIVerifyEmployeeIsDeleted(){
        return this;
    }

    @Step
    public EmployeeSteps thenIVerifyEmployeeInList(String expectedName, String expectedSalary){
        return this;
    }
}

package com.middleware.httprequests;

import org.apache.groovy.internal.util.Supplier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EndPoints {

    @Value("${baseURI}")
    private String baseURI;
    @Value("${createEmployee}")
    private String createEmployee;
    @Value("${updateEmployee}")
    private String updateEmployee;
    @Value("${employeeList}")
    private String employeeList;
    @Value("${deleteEmployee}")
    private String deleteEmployee;

    public Supplier<String> createEmployeeEndpoint = () -> baseURI + createEmployee;

    public Supplier<String> updateEmployeeEndpoint = () -> baseURI + updateEmployee;

    public Supplier<String> deleteEmployeeEndpoint = () -> baseURI + deleteEmployee;

    public Supplier<String> employeeListEndpoint = () -> baseURI + employeeList;
}

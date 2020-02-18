package com.middleware.tests;

import com.middleware.config.Config;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import com.middleware.steps.EmployeeSteps;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = Config.class)
@ExtendWith(SpringExtension.class)
@Feature("Employee")
public class EmployeeTest {

    @Autowired
    private EmployeeSteps employeeSteps;

    @Test
    @DisplayName("verify user is able to create employee")
    public void createEmployeeTest(){
        employeeSteps.
                whenICreateEmployee()
                .thenIVerifyEmployeeIsCreated("demo", "10000");
    }
}

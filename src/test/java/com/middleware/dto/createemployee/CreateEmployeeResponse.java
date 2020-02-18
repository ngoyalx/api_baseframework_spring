package com.middleware.dto.createemployee;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeResponse {
    @JsonProperty("status")
    public String status;
    @JsonProperty("data")
    public Data data;
}

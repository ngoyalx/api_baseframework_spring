package com.middleware.dto.createemployee;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Data {
    @JsonProperty("name")
    public String name;
    @JsonProperty("salary")
    public String salary;
    @JsonProperty("age")
    public String age;
    @JsonProperty("id")
    public Integer id;
}

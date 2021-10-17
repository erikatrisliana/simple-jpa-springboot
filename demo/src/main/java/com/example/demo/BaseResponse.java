package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
    @JsonProperty("message")
    private String message;
    @JsonProperty("saving")
    private Saving saving = null;
    @JsonProperty("list_saving")
    private List<Saving> listSaving = null;
    @JsonProperty("saving_calculation")
    private String savingCalculation = null;
}

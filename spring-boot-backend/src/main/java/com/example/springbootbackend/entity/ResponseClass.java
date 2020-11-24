package com.example.springbootbackend.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "d"
})
public class ResponseClass {

    @JsonProperty("d")
    private WrapperObject wrapperObject;

    @JsonProperty("d")
    public WrapperObject getWrapperObject() {
        return wrapperObject;
    }

    @JsonProperty("d")
    public void setWrapperObject(WrapperObject wrapperObject) {
        this.wrapperObject = wrapperObject;
    }

    public ResponseClass(){}

    public ResponseClass(List<Result>results){
        this.wrapperObject = new WrapperObject();
        this.wrapperObject.setResults(results);
    }

}

package com.example.springbootbackend.controller;

import com.example.springbootbackend.entity.ResponseClass;
import com.example.springbootbackend.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
@RequestMapping(value = "results")
public class ResultsController {

    @Autowired
    private ResultsService resultsService;


    @GetMapping
    public ResponseEntity getAllResultsFromDatabase(){
        return new ResponseEntity<>(resultsService.getAllResultsFromDatabase(), HttpStatus.OK);
    }

    @GetMapping("/refresh")
    public ResponseEntity getAllResultsFromService(){
        ResponseEntity<ResponseClass> returnValue = resultsService.refreshAllResults();
        return new ResponseEntity<>(returnValue, returnValue.getStatusCode());
    }

    @GetMapping("/filter")
    public ResponseEntity filterAllResultsFromService(@RequestParam String filterValue){
        ResponseEntity<ResponseClass> returnValue = resultsService.filterAllResults(filterValue);
        return new ResponseEntity<>(returnValue, returnValue.getStatusCode());
    }

}

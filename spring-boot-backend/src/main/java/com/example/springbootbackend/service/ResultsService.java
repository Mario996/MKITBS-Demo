package com.example.springbootbackend.service;

import com.example.springbootbackend.RestClient;
import com.example.springbootbackend.entity.ResponseClass;
import com.example.springbootbackend.entity.Result;
import com.example.springbootbackend.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsService {

    @Autowired
    private  RestClient restClient;
    @Autowired
    private  ResultsRepository resultsRepository;

    public ResponseEntity<ResponseClass> refreshAllResults(){
        ResponseEntity<ResponseClass> result = restClient.get("https://sapgw.mk-group.org:42080/sap/opu/odata/sap/ZGIS_SRV/StocksSet?$format=json");
        for (Result res : result.getBody().getWrapperObject().getResults()) {
            resultsRepository.save(res);
        }
        return result;
    }

    public ResponseClass getAllResultsFromDatabase(){
        List<Result> results = resultsRepository.findAll();
        return new ResponseClass(results);
    }
}

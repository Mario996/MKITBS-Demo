package com.example.springbootbackend.service;

import com.example.springbootbackend.client.RestClient;
import com.example.springbootbackend.entity.ResponseClass;
import com.example.springbootbackend.entity.Result;
import com.example.springbootbackend.entity.ResultPrimaryKey;
import com.example.springbootbackend.repository.ResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
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
        if(saveAllResults(result.getBody()))
        {
            return result;
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseClass getAllResultsFromDatabase(){
        List<Result> results = resultsRepository.findAll();
        return new ResponseClass(results);
    }

    public boolean saveAllResults(ResponseClass response){
        try{
            for (Result res : response.getWrapperObject().getResults()) {
                res.setPk(new ResultPrimaryKey(res.getPlant(), res.getStorageLocation(), res.getMaterialId()));
                resultsRepository.save(res);
            }
        }catch (DataAccessException e)
        {
            System.out.println("Exception occurred:" + e.getMessage());
            return false;
        }
        return true;
    }
}

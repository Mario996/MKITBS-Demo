package com.example.springbootbackend.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ResultPrimaryKey implements Serializable {

    private String plant;
    private String storageLocation;
    private String materialId;

    public String getPlant() {
        return plant;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public String getMaterialId() {
        return materialId;
    }

    public ResultPrimaryKey(){}

    public ResultPrimaryKey(String plant, String storageLocation, String materialId){
        this.plant = plant;
        this.storageLocation = storageLocation;
        this.materialId = materialId;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof  ResultPrimaryKey)) return false;
        ResultPrimaryKey that = (ResultPrimaryKey) o;
        return Objects.equals(getPlant(), that.getPlant()) &&
                Objects.equals(getMaterialId(), that.getMaterialId()) &&
                Objects.equals(getStorageLocation(), that.getStorageLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlant(), getMaterialId(), getStorageLocation());
    }
}

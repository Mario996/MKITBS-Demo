package com.example.springbootbackend.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Plant",
        "PlantName",
        "StorageLocation",
        "StorageLocationName",
        "MaterialGroupId",
        "MaterialGroupName",
        "MaterialId",
        "MaterialName",
        "Quantity",
        "UnitOfMeasure"
})
@Entity
public class Result {
    @EmbeddedId
    private ResultPrimaryKey pk;
    @JsonProperty("PlantName")
    private String plantName;
    @JsonProperty("StorageLocationName")
    private String storageLocationName;
    @JsonProperty("MaterialGroupId")
    private String materialGroupId;
    @JsonProperty("MaterialGroupName")
    private String materialGroupName;
    @JsonProperty("MaterialName")
    private String materialName;
    @JsonProperty("Quantity")
    private String quantity;
    @JsonProperty("UnitOfMeasure")
    private String unitOfMeasure;
    @JsonProperty("Plant")
    @Transient
    private String plant;
    @JsonProperty("StorageLocation")
    @Transient
    private String storageLocation;
    @JsonProperty("MaterialId")
    @Transient
    private String materialId;

    public ResultPrimaryKey getPk() {
        return pk;
    }

    public void setPk(ResultPrimaryKey pk) {
        this.pk = pk;
    }

    @JsonProperty("Plant")
    public String getPlant() {
        return plant;
    }

    @JsonProperty("PlantName")
    public String getPlantName() {
        return plantName;
    }

    @JsonProperty("PlantName")
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    @JsonProperty("StorageLocation")
    public String getStorageLocation() {
        return storageLocation;
    }

    @JsonProperty("StorageLocationName")
    public String getStorageLocationName() {
        return storageLocationName;
    }

    @JsonProperty("StorageLocationName")
    public void setStorageLocationName(String storageLocationName) {
        this.storageLocationName = storageLocationName;
    }

    @JsonProperty("MaterialGroupId")
    public String getMaterialGroupId() {
        return materialGroupId;
    }

    @JsonProperty("MaterialGroupId")
    public void setMaterialGroupId(String materialGroupId) {
        this.materialGroupId = materialGroupId;
    }

    @JsonProperty("MaterialGroupName")
    public String getMaterialGroupName() {
        return materialGroupName;
    }

    @JsonProperty("MaterialGroupName")
    public void setMaterialGroupName(String materialGroupName) {
        this.materialGroupName = materialGroupName;
    }

    @JsonProperty("MaterialId")
    public String getMaterialId() {
        return materialId;
    }

    @JsonProperty("MaterialName")
    public String getMaterialName() {
        return materialName;
    }

    @JsonProperty("MaterialName")
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    @JsonProperty("Quantity")
    public String getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("UnitOfMeasure")
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    @JsonProperty("UnitOfMeasure")
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

}
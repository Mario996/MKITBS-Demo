package com.example.springbootbackend.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    @Id
    @GeneratedValue
    private Long Id;
    @JsonProperty("Plant")
    private String plant;
    @JsonProperty("PlantName")
    private String plantName;
    @JsonProperty("StorageLocation")
    private String storageLocation;
    @JsonProperty("StorageLocationName")
    private String storageLocationName;
    @JsonProperty("MaterialGroupId")
    private String materialGroupId;
    @JsonProperty("MaterialGroupName")
    private String materialGroupName;
    @JsonProperty("MaterialId")
    private String materialId;
    @JsonProperty("MaterialName")
    private String materialName;
    @JsonProperty("Quantity")
    private String quantity;
    @JsonProperty("UnitOfMeasure")
    private String unitOfMeasure;

    public Long getId() {
        return Id;
    }

    @JsonProperty("Plant")
    public String getPlant() {
        return plant;
    }

    @JsonProperty("Plant")
    public void setPlant(String plant) {
        this.plant = plant;
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

    @JsonProperty("StorageLocation")
    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
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

    @JsonProperty("MaterialId")
    public void setMaterialId(String materialId) {
        this.materialId = materialId;
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
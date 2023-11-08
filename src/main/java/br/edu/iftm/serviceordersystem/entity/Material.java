package br.edu.iftm.serviceordersystem.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Material implements Serializable {
    private Long id;
    private String name;
    private int quantity;
    private float unitCost;
    private float totalCost;
    private long serialNumber;
    private String unitOfMeasure;
    private Date acquisitionDate; 
    private String note;

    public Material(Long id, String name, int quantity, float unitCost, long serialNumber, String unitOfMeasure, Date acquisitionDate, String note) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unitCost = unitCost;
        this.totalCost = unitCost * quantity;
        this.serialNumber = serialNumber;
        this.unitOfMeasure = unitOfMeasure;
        this.acquisitionDate = acquisitionDate;
        this.note = note;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.common.core;

import java.util.List;
import javax.validation.constraints.NotNull;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;

/**
 *
 * @author LENOVO
 */
@Entity(
        value = "barcodes",
        noClassnameStored = true
)
public class Barcode {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private String mobileId;
    private Bounds bounds;
    private List<Points> cornerPoints;
    @NotNull
    private String data;
    private String target;
    private String type;
    private Long scanDate;
    private Long saveDate;

    public Barcode() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public List<Points> getCornerPoints() {
        return cornerPoints;
    }

    public void setCornerPoints(List<Points> cornerPoints) {
        this.cornerPoints = cornerPoints;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getScanDate() {
        return scanDate;
    }

    public void setScanDate(Long scanDate) {
        this.scanDate = scanDate;
    }

    public Long getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(Long saveDate) {
        this.saveDate = saveDate;
    }
}

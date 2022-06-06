package com.vanhieu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "CategoryEntity")
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "image")
    private String image;

    @Column(name ="price_per_day", nullable = false)
    private Integer pricePerDay;

    @Column(name = "num_of_bed", nullable = false)
    private Integer numOfBed;

    @Column(name = "num_of_pool", nullable = false)
    private Integer numOfPool;

    @Column(name = "view_to_beach", nullable = false)
    private Integer viewToBeach;

    @Column(name = "status", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "categoryOfRoom")
    private List<RoomEntity> rooms = new ArrayList<>();

    @OneToOne(mappedBy = "categoryImage")
    private ImageOfCateEntity imageOfCateEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Integer pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Integer getNumOfBed() {
        return numOfBed;
    }

    public void setNumOfBed(Integer numOfBed) {
        this.numOfBed = numOfBed;
    }

    public Integer getNumOfPool() {
        return numOfPool;
    }

    public void setNumOfPool(Integer numOfPool) {
        this.numOfPool = numOfPool;
    }

    public Integer getViewToBeach() {
        return viewToBeach;
    }

    public void setViewToBeach(Integer viewToBeach) {
        this.viewToBeach = viewToBeach;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

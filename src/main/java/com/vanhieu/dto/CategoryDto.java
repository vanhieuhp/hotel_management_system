package com.vanhieu.dto;

public class CategoryDto extends AbstractDto<CategoryDto> {

    private String name;
    private String code;
    private String image;
    private Integer pricePerDay;
    private Integer numOfBed;
    private Integer numOfPool;
    private Integer viewToBeach;
    private Integer status;

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
/*
 * name VARCHAR(255) NOT NULL, code VARCHAR(255) NOT NULL,
 */

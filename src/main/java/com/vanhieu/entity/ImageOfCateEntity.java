package com.vanhieu.entity;

import javax.persistence.*;

@Entity
@Table(name = "image_of_cate")
public class ImageOfCateEntity extends BaseEntity{

    @Column(name = "dessert")
    private String dessert;

    @Column(name = "view")
    private String view;

    @Column(name = "overview")
    private String overview;

    @Column(name = "bed")
    private String bed;

    @Column(name = "pool")
    private String pool;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity categoryImage;

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public CategoryEntity getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(CategoryEntity categoryImage) {
        this.categoryImage = categoryImage;
    }

}

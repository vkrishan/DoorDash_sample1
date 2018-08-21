package com.test.vkrishan.doordash_sample1.model;

import com.google.gson.annotations.SerializedName;

public class RestaurantList {


    @SerializedName("id")
    private Integer id;

    @SerializedName("business_id")
    private Integer business_id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("status")
    private String status;

    @SerializedName("cover_img_url")
    private String cover_img_url;

    public RestaurantList(Integer id, Integer business_id, String name, String description, String status, String cover_img_url){

        this.id = id;
        this.business_id = business_id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.cover_img_url = cover_img_url;
    }

    public Integer getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Integer business_id) {
        this.business_id = business_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCover_img_url() {
        return cover_img_url;
    }

    public void setCover_img_url(String cover_img_url) {
        this.cover_img_url = cover_img_url;
    }
}






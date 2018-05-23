package com.z4group.pos.domain;



/**
 * Dishes entity. @author MyEclipse Persistence Tools
 */

public class Dish  implements java.io.Serializable {


    // Fields    

     private String dishid;
     private Category category;
     private String dishname;
     private String unit;
     private Double price;

     
    // Constructors

    /** default constructor */
    public Dish() {
    }

	/** minimal constructor */
    public Dish(String dishid, String dishname, String unit, Double price) {
        this.dishid = dishid;
        this.dishname = dishname;
        this.unit = unit;
        this.price = price;
    }
    
    /** full constructor */
    public Dish(String dishid, Category category, String dishname, String unit, Double price) {
        this.dishid = dishid;
        this.category = category;
        this.dishname = dishname;
        this.unit = unit;
        this.price = price;
    }

    public String getCategoryName() {
        return this.category.getName();
    }
    // Property accessors

    public String getDishid() {
        return this.dishid;
    }
    
    public void setDishid(String dishid) {
        this.dishid = dishid;
    }

    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDishname() {
        return this.dishname;
    }
    
    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return this.price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
   








}
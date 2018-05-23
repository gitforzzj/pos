package com.z4group.pos.domain;



/**
 * OrderDetail entity. @author MyEclipse Persistence Tools
 */

public class OrderDetail  implements java.io.Serializable {


    // Fields    

     private String itemid;
     private Order order;
     private Dish dishes;
     private Integer num;
     private String taste;
     private Double totalprice;


    // Constructors

    /** default constructor */
    public OrderDetail() {
    }

	/** minimal constructor */
    public OrderDetail(String itemid, Dish dishes) {
        this.itemid = itemid;
        this.dishes = dishes;
    }
    
    /** full constructor */
    public OrderDetail(String itemid, Order order, Dish dishes, Integer num, String taste, Double totalprice) {
        this.itemid = itemid;
        this.order = order;
        this.dishes = dishes;
        this.num = num;
        this.taste = taste;
        this.totalprice = totalprice;
    }

   
    // Property accessors

    public String getItemid() {
        return this.itemid;
    }
    
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public Order getOrder() {
        return this.order;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }

    public Dish getDishes() {
        return this.dishes;
    }
    
    public void setDishes(Dish dishes) {
        this.dishes = dishes;
    }

    public Integer getNum() {
        return this.num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTaste() {
        return this.taste;
    }
    
    public void setTaste(String taste) {
        this.taste = taste;
    }

    public Double getTotalprice() {
        return this.totalprice;
    }
    
    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }
   








}
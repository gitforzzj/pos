package com.z4group.pos.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category  implements java.io.Serializable {


    // Fields    

     private String id;
     private String name;
     private Set disheses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Category() {
    }

	/** minimal constructor */
    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    /** full constructor */
    public Category(String id, String name, Set disheses) {
        this.id = id;
        this.name = name;
        this.disheses = disheses;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getDisheses() {
        return this.disheses;
    }
    
    public void setDisheses(Set disheses) {
        this.disheses = disheses;
    }
   








}
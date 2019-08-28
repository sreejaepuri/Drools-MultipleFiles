package com.ns.DroolsMultipleFiles.Models;

public class Product {
    private String name;
    private String type;

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Product(String name, String type, Long discount) {
        this.name = name;
        this.type = type;
        this.discount = discount;
    }

    private Long discount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String name) {
        this.name = name;
    }
}

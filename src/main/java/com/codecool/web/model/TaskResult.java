package com.codecool.web.model;

import java.sql.Array;
import java.util.List;

public class TaskResult {

    private String companyName;
    private String productName;
    private int numberOfProducts;
    private Array orderIds;
    private float unitPrice;

    public TaskResult(String companyName, String productName) {
        this.companyName = companyName;
        this.productName = productName;
    }

    public TaskResult(String companyName, int numberOfProducts) {
        this.companyName = companyName;
        this.numberOfProducts = numberOfProducts;
    }

    public TaskResult(String companyName) {
        this.companyName = companyName;
    }

    public TaskResult(String companyName, Array orderIds) {
        this.companyName = companyName;
        this.orderIds = orderIds;
    }

    public TaskResult(String companyName, String productName, float unitPrice) {
        this.companyName = companyName;
        this.productName = productName;
        this.unitPrice = unitPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getProductName() {
        return productName;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public Array getOrderIds() {
        return orderIds;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public void setOrderIds(Array orderIds) {
        this.orderIds = orderIds;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
}

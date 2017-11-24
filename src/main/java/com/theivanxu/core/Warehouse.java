package com.theivanxu.core;

/**
 * Created by xushaonan on 2017/11/24.
 **/
public class Warehouse {

    private long id;
    private String name;
    private String serial;
    private Integer quantity;
    private Double price;

    public Warehouse(long id){
        this.id = id;
    }

    public Warehouse(long id, String name, String serial, Integer quantity, Double price){
        this(id);
        this.name = name;
        this.serial = serial;
        this.quantity = quantity;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSerial() {
        return serial;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serial='" + serial + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

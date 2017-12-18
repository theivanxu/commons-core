package com.theivanxu.core;

import java.math.BigDecimal;

/**
 * Created by xushaonan on 2017/12/18.
 **/
public class DifferenceRecord {

    private long id;

    private String name;

    private BigDecimal qty;

    private BigDecimal init;

    private boolean profitOrLoss;

    public DifferenceRecord(){

    }

    public DifferenceRecord(long id, String name, BigDecimal qty, BigDecimal init, boolean profitOrLoss){
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.init = init;
        this.profitOrLoss = profitOrLoss;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getInit() {
        return init;
    }

    public void setInit(BigDecimal init) {
        this.init = init;
    }

    public boolean isProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(boolean profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }

    @Override
    public String toString() {
        return "DifferenceRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", init=" + init +
                ", profitOrLoss=" + profitOrLoss +
                '}';
    }
}

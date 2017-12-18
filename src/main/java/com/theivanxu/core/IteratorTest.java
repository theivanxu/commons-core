package com.theivanxu.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xushaonan on 2017/12/15.
 **/
public class IteratorTest {

    public static void main(String[] args) {
        List<Warehouse> result = new ArrayList<>();
        Warehouse warehouse1 = new Warehouse(1L, "北京仓库", "20171124", 1, 3.9);
        Warehouse warehouse2 = new Warehouse(2L, "天津仓库", "20171125", 2, 3.9);
        Warehouse warehouse3 = new Warehouse(3L, "河北仓库", "20171126", 3, 3.9);

        result.add(warehouse1);
        result.add(warehouse2);
        result.add(warehouse3);

        
    }
}

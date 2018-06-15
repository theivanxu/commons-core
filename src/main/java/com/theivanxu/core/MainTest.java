package com.theivanxu.core;

import java.util.*;

/**
 * Created by xushaonan on 2017/11/24.
 **/
public class MainTest
{

    public static void main(String[] args) {
/*        List<Warehouse> result = new ArrayList<>();
        Warehouse warehouse1 = new Warehouse(1L, "北京仓库", "20171124", 1, 3.9);
        Warehouse warehouse2 = new Warehouse(2L, "北京仓库", "20171125", 1, 2.9);
        Warehouse warehouse3 = new Warehouse(3L, "天津仓库", "20171124", 1, 1.9);
        Warehouse warehouse4 = new Warehouse(4L, "河北仓库", "20171124", 1, 3.9);
        Warehouse warehouse5 = new Warehouse(5L, "北京仓库", "20171124", 1, 1.9);
        Warehouse warehouse6 = new Warehouse(6L, "天津仓库", "20171124", 1, 2.9);

        result.add(warehouse1);
        result.add(warehouse2);
        result.add(warehouse3);
        result.add(warehouse4);
        result.add(warehouse5);
        result.add(warehouse6);
        TreeSet<Warehouse> warehousetreeSet = new TreeSet<>(new Comparator<Warehouse>() {
            @Override
            public int compare(Warehouse o1, Warehouse o2) {
                return o1.getName().compareTo(o2.getName()) + o1.getSerial().compareTo(o2.getSerial());
            }
        });
        warehousetreeSet.addAll(result);
        System.out.println("list: " + result);
        System.out.println("set: " + warehousetreeSet);

        for (Warehouse warehouse :
                result) {
            System.out.println(warehouse.getId() + " --- " + warehousetreeSet.contains(warehouse));
        }

        Map<String, List<Warehouse>> map = getSeparators(result);
        System.out.println(map);

        Warehouse wh = new Warehouse(1L, "北京仓库", "20171126", 2, 3.9);
        System.out.println("end: " + wh + " --- " + warehousetreeSet.contains(wh));


        System.out.println(" ------------- " + getUniqueness(result) + " --------------- ");
        List<Warehouse> warehouses = new ArrayList<>(warehousetreeSet);

        System.out.println("result: " + warehouses);*/

        String str = "111,222,333,444,555,111,333";
        String out = wipeOffString(str).toString();
        System.out.println(out);
    }

    private static List<Warehouse> getUniqueness(List<Warehouse> list){
        Map<String, Warehouse> temp = new LinkedHashMap<>();

        for (Warehouse warehouse :
                list) {
            Warehouse wh = temp.put(warehouse.getName() + "-" + warehouse.getSerial(), warehouse);
            if (wh != null){
                warehouse.setQuantity(wh.getQuantity() + warehouse.getQuantity());
            }
        }

        return new ArrayList<>(temp.values());
    }

    private static Map<String, List<Warehouse>> getSeparators(List<Warehouse> list){
        Map<String, List<Warehouse>> temp = new LinkedHashMap<>();

        for (Warehouse warehouse :
                list) {
            String key = warehouse.getName() + "&" + warehouse.getSerial();
            if (temp.containsKey(key)){
                temp.get(key).add(warehouse);
            } else {
                temp.put(key, new ArrayList<Warehouse>(){{add(warehouse);}});
            }
        }

        return temp;
    }

    private static String wipeOffString(String str) {
        String[] arr = str.split(",");
        Set<String> tmp = new HashSet<>();
        for (String s : arr) {
            tmp.add(s);
        }
        return tmp.toString();
    }


}

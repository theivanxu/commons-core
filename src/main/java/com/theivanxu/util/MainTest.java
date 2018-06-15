package com.theivanxu.util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by theivanxu on 2018/5/4.
 */
public class MainTest {

    public static void main(String[] args) {
//        List<String> seasons = Arrays.asList("SPRING", "SUMMER");
//        for (String s : seasons){
//            SeasonEnum season = SeasonEnum.valueOf(s);
//            System.out.println(season.getValue());
//        }

        System.out.println(SeasonEnum.parse(new Integer("1")));
    }
}

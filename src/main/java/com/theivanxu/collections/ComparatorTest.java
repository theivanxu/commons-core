package com.theivanxu.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by xushaonan on 2018/2/7.
 **/
public class ComparatorTest {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Ivan", "destiny", "2018-01-01", new Date()));
        list.add(new Student(2, null, "111", "2017-01-01", new Date()));
        list.add(new Student(4, "Henry", "222", "2017-01-01", null));
        list.add(new Student(5, "Henry", "333", "2017-05-01", new Date()));
        list.add(new Student(3, "Mimosa", "222", "2016-01-01", new Date()));

        list.sort(metadataComparator);

        System.out.println(list);

    }

    private static Comparator<String> nullSafeStringComparator = Comparator.nullsLast(String::compareTo);

    private static Comparator<Date> nullSafeDateComparator = Comparator.nullsLast(Date::compareTo);

    private static Comparator<Student> metadataComparator = Comparator
            .comparing(Student::getName, nullSafeStringComparator)
            .thenComparing(Student::getDescription, nullSafeStringComparator)
            .thenComparing(Student::getTime, nullSafeStringComparator)
            .thenComparing(Student::getDate, nullSafeDateComparator);

}

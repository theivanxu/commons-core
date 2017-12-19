package com.theivanxu.core;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by xushaonan on 2017/12/18.
 **/
public class HedgeAlgorithmTest {

    public static void main(String[] args) {
        List<DifferenceRecord> list = new ArrayList<DifferenceRecord>();
        DifferenceRecord record1 = new DifferenceRecord(1, "记录1", BigDecimal.valueOf(1), BigDecimal.valueOf(1), false);
        DifferenceRecord record2 = new DifferenceRecord(2, "记录2", BigDecimal.valueOf(2), BigDecimal.valueOf(2), false);
        DifferenceRecord record3 = new DifferenceRecord(3, "记录3", BigDecimal.valueOf(3), BigDecimal.valueOf(3), false);
        DifferenceRecord record4 = new DifferenceRecord(4, "记录4", BigDecimal.valueOf(4), BigDecimal.valueOf(4), true);
        DifferenceRecord record5 = new DifferenceRecord(5, "记录5", BigDecimal.valueOf(5), BigDecimal.valueOf(5), false);
        DifferenceRecord record6 = new DifferenceRecord(6, "记录6", BigDecimal.valueOf(6), BigDecimal.valueOf(6),true);
        DifferenceRecord record7 = new DifferenceRecord(7, "记录7", BigDecimal.valueOf(7), BigDecimal.valueOf(7), true);
        DifferenceRecord record8 = new DifferenceRecord(8, "记录8", BigDecimal.valueOf(8), BigDecimal.valueOf(8), false);
        DifferenceRecord record9 = new DifferenceRecord(9, "记录9", BigDecimal.valueOf(9), BigDecimal.valueOf(9), false);
        DifferenceRecord record10 = new DifferenceRecord(10, "记录10", BigDecimal.valueOf(10), BigDecimal.valueOf(10), false);

        list.add(record1);
        list.add(record2);
        list.add(record3);
        list.add(record4);
        list.add(record5);
        list.add(record6);
        list.add(record7);
        list.add(record8);
        list.add(record9);
        list.add(record10);

        System.out.println(new HedgeAlgorithmTest().hedgeResultCollection(list));



    }

    private List<DifferenceRecord> hedgeResultCollection(List<DifferenceRecord> list){
        List<DifferenceRecord> profit = new ArrayList<DifferenceRecord>();
        List<DifferenceRecord> loss = new ArrayList<DifferenceRecord>();
        BigDecimal profitNumber = BigDecimal.ZERO;
        BigDecimal lossNumber = BigDecimal.ZERO;

        for (DifferenceRecord record : list) {
            if (record.isProfitOrLoss()) {
                profit.add(record);
                profitNumber = profitNumber.add(record.getInit());
            } else {
                loss.add(record);
                lossNumber = lossNumber.add(record.getInit());
            }
        }

        List<DifferenceRecord> unmodifies = new ArrayList<DifferenceRecord>();

        BigDecimal difference = profitNumber.subtract(lossNumber);

        System.out.println("difference---" + difference);

        if (BigDecimal.ZERO.compareTo(difference) == 0) {

            // TODO: 17/12/19 所有盈亏差异采取完全关闭

        } else if (BigDecimal.ZERO.compareTo(difference) == -1) {
            // sort profit
            dispelUnmodifiedRecord(profit, difference);
            // TODO: 17/12/19 余下盘盈差异部分完全关闭,可以有一个部分关闭,不在列表中无状态修改
        } else if (BigDecimal.ZERO.compareTo(difference) == 1) {
            // sort loss
            loss.sort(Comparator.comparing(DifferenceRecord::getInit).reversed());
            System.out.println("loss----" + loss);
            Iterator iterator = loss.listIterator();
            boolean flag = true;
            while(iterator.hasNext() && flag){
                DifferenceRecord rc = (DifferenceRecord) iterator.next();
                difference = difference.add(rc.getInit());
                if (BigDecimal.ZERO.compareTo(difference) == 0) {
                    unmodifies.add(rc);
                    iterator.remove();
                    flag = false;
                } else if (BigDecimal.ZERO.compareTo(difference) == -1) {
                    rc.setQty(difference);
                    flag = false;
                } else if (BigDecimal.ZERO.compareTo(difference) == 1) {
                    unmodifies.add(rc);
                    iterator.remove();
                }
            }
            // TODO: 17/12/19 余下盘亏差异大部分完全关闭,可以有一个部分关闭,不在列表中无状态修改
        }

        System.out.println("profit--result--" + profit);
        System.out.println("loss--result--" + loss);


        return unmodifies;
    }

    private void dispelUnmodifiedRecord(List<DifferenceRecord> list, BigDecimal difference){
        list.sort(Comparator.comparing(DifferenceRecord::getInit).reversed());

        Iterator iterator = list.listIterator();
        boolean flag = true;
        while(iterator.hasNext() && flag){
            DifferenceRecord rc = (DifferenceRecord) iterator.next();
            difference = difference.subtract(rc.getInit());
            if (BigDecimal.ZERO.compareTo(difference) == 0) {
                iterator.remove();
                flag = false;
            } else if (BigDecimal.ZERO.compareTo(difference) == -1) {
                iterator.remove();
            } else if (BigDecimal.ZERO.compareTo(difference) == 1) {
                rc.setQty(difference.add(rc.getInit()));
                flag = false;
            }
        }
    }

}

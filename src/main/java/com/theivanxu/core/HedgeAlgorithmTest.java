package com.theivanxu.core;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by xushaonan on 2017/12/18.
 **/
public class HedgeAlgorithmTest {

    public static void main(String[] args) {
        List<DifferenceRecord> list = new ArrayList<DifferenceRecord>();
        DifferenceRecord record1 = new DifferenceRecord(1, "记录1", BigDecimal.valueOf(1), BigDecimal.valueOf(1), true);
        DifferenceRecord record2 = new DifferenceRecord(2, "记录2", BigDecimal.valueOf(2), BigDecimal.valueOf(2), false);
        DifferenceRecord record3 = new DifferenceRecord(3, "记录3", BigDecimal.valueOf(3), BigDecimal.valueOf(3), false);
        DifferenceRecord record4 = new DifferenceRecord(4, "记录4", BigDecimal.valueOf(4), BigDecimal.valueOf(4), true);
        DifferenceRecord record5 = new DifferenceRecord(5, "记录5", BigDecimal.valueOf(5), BigDecimal.valueOf(5), false);
        DifferenceRecord record6 = new DifferenceRecord(6, "记录6", BigDecimal.valueOf(6), BigDecimal.valueOf(6),true);
        DifferenceRecord record7 = new DifferenceRecord(7, "记录7", BigDecimal.valueOf(7), BigDecimal.valueOf(7), true);
        DifferenceRecord record8 = new DifferenceRecord(8, "记录8", BigDecimal.valueOf(8), BigDecimal.valueOf(8), false);
        DifferenceRecord record9 = new DifferenceRecord(9, "记录9", BigDecimal.valueOf(9), BigDecimal.valueOf(9), false);
        DifferenceRecord record10 = new DifferenceRecord(10, "记录10", BigDecimal.valueOf(10), BigDecimal.valueOf(10), true);



    }

    public List<DifferenceRecord> hedgeResultCollection(List<DifferenceRecord> list){
        List<DifferenceRecord> profit = new ArrayList<DifferenceRecord>();
        List<DifferenceRecord> loss = new ArrayList<DifferenceRecord>();
        BigDecimal profitNumber = BigDecimal.ZERO;
        BigDecimal lossNumber = BigDecimal.ZERO;

        for (DifferenceRecord record : list) {
            if (record.isProfitOrLoss()) {
                profit.add(record);
                profitNumber.add(record.getInit());
            } else {
                loss.add(record);
                lossNumber.add(record.getInit());
            }
        }

        List<DifferenceRecord> unmodifies = new ArrayList<DifferenceRecord>();

        BigDecimal difference = profitNumber.subtract(lossNumber);

        if (BigDecimal.ZERO.compareTo(difference) == 0) {

        } else if (BigDecimal.ZERO.compareTo(difference) == -1) {
            // sort profit
            profit.sort(Comparator.comparing(DifferenceRecord::getInit));
            System.out.println("profit" + profit);

            Iterator iterator = profit.listIterator();
            boolean flag = true;
            while(iterator.hasNext() && flag){
                DifferenceRecord rc = (DifferenceRecord) iterator.next();
                if (BigDecimal.ZERO.compareTo(difference.subtract(rc.getInit())) == 0) {
                    unmodifies.add(rc);
                    iterator.remove();
                    flag = false;
                } else if (BigDecimal.ZERO.compareTo(difference.subtract(rc.getInit())) == -1) {
                    unmodifies.add(rc);
                    iterator.remove();
                } else if (BigDecimal.ZERO.compareTo(difference.subtract(rc.getInit())) == 1) {
                    rc.setInit(rc.getInit().subtract(difference));
                    flag = false;
                }
            }
        } else if (BigDecimal.ZERO.compareTo(difference) == 1) {
            // sort loss
            loss.sort(Comparator.comparing(DifferenceRecord::getInit));
            System.out.println("loss----" + loss);
            Iterator iterator = loss.listIterator();
            boolean flag = true;
            while(iterator.hasNext() && flag){
                DifferenceRecord rc = (DifferenceRecord) iterator.next();
                if (BigDecimal.ZERO.compareTo(difference.abs().subtract(rc.getInit())) == 0) {
                    unmodifies.add(rc);
                    iterator.remove();
                    flag = false;
                } else if (BigDecimal.ZERO.compareTo(difference.abs().subtract(rc.getInit())) == -1) {
                    unmodifies.add(rc);
                    iterator.remove();
                } else if (BigDecimal.ZERO.compareTo(difference.subtract(rc.getInit())) == 1) {
                    rc.setInit(rc.getInit().subtract(difference));
                    flag = false;
                }
            }
        }

        return null;
    }

}

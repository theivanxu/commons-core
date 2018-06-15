package com.theivanxu.algorithm;

import static java.lang.Math.abs;

/**
 * Created by theivanxu on 2018/6/5.
 */
public class MathSqrt {

    public static float SqrtByBisetion(float param) {

        if (param < 0) {
            return param;
        }

        float mid, last;
        float low, up;

        low = 0;
        up = param;
        mid = (low + up) / 2;
        do {
            if (mid * mid > param) {
                up = mid;
            } else {
                low = mid;
            }
            last = mid;
            mid = (up + low) / 2;
        } while (abs(mid - last) > 0);

        return mid;

    }

}

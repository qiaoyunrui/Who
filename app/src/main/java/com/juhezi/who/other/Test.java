package com.juhezi.who.other;

import com.juhezi.who.main.random.CountRandom;

/**
 * 测试类
 *
 * Created by qiao1 on 2016/10/1.
 */
public class Test {

    public static void main(String[] args) {

        CountRandom random = (CountRandom) new CountRandom.Builder()
                .setSeed(System.currentTimeMillis())
                .setLowRange(0)
                .setUpRange(100)
                .build();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " > " + random.next());
        }
    }

}

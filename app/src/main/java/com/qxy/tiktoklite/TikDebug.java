package com.qxy.tiktoklite;

import java.util.Random;

public class TikDebug {

    Random random = new Random();
    int val = 10;

    public void setVal(int val) {
        this.val =val;
    }

    public int nextInt(int val) {
        return random.nextInt(val) + 2;
    }

    public int nextInt() {
        return random.nextInt(val) + 2;
    }

    public String nextString(int val) {
        return new Integer(random.nextInt(val)).toString();
    }

    public String nextString() {
        return new Integer(random.nextInt(val)).toString();
    }

}

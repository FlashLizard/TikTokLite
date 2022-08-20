package com.qxy.tiktoklite;

public enum Male {
    NULL(0),
    MALE(1),
    FEMALE(2);

    private int id;
    private Male(int id){ this.id = id;}
    public static Male toMale(int x) {
        switch (x) {
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            default:
                return NULL;
        }
    }
}

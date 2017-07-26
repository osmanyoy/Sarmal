package com.training.spring.customer;

public enum EAccountType implements IAccountType{
    TL(1,
       "TL Döviz Hesabı"){

        @Override
        public String test() {
            return "benim test methodum : " + getExplain();
        }
    },
    DOLAR(2,
                                 "DOLAR Döviz Hesabı"),
    EURO(3,
                                                             "TL Döviz Hesabı");

    private int    index;
    private String desc;

    private EAccountType(int index,
                         String desc) {

        this.index = index;
        this.desc = desc;
    }

    public String test() {
        return "test : " + desc;
    }

    @Override
    public String getExplain() {
        return "My explainiasd" + desc;
    }
}

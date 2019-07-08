package com.zh.model;

import com.zh.axe.Axe;

public class Person {

    // 使用哪个斧头，铁斧？石斧？
    private Axe axe;

    public Axe getAxe() {
        return axe;
    }

    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public void useAxe() {
        System.out.println(axe.chop());
    }

}

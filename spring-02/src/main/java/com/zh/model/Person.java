package com.zh.model;

import com.zh.axe.Axe;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("person")
public class Person {

    // 使用哪个斧头，铁斧？石斧？
    @Resource(name="stone")
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

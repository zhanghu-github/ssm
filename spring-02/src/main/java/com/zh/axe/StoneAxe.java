package com.zh.axe;

import org.springframework.stereotype.Component;

@Component("stone")
public class StoneAxe implements Axe{

    public String chop(){
        return "石斧~~砍柴";
    }

}

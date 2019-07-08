package com.zh.axe;

import org.springframework.stereotype.Component;

@Component("iron")
public class IronAxe implements Axe{

    public String chop(){
        return "铁斧~~~砍柴";
    }
    
}

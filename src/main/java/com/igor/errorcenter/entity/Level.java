package com.igor.errorcenter.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Level {

    ERROR("error"),
    WARNING("warning"),
    INFO("info");

    private String level;

    Level(String level){
        this.level = level;
    }

//    public String getLevel(){
//        return level;
//    }

    public String getName(){
        return name();
    }
}

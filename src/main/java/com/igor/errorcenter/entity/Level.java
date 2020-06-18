package com.igor.errorcenter.entity;

public enum Level {

    ERROR("error"),
    WARNING("warning"),
    INFO("info");

    private String level;

    Level(String level){
        this.level = level;
    }

    public String getLevel(){
        return level;
    }
}

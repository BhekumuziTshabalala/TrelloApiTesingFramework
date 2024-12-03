package org.bhekumuzi;

public class Board {
    private final String name;
    private String desc;

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}

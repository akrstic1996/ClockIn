package org.krstic.model;

public class Task {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public kTime getTime() {
        return time;
    }

    public void setTime(kTime time) {
        this.time = time;
    }

    private String name;
    private kTime time;
}

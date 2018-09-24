package com.codeko.java9.reactive;

import lombok.Data;

@Data
public class Freelancer extends Employee {

    private int fid;

    public Freelancer(int id, int fid, String name) {
        super(id, name);
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "[id="+super.getId()+",name="+super.getName()+",fid="+fid+"]";
    }
}

package com.genshinItalia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="streammers")
public class Streammer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String link;

    private Streammer() {}

    public String getName() {
        return this.name;
    }

    public String getLink() {
        return this.link;
    }
}

package com.example.WebApp.CRUD1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Entity
//@Scope("prototype")
public class Alien {
    @Id
    private int aid;
    private String aname;
    private String tech;

    public Alien() {
//        System.out.println("From Constructor");
    }

    public Alien(int aid, String aname, String tech) {
        this.aid = aid;
        this.aname = aname;
        this.tech = tech;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void show()
    {
        System.out.println("Show from Alien class");
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}

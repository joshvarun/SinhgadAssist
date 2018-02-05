package com.varun.project;

/**
 * Created by User on 23-Mar-17.
 */

public class Candidate {
    public String name;
    public int cet;
    public float hsc;
    public String sex;
    public String caste;

    public Candidate(){}

    public Candidate(String name, String sex, int cet, float hsc, String caste){
        this.name = name;
        this.sex = sex;
        this.cet = cet;
        this.hsc = hsc;
        this.caste = caste;
    }

    public String getName() {
        return name;
    }
    public int getCet() {
        return cet;
    }
    public float getHsc(){
        return hsc;
    }
    public String getSex() {
        return sex;
    }
    public String getCaste() {
        return caste;
    }

}

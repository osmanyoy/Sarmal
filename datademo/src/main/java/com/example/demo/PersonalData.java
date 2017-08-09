package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonalData {
    @Column(nullable = true)
    private EGender gender;
    @Column(name = "xyz",nullable = true)
    private int height;
    @Column(nullable = true)
    private int weight;

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

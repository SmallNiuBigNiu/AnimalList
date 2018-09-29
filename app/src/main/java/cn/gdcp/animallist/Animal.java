package cn.gdcp.animallist;

import java.io.Serializable;

/**
 * Created by acer on 2018/9/29.
 */

public class Animal implements Serializable {
    private String name;
    private int animalId;

    Animal(String name,int animalId){
        this.name=name;
        this.animalId=animalId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", animalId=" + animalId +
                '}';
    }
}

package com.company;

@UnicColor
public class Marmelad extends Sweet{

    String color;
    String string;



    public Marmelad() {
        this.color= "green";
        this.string ="example";
        super.name = "marmelad";
        super.weight=1f;
        super.price=100f;
    }

    public Marmelad(String string) {
        this.color = "blue";
        this.string = string;
    }

    public Marmelad (String color, String string, String name) {
        this.color = color;
        this.string = string;
        super.name = name;
        super.weight=1f;
        super.price=100f;

    }

    public String getColor() {
        return color;
    }

    public String getString() {
        return string;
    }
}

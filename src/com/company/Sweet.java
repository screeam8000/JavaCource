package com.company;

public class Sweet {

    String name;
    Float weight, price;

    public void print() {
        System.out.println(name + " " + price + " " + weight);
    }

    public Sweet(String name, Float weight, Float price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Sweet(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Sweet() {
        this.name = "defaultName";
        this.weight = 10000000f;
        this.price = 9999999f;
    }

    public String getName() {
        return name;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
    //  Если сделать переменные приватными, создать для них конструкторы, геттеры и сеттеры, то как можно юудет с ними работать в рамках конкретных сладостей

}

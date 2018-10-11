package com.company;

@UnicPercentage
public class Chocolate extends Sweet {

    Integer percengeOfChocolate;

    public Chocolate() {

    }

//    @Override
//    public void print() {
//        super.print();
//        System.out.println("percengeOfChocolate " + percengeOfChocolate);
//    }

    public Chocolate(Integer percengeOfChocolate, String name, Float price) {

        super(name, price);
        this.percengeOfChocolate = percengeOfChocolate;
        super.weight=0.5f;
    }

    public Chocolate(Integer percengeOfChocolate) {
        this.percengeOfChocolate = percengeOfChocolate;
    }

    public Integer getPercengeOfChocolate() {
        return percengeOfChocolate;
    }
}


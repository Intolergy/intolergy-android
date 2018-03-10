package com.intolergy.intolergy.product;

public class Product {
    String name;
    int gtin;
    String user;
    String[] intolerances;
    String image;
    int positive;
    int negative;

    public Product(String name, int gtin, String user, String[] intolerances, String image, int positive, int negative){
        this.name=name;
        this.gtin=gtin;
        this.user=user;
        this.intolerances=intolerances;
        this.image=image;
        this.positive=positive;
        this.negative=negative;
    }
}

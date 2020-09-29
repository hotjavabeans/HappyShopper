package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PickListItem {
    protected String name;
    protected String description;
    protected double price;
//  String imageURL; need to be stored in DB?

    public PickListItem(String n, String d, double p) {
        name = setName(n);
        description = setDescription(d);
        price = setPrice(p);
    }
    public String getName () {
        return name;
    }
    //This method formats the item name correctly
    private String setName(String n) {
        n = n.toLowerCase();
        n = n.substring(0, 1).toUpperCase()+n.substring(1);
        return n;
    }
    //This method formats the description correctly
    private String setDescription(String d) {
        d = name.toLowerCase();
        d = d.substring(0, 1).toUpperCase()+d.substring(1);
        return d;
    }
    //THis method formats the price correctly using £
    private double setPrice(double p) {
        DecimalFormat fmtPounds = new DecimalFormat("£###,##0.00");
        return p;
    }
}

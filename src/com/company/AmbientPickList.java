package com.company;

public class AmbientPickList implements PickList {

    AmbientPickList() {

    }

    @Override
    public void createPickList() {
        System.out.println("Creating Ambient PickList...");
    }
}

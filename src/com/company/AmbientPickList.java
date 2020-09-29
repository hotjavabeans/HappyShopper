package com.company;

public class AmbientPickList extends PickList {

    //Should I use a constructor instead of a method to notify creating a picklist?
    //But wouldn't that force me to use 'new' and defeat purpose of loose coupling?
    //In final version, picklists will not be created at runtime, instead pulled from a DB.


    public void createPickList() {
        System.out.println("Creating Ambient PickList...");
    }
}

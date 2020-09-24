package com.company;

import java.util.ArrayList;

public class HappyShopperModel implements ModelInterface {
    ArrayList<PickListObserver> pickListObservers = new ArrayList<>();
    ArrayList<PickList> ambientPickLists = new ArrayList<>();

    @Override
    public void initialize() {

    }

    @Override
    public int getNumOfPickLists() {
        return 0;
        //return pickListArrayList.size??
    }

    @Override
    public void registerObserver(PickListObserver o) {

    }

    @Override
    public void removeObserver(PickListObserver o) {

    }
}

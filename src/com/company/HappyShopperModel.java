package com.company;

import java.util.ArrayList;

public class HappyShopperModel implements ModelInterface {
    ArrayList<PickListObserver> pickListObservers = new ArrayList<>();
    ArrayList<PickListFactory> ambientPickLists = new ArrayList<>();
    ArrayList<PickListFactory> chilledPickLists = new ArrayList<>();
    ArrayList<PickListFactory> frozenPickLists = new ArrayList<>();
    ArrayList<PickListFactory> producePickLists = new ArrayList<>();


    @Override
    public void initialize() {

    }

    @Override
    public int getNumOfPickLists(String pickListType) {
        int numOfPickLists = 0;
        switch (pickListType) {
            case "ambient":
                numOfPickLists = ambientPickLists.size();
                break;
            case "chilled":
                numOfPickLists =  chilledPickLists.size();
                break;
            case "frozen":
                numOfPickLists =  frozenPickLists.size();
                break;
            case "produce":
                numOfPickLists = producePickLists.size();
                break;
        }
        return numOfPickLists;
    }

    @Override
    public void registerObserver(PickListObserver o) {

    }

    @Override
    public void removeObserver(PickListObserver o) {

    }
}

package com.company;

import java.util.ArrayList;

public class HappyShopperModel implements ModelInterface {
    ArrayList<PickListObserver> pickListObservers = new ArrayList<>();
    ArrayList<PickList> ambientPickLists = new ArrayList<>();

    @Override
    public void initialize() {

    }

//    @Override
//    public PickList getPickListType(String pickListType) {
//        PickList pickList = null;
//        switch (pickListType) {
//            case "ambient":
//                pickList = new AmbientPickList();
//                break;
//            case "chilled":
//                pickList = new ChilledPickList();
//                break;
//            case "frozen":
//                pickList = new FrozenPickList();
//                break;
//            case "produce":
//                pickList = new ProducePickList();
//                break;
//        }
//        return pickList;
//    }

    @Override
    public void add(PickList pickList) {
        ambientPickLists.add(pickList);
        pickListEvent();
//      WILL NEED TO SPECIFY WHICH TYPE OF PICKLIST - NEED A GETTER FOR PICKLIST TYPE??
//      OR MAKE ARRAYLIST SPECIFIC TYPE OF PICKLIST?? - eg AmbientPickList/ChilledPickList etc
    }

    @Override
    public int getNumOfPickLists(String pickListType) {
        return ambientPickLists.size();
    }

    @Override
    public void registerObserver(PickListObserver o) {
        pickListObservers.add(o);
    }

    @Override
    public void removeObserver(PickListObserver o) {
        int i = pickListObservers.indexOf(o);
        if (i >= 0) {
            pickListObservers.remove(i);
        }
    }

    public void pickListEvent() {
        notifyObservers();
    }

    public void notifyObservers() {
        for (int i = 0; i < pickListObservers.size(); i++) {
            PickListObserver observer = (PickListObserver)pickListObservers.get(i);
            observer.updatePickLists();
        }
    }
}

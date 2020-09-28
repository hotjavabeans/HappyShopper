package com.company;

public interface ModelInterface {
//    PickList getPickListType(String pickListType);
    void add(PickList pickList);
    int getNumOfPickLists(String pickListType);
    void registerObserver(PickListObserver o);
    void removeObserver(PickListObserver o);
}

package com.company;

public interface ModelInterface {
    void initialize();

    int getNumOfPickLists(String pickListType);
    void registerObserver(PickListObserver o);
    void removeObserver(PickListObserver o);
}

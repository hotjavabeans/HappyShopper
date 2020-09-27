package com.company;

public interface ModelInterface {
    void initialize();

    int getNumOfPickLists();
    void registerObserver(PickListObserver o);
    void removeObserver(PickListObserver o);
}

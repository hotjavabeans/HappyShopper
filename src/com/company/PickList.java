package com.company;

public abstract class PickList {
    String name;
    void createPickList() {
        //Was originally an Interface. Should it be an abstract class or interface?
        //As an abstract class I have to subclass it, but as an Interface does it have more flexibility?
        //PickList HAS-A PickListItem. I think that means I should make it an interface?
    }
    public String getName() {
        return name;
    }
}

package com.company;

public class PickListFactory {
    //use CONSTANTS instead??

    public PickList getPickList(String pickListType)
        throws PickListTypeNotFoundException {

        if (pickListType == null) {
            return null;
        }
        PickList pickList = null;

        switch (pickListType) {
            case "ambient":
                pickList = new AmbientPickList();
                break;
            case "chilled":
                pickList = new ChilledPickList();
                break;
            case "frozen":
                pickList = new FrozenPickList();
                break;
            case "produce":
                pickList = new ProducePickList();
                break;
            default:
                throw new PickListTypeNotFoundException("Invalid picklist type: " + pickListType);
        }
        return pickList;
    }
}

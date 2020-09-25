package com.company;

public class PickListFactory {
    final String AMBIENT = "ambient";


    public PickList getPickList(String pickListType)
        throws PickListTypeNotFoundException {

        //MAKE A PICKLIST FACTORY

        if (pickListType == null) {
            return null;
        }
        PickList pickList = null;

        switch (pickListType) {
            case "ambient":
                pickList = new AmbientPickList();
                break;
            default:
                throw new PickListTypeNotFoundException("Invalid picklist type: " + pickListType);
                //other cases: CHILLED, FROZEN & PRODUCE
        }
        return pickList;
    }
}

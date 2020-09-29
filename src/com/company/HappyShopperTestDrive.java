package com.company;

public class HappyShopperTestDrive {

    public static void main(String[] args) {
//        PickListItem item1 = new PickListItem("Bread", "WR Brown Bread", 1.00);
//        PickListItem item2 = new PickListItem("Eggs", "WR Free Range Eggs", 1.10);
//        PickListItem item3 = new PickListItem("Butter", "WR Olive Spread", 1.20);
//
//        ArrayList<PickListItem> aList = new ArrayList<>();
//        aList.add(item1);
//        aList.add(item2);
//        aList.add(item3);
//
//        for (int i = 0; i < aList.size(); i++) {
//            System.out.println(aList.get(i).getName());
//        }
        ModelInterface model = new HappyShopperModel();
        ControllerInterface controller = new HappyShopperController(model);

        String pickListType = "ambient";
        for (int i = 0; i < 5; i++) {
            PickListFactory factory = new PickListFactory();
            try {
                PickList pickList = factory.getPickList(pickListType);
                pickList.createPickList();
                model.add(pickList);
            } catch (PickListTypeNotFoundException e) {
                System.err.print(e);
            }
        }
    }
}

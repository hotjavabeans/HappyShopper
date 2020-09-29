package com.company;
import javax.swing.*;

public class HappyShopperController implements ControllerInterface {
    ModelInterface model;
    HappyShopperView view;

    final String AMBIENT = "Ambient ";
    //Should I be using constants here? or keep as literal strings?

    public HappyShopperController(ModelInterface model) {
        this.model = model;
        view = new HappyShopperView(this, model);
        view.createMainMenu();
    }

    @Override
    public void getAmbientPickList() {
        JOptionPane.showMessageDialog(null,
                                        "Retrieving ambient picklist...",
                                         "Ambient Picklist Selected",
                                        JOptionPane.WARNING_MESSAGE);
        view.createScanCratesUI();
    }

    public void getChilledPickList() {
        JOptionPane.showMessageDialog(null,
                "RETRIEVING CHILLED PICKLIST",
                "CHILLED PICKLIST SELECTED",
                JOptionPane.WARNING_MESSAGE);
        view.createScanCratesUI();
    }
    public void getFrozenPickList() {
        JOptionPane.showMessageDialog(null,
                "RETRIEVING FROZEN PICKLIST",
                "FROZEN PICKLIST SELECTED",
                JOptionPane.WARNING_MESSAGE);
        view.createScanCratesUI();
    }
    public void getProducePickList() {
        JOptionPane.showMessageDialog(null,
                "RETRIEVING PRODUCE PICKLIST",
                "PRODUCE PICKLIST SELECTED",
                JOptionPane.WARNING_MESSAGE);
        view.createScanCratesUI();
    }

}

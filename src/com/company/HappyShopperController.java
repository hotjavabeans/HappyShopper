package com.company;

import javax.swing.*;
import java.awt.*;

public class HappyShopperController implements ControllerInterface {
    ModelInterface model;
    HappyShopperView view;
    final String AMBIENT = "Ambient ";
    //more constants here

    public HappyShopperController(ModelInterface model) {
        this.model = model;
        view = new HappyShopperView(this, model);
        view.createMainMenu();
        model.initialize();
    }

    @Override
    public void getAmbientPickList() {
        JOptionPane.showMessageDialog(null,
                                        "RETRIEVING AMBIENT PICKLIST",
                                         "AMBIENT PICKLIST SELECTED",
                                        JOptionPane.WARNING_MESSAGE);
    }

    public void getChilledPickList() {
        JOptionPane.showMessageDialog(null,
                "RETRIEVING CHILLED PICKLIST",
                "CHILLED PICKLIST SELECTED",
                JOptionPane.WARNING_MESSAGE);
    }
    public void getFrozenPickList() {
        JOptionPane.showMessageDialog(null,
                "RETRIEVING FROZEN PICKLIST",
                "FROZEN PICKLIST SELECTED",
                JOptionPane.WARNING_MESSAGE);
    }
    public void getProducePickList() {
        JOptionPane.showMessageDialog(null,
                "RETRIEVING PRODUCE PICKLIST",
                "PRODUCE PICKLIST SELECTED",
                JOptionPane.WARNING_MESSAGE);
    }

}

package com.company;
import javax.swing.*;

public class HappyShopperController implements ControllerInterface {
    ModelInterface model;
    HappyShopperView view;

    final String AMBIENT = "Ambient ";
    //Should I be using constants here? or keep as literal strings? Does it matter?

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

    public void getPrinterLabels() {
        if (view.inputPrinterCode.getText().equals("01")) {
            JOptionPane.showMessageDialog(null,
                    "PRINTING LABELS",
                    "PRINTING LABELS",
                    JOptionPane.OK_OPTION);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Incorrect printer password entered...",
                    "Incorrect password",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void startPicking() {
        /* IF required amount of crates are scanned and not currently in use by another picklist, begin create
        * picking UI. Not sure how to implement this logic yet. */
        view.createPickingUI();
    }


}

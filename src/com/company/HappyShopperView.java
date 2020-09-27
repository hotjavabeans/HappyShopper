package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HappyShopperView implements ActionListener, PickListObserver {
    ControllerInterface controller;
    ModelInterface model;
    JFrame mainMenuFrame;
    JPanel mainMenuPanel;
    JLabel mainMenuHeader;
    JButton getAmbientButton;
    JButton getChilledButton;
    JButton getFrozenButton;
    JButton getProduceButton;
    JMenuBar mainMenuBar;
    JMenu mainMenuMenu;
    JMenuItem exitMenuItem;

    public HappyShopperView(ControllerInterface controller, ModelInterface model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver((PickListObserver)this);
    }

    public void createMainMenu() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        mainMenuPanel = new JPanel(new BorderLayout());
        mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(new Dimension(100, 80));

        mainMenuHeader = new JLabel("SELECT A PICKLIST:", SwingConstants.CENTER);
        mainMenuPanel.add(mainMenuHeader, BorderLayout.NORTH);
        mainMenuBar = new JMenuBar();
        mainMenuMenu = new JMenu("App Control");

        exitMenuItem = new JMenuItem("Quit");
        exitMenuItem.addActionListener(e -> System.exit(0));
        mainMenuBar.add(mainMenuMenu);
        mainMenuMenu.add(exitMenuItem);
        mainMenuFrame.setJMenuBar(mainMenuBar);


        //use iteration to addActionListeners??
        getAmbientButton = new JButton("AMBIENT : " + model.getNumOfPickLists("ambient"));
        getAmbientButton.addActionListener(this);
        getChilledButton = new JButton("CHILLED : " + model.getNumOfPickLists("chilled"));
        getChilledButton.addActionListener(this);
        getFrozenButton = new JButton("FROZEN : " + model.getNumOfPickLists("frozen"));
        getFrozenButton.addActionListener(this);
        getProduceButton = new JButton("PRODUCE : " + model.getNumOfPickLists("produce"));
        getProduceButton.addActionListener(this);

        //use iteration to add buttons to panel?
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(getAmbientButton);
        buttonPanel.add(getChilledButton);
        buttonPanel.add(getFrozenButton);
        buttonPanel.add(getProduceButton);
        mainMenuPanel.add(buttonPanel);

//        ArrayList<JButton> buttons = new ArrayList<>();
//        for (int i = 0; i < buttons.size(); i++) {
//            buttons.get(i).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        }
        mainMenuFrame.getRootPane().setDefaultButton(getAmbientButton);
        mainMenuFrame.getContentPane().add(mainMenuPanel);
        mainMenuFrame.pack();
        mainMenuFrame.setLocationRelativeTo(null);
        mainMenuFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getAmbientButton) {
            controller.getAmbientPickList();
        } else if (e.getSource() == getChilledButton) {
            controller.getChilledPickList();
        } else if (e.getSource() == getFrozenButton) {
            controller.getFrozenPickList();
        } else if (e.getSource() == getProduceButton) {
            controller.getProducePickList();
        }
    }

    @Override
    public void updatePickLists() {
        model.getNumOfPickLists("ambient");
    }
}

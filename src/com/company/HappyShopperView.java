package com.company;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.text.DefaultCaret;
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

    JFrame scanCratesFrame;
    JButton startPickingButton;
    JButton printLabelsButton;
    JTextField inputPrinterCode;

    JFrame pickingUI;
    JPanel pickingPanel;
    JPanel inputPanel;
    

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

        getAmbientButton = new JButton("AMBIENT PICKLISTS: " + model.getNumOfPickLists("ambient"));
        getAmbientButton.addActionListener(this);
        getChilledButton = new JButton("CHILLED PICKLISTS: " + model.getNumOfPickLists("chilled"));
        getChilledButton.addActionListener(this);
        getFrozenButton = new JButton("FROZEN PICKLISTS: " + model.getNumOfPickLists("frozen"));
        getFrozenButton.addActionListener(this);
        getProduceButton = new JButton("PRODUCE PICKLISTS: " + model.getNumOfPickLists("produce"));
        getProduceButton.addActionListener(this);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(getAmbientButton);
        buttonPanel.add(getChilledButton);
        buttonPanel.add(getFrozenButton);
        buttonPanel.add(getProduceButton);
        mainMenuPanel.add(buttonPanel);
//        mainMenuHeader.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        ArrayList<JButton> buttons = new ArrayList<>();
//        for (int i = 0; i < buttons.size(); i++) {
//            buttons.get(i).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//        }
        mainMenuFrame.getRootPane().setDefaultButton(getAmbientButton);
        mainMenuFrame.getContentPane().add(mainMenuPanel);
        mainMenuFrame.pack();
        mainMenuFrame.setLocationRelativeTo(null);
        mainMenuFrame.setVisible(true);
        mainMenuFrame.setResizable(false);
    }

    public void createScanCratesUI() {
        EventQueue.invokeLater(() -> {
            scanCratesFrame = new JFrame("Scan crates");
            scanCratesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            try
//            {
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setOpaque(true);
//                JTextArea textArea = new JTextArea(15, 50);
//                textArea.setWrapStyleWord(true);
//                textArea.setEditable(false);
//                textArea.setFont(Font.getFont(Font.SANS_SERIF));
//                JScrollPane scroller = new JScrollPane(textArea);
//                scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//                scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            JPanel inputPanel = new JPanel();
            inputPanel.setLayout(new FlowLayout());
            inputPrinterCode = new JTextField(20);
            inputPrinterCode.setText("01");
            startPickingButton = new JButton("Start Picking");
            startPickingButton.addActionListener(this);
            printLabelsButton = new JButton("Print Lables");
            printLabelsButton.addActionListener(this);
            JPanel crateListPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.HORIZONTAL;
            //crate quantity will be decided by size and weight of all items in picklist (fields not yet added)
            gbc.gridx = 0;
            gbc.gridy = 0;
            JLabel crate1 = new JLabel("crate 1 info here");
            crate1.setBorder(new EtchedBorder());
            crateListPanel.add(crate1, gbc);
            gbc.gridx = 0;
            gbc.gridy = 2;
            JLabel crate2 = new JLabel("crate 2 info here");
            crate2.setBorder(new EtchedBorder());
            crateListPanel.add(crate2, gbc);
            gbc.gridx = 0;
            gbc.gridy = 3;
            JLabel crate3 = new JLabel("crate 3 info here");
            crate3.setBorder(new EtchedBorder());
            crateListPanel.add(crate3, gbc);
            gbc.gridx = 0;
            gbc.gridy = 4;
            JLabel crate4 = new JLabel("crate 4 info here");
            crate4.setBorder(new EtchedBorder());
            crateListPanel.add(crate4, gbc);
            gbc.gridx = 0;
            gbc.gridy = 5;
            JLabel crate5 = new JLabel("crate 5 info here");
            crate5.setBorder(new EtchedBorder());
            crateListPanel.add(crate5, gbc);
            gbc.gridx = 0;
            gbc.gridy = 6;
            JLabel crate6 = new JLabel("crate 6 info here");
            crate6.setBorder(new EtchedBorder());
            crateListPanel.add(crate6, gbc);
            gbc.gridx = 0;
            gbc.gridy = 7;
            JLabel crate7 = new JLabel("crate 7 info here");
            crate7.setBorder(new EtchedBorder());
            crateListPanel.add(crate7, gbc);
            gbc.gridx = 0;
            gbc.gridy = 8;
            JLabel crate8 = new JLabel("crate 8 info here");
            crate8.setBorder(new EtchedBorder());
            crateListPanel.add(crate8, gbc);
//                DefaultCaret caret = (DefaultCaret) textArea.getCaret();
//                caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
//                panel.add(scroller);
            inputPanel.add(inputPrinterCode);
            inputPanel.add(printLabelsButton);
            inputPanel.add(startPickingButton);
            panel.add(crateListPanel);
            panel.add(inputPanel);
            scanCratesFrame.getContentPane().add(BorderLayout.CENTER, panel);
            scanCratesFrame.pack();
            scanCratesFrame.setLocationRelativeTo(null);
            scanCratesFrame.setVisible(true);
            scanCratesFrame.setResizable(false);
        });
    }

    public void createPickingUI() {
        pickingUI = new JFrame("Picking dashboard");
        pickingUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pickingPanel = new JPanel();
        pickingPanel.setLayout(new BorderLayout());
        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        pickingPanel.add(inputPanel);
//        pickingUI.getContentPane().add(BorderLayout.CENTER, pickingPanel);
        pickingUI.pack();
        pickingUI.setLocationRelativeTo(null);
        pickingUI.setVisible(true);
        pickingUI.setResizable(false);
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
        } else if (e.getSource() == printLabelsButton) {
            controller.getPrinterLabels();
        } else if (e.getSource() == startPickingButton) {
            controller.startPicking();
        }
    }

    @Override
    public void updatePickLists() {
        int numOfAmbientPickLists = model.getNumOfPickLists("ambient");
        getAmbientButton.setText("AMBIENT PICKLISTS: " + numOfAmbientPickLists);
//        int numOfChilledPickLists = model.getNumOfPickLists("chilled");
//        getChilledButton.setText("CHILLED PICKLISTS: " + numOfChilledPickLists);
    }
}

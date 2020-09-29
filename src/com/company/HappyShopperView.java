package com.company;

import javax.swing.*;
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
//        , BorderLayout.CENTER ^^
        mainMenuFrame.pack();
        mainMenuFrame.setLocationRelativeTo(null);
        mainMenuFrame.setVisible(true);
    }

    public void createScanCratesUI() {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame scanCratesFrame = new JFrame("Test");
                scanCratesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                try
                {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(true);
                JTextArea textArea = new JTextArea(15, 50);
                textArea.setWrapStyleWord(true);
                textArea.setEditable(false);
                textArea.setFont(Font.getFont(Font.SANS_SERIF));
                JScrollPane scroller = new JScrollPane(textArea);
                scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                JPanel inputpanel = new JPanel();
                inputpanel.setLayout(new FlowLayout());
                JTextField input = new JTextField(20);
                JButton button = new JButton("Enter");
                DefaultCaret caret = (DefaultCaret) textArea.getCaret();
                caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                panel.add(scroller);
                inputpanel.add(input);
                inputpanel.add(button);
                panel.add(inputpanel);
                scanCratesFrame.getContentPane().add(BorderLayout.CENTER, panel);
                scanCratesFrame.pack();
                scanCratesFrame.setLocationByPlatform(true);
                scanCratesFrame.setVisible(true);
                scanCratesFrame.setResizable(false);
                input.requestFocus();
            }
        });
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
        int numOfAmbientPickLists = model.getNumOfPickLists("ambient");
        getAmbientButton.setText("AMBIENT PICKLISTS: " + numOfAmbientPickLists);
//        int numOfChilledPickLists = model.getNumOfPickLists("chilled");
//        getChilledButton.setText("CHILLED PICKLISTS: " + numOfChilledPickLists);
    }
}

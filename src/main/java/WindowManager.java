package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowManager {

    JFrame displayWindow;

    JPanel updatePanel;
    JPanel mapPanel;

    JTextField userInputBox;

    JTextArea dateLocation;
    JTextArea statPanel;
    JTextArea updateTextArea;
    JTextArea mapTextArea;

    JSeparator screenSplit;

    JButton sendCommand;

    public WindowManager(){
        WindowInitializer();
    }

    private void WindowInitializer(){
        displayWindow = new JFrame();//creating instance of JFrame

        SpringLayout layout = new SpringLayout();
        Container contentPane = displayWindow.getContentPane();
        contentPane.setLayout(layout);

        displayWindow.setJMenuBar(CreateMenuBar());
        displayWindow.add(CreateDataMenu());
        //displayWindow.add(SplitScreen());
        displayWindow.add(CreateRightTabs());
        displayWindow.add(CreateDateArea());
        displayWindow.add(CreateUserTextField());
        displayWindow.add(CreateUserCommandButton());

        displayWindow.setSize(850,550);//400 width and 500 height
        displayWindow.setLayout(null);//using no layout managers
        displayWindow.setResizable(false);
        displayWindow.setVisible(true);
    }

    private JTextArea CreateDataMenu(){
        statPanel = new JTextArea("Test words in the left menu.", 500, 500 );
        statPanel.setBounds(10,10, 300, 400);
        statPanel.setBackground(Color.lightGray);
        statPanel.setEditable(false);
        return statPanel;
    }

    private JTextArea CreateDateArea(){
        this.dateLocation = new JTextArea("Date: ");
        dateLocation.setBounds(625, 10, 175, 75);
        dateLocation.setEditable(false);
        return dateLocation;
    }

    private JTabbedPane CreateRightTabs(){
        //JTextArea mapArea = new JTextArea(200,200);
        JTabbedPane rightTabbedPane= new JTabbedPane();
        updatePanel = new JPanel();
        mapPanel = new JPanel();
        updateTextArea = new JTextArea("Update text area");
        mapTextArea = new JTextArea("Map text area");
        updateTextArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        mapTextArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        updateTextArea.setEditable(false);
        mapTextArea.setEditable(false);
        updatePanel.add(updateTextArea);
        mapPanel.add(mapTextArea);
        //mapPanel.add(mapArea);

        rightTabbedPane.setBounds(320,10,500,400);
        rightTabbedPane.add("News", updatePanel);
        rightTabbedPane.add("Map", mapPanel);
        return rightTabbedPane;
    }

 /*   private JSeparator SplitScreen(){
        screenSplit = new JSeparator();
        screenSplit.setOrientation(SwingConstants.VERTICAL);
        return screenSplit;
    }*/

    private JTextField CreateUserTextField(){
        userInputBox = new JTextField("Your command...");
        userInputBox.setBounds(320, 410, 371, 25);



        return this.userInputBox;
    }

    private JButton CreateUserCommandButton(){
        sendCommand = new JButton("Send Command");
        sendCommand.setBounds(690, 410, 130, 25);

        sendCommand.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                userInputBox.setText("");
                //textfield.setText(null); //or use this
            }
        });

        return sendCommand;
    }

    private JMenuBar CreateMenuBar(){
        JMenu menu;
        JMenuItem quitButton;//, i2, i3;
        JMenuBar headerBar = new JMenuBar();
        menu=new JMenu("Menu");
        quitButton=new JMenuItem("Quit");

        quitButton.addActionListener(e -> System.exit(0));
        //i2=new JMenuItem("Item 2");
        //i3=new JMenuItem("Item 3");
        menu.add(quitButton);// menu.add(i2); menu.add(i3);
        headerBar.add(menu);
        return headerBar;
    }

    public JFrame GetWindow(){
        return this.displayWindow;
    }

    public void AppendStatPanelText(Object passedText){
        this.statPanel.append("" + passedText);
    }

    public void OverwriteStatPanelText(Object passedText){
        this.statPanel.setText("" + passedText);
    }

    public void AppendMapTab(Object passedText){
        this.mapTextArea.append("" + passedText);
    }

    public void OverwriteMapTab(Object passedText){
        this.mapTextArea.setText("" + passedText);
    }

    public void AppendUpdateTab(Object passedText){
        this.updateTextArea.append("" + passedText);
    }

    public void OverwriteUpdateTab(Object passedText){
        this.updateTextArea.setText("" + passedText);
    }

    public void AppendArrayToMap(Object[][] passedArray){
        for(int x = 0; x < passedArray.length; x++){
            for(int y = 0; y < passedArray[0].length; y++){
                this.mapTextArea.append("" + passedArray[x][y]);
            }
            this.mapTextArea.append(System.lineSeparator());
        }
    }

    public void UpdateDateText(String passedDate){
        this.dateLocation.setText("Date: " + passedDate);
    }

}

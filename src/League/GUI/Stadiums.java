package League.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stadiums extends JPanel implements ActionListener {
    JButton addStaduimButton;
    JButton editStaduimButton;
    JButton deleteStaduimButton;
    MainPanel main;
    CardLayout cardLayout;
    public Stadiums(MainPanel main, CardLayout cardLayout){
        this.main = main;
        this.cardLayout = cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(3, 1));
        JPanel addStaduimPanel = new JPanel(new GridLayout(1, 1));
        JPanel editStaduimPanel = new JPanel(new GridLayout(1, 1));
        JPanel deleteStaduimPanel = new JPanel(new GridLayout(1, 1));
        this.setVisible(true);
        //Add Team button
        addStaduimButton=new JButton("Add Staduim");
        addStaduimButton.setFocusable(false);
        ImageIcon addTeamIcon = new ImageIcon("src/Assets/add-team.png");
        addStaduimButton.setIcon(addTeamIcon);
        addStaduimButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        addStaduimButton.setIconTextGap(10);
        addStaduimButton.addActionListener(this);
        //Edit Team Button
        editStaduimButton=new JButton("Edit Staduim");
        editStaduimButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        editStaduimButton.setFocusable(false);
        editStaduimButton.addActionListener(this);
        ImageIcon editStaduimIcon =new ImageIcon("src/Assets/edit-team.png");
        editStaduimButton.setIcon(editStaduimIcon);
        editStaduimButton.setIconTextGap(10);
        //Delete Team Button
        deleteStaduimButton=new JButton("Delete Staduim");
        deleteStaduimButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        deleteStaduimButton.setFocusable(false);
        ImageIcon removeStaduimIcon =new ImageIcon("src/Assets/remove-team.png");
        deleteStaduimButton.setIcon(removeStaduimIcon);
        deleteStaduimButton.setIconTextGap(10);
        deleteStaduimButton.addActionListener(this);
        addStaduimPanel.add(addStaduimButton);
        editStaduimPanel.add(editStaduimButton);
        deleteStaduimPanel.add(deleteStaduimButton);
        this.add(addStaduimPanel);
        this.add(editStaduimPanel);
        this.add(deleteStaduimPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addStaduimButton){
            cardLayout.show(main,"AddStaduim");
        } else if (e.getSource() == editStaduimButton) {
            cardLayout.show(main,"EditStaduim");
        } else if (e.getSource() == deleteStaduimButton) {
            cardLayout.show(main,"DeleteStaduim");
        }
    }

}

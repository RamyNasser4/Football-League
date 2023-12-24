package League.GUI;

import League.Stadium.Stadium;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stadiums extends JPanel implements ActionListener {
    JButton addStadiumButton;
    JButton editStadiumButton;
    JButton deleteStadiumButton;
    MainPanel main;
    Stadium stadium;
    CardLayout cardLayout;
    public Stadiums(MainPanel main, CardLayout cardLayout){
        this.main = main;
        this.cardLayout = cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(3, 1));
        JPanel addStadiumPanel = new JPanel(new GridLayout(1, 1));
        JPanel editStadiumPanel = new JPanel(new GridLayout(1, 1));
        JPanel deleteStadiumPanel = new JPanel(new GridLayout(1, 1));
        this.setVisible(true);

        addStadiumButton=new JButton("Add Stadium");
        addStadiumButton.setFocusable(false);
        ImageIcon addStadiumIcon = new ImageIcon("src/Assets/Add-stadium.png");
        addStadiumButton.setIcon(addStadiumIcon);
        addStadiumButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        addStadiumButton.setIconTextGap(10);
        addStadiumButton.addActionListener(this);

        editStadiumButton=new JButton("Edit Stadium");
        editStadiumButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        editStadiumButton.setFocusable(false);
        editStadiumButton.addActionListener(this);
        ImageIcon editStadiumIcon =new ImageIcon("src/Assets/edit-stadium.png");
        editStadiumButton.setIcon(editStadiumIcon);
        editStadiumButton.setIconTextGap(10);
        //Delete Team Button
        deleteStadiumButton=new JButton("Delete Stadium");
        deleteStadiumButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        deleteStadiumButton.setFocusable(false);
        ImageIcon removeStadiumIcon =new ImageIcon("src/Assets/delete-stadium.png");
        deleteStadiumButton.setIcon(removeStadiumIcon);
        deleteStadiumButton.setIconTextGap(10);
        deleteStadiumButton.addActionListener(this);
        addStadiumPanel.add(addStadiumButton);
        editStadiumPanel.add(editStadiumButton);
        deleteStadiumPanel.add(deleteStadiumButton);
        this.add(addStadiumPanel);
        this.add(editStadiumPanel);
        this.add(deleteStadiumPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addStadiumButton) {

            cardLayout.show(main, "AddStadium");
        }

            if (e.getSource() == editStadiumButton) { if (stadium!=null) {
                cardLayout.show(main, "EditStadium");
            } else{
                JOptionPane.showConfirmDialog(this,"Please add Add Stadium first","Invalid Field",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
            } if (e.getSource() == deleteStadiumButton) {
            if (stadium!=null) {
                cardLayout.show(main, "DeleteStadium");
            }
            else{
                JOptionPane.showConfirmDialog(this,"Please add Add Stadium first","Invalid Field",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
            }
        }

    }


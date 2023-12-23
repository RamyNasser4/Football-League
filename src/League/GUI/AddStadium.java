package League.GUI;

import League.League;
import League.Stadium.Stadium;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStadium extends JPanel implements ActionListener{
    JButton addStadium;
    JTextField StadiumNameField;
    JTextField StadiumLocationField;
    JTextField StadiumCapacityField;
    League league;
    MainPanel main;
    CardLayout cardLayout;
    public AddStadium(League league, MainPanel main, CardLayout cardLayout){
        this.league = league;
        this.main = main;
        this.cardLayout = cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel(new GridLayout(1, 1));
        JPanel contentPanel=new JPanel(new GridLayout(5, 1,0,30));
        JLabel titleLabel = new JLabel("Add Stadium");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        this.add(contentPanel);
        JPanel StadiumNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel StadiumNameLabel = new JLabel("Stadium Name : ");
        StadiumNameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        StadiumNameLabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,20));
        StadiumNamePanel.add(StadiumNameLabel);
        StadiumNameField = new JTextField("");
        StadiumNameField.setPreferredSize(new Dimension(300,40));
        StadiumNamePanel.add(StadiumNameField);
        contentPanel.add(StadiumNamePanel);
        JPanel StadiumLocationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel StadiumLocationlabel = new JLabel("Stadium Location : ");
        StadiumLocationlabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        StadiumLocationlabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,10));
        StadiumLocationPanel.add(StadiumLocationlabel);
        StadiumLocationField = new JTextField("");
        StadiumLocationField.setPreferredSize(new Dimension(300,40));
        StadiumLocationPanel.add(StadiumLocationField);
        contentPanel.add(StadiumLocationPanel);
        JPanel StadiumCapacityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel StadiumCapacitylabel = new JLabel("Stadium Capacity : ");
        StadiumCapacitylabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        StadiumCapacitylabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,26));
        StadiumCapacityPanel.add(StadiumCapacitylabel);
        StadiumCapacityField = new JTextField("");
        StadiumCapacityField.setPreferredSize(new Dimension(300,40));
        StadiumCapacityPanel.add(StadiumCapacityField);
        contentPanel.add(StadiumCapacityPanel);
        JPanel addStadiumPanel = new JPanel();
        addStadium = new JButton("Add Stadium");
        addStadium.setSize(new Dimension(100,30));
        addStadium.setFont(new Font("Comic Sans",Font.BOLD,20));
        addStadium.setHorizontalAlignment(SwingConstants.CENTER);
        addStadium.setFocusable(false);
        addStadium.addActionListener(this);
        addStadiumPanel.add(addStadium);
        contentPanel.add(addStadiumPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addStadium){
            String StadiumName = StadiumNameField.getText();
            String StadiumLocation = StadiumLocationField.getText();
            int Capacity;
            try {
                Capacity = Integer.parseInt(StadiumCapacityField.getText());
            }catch (Exception exp){

                Capacity = 0;
            }
            if (Validation(StadiumName,StadiumLocation,Capacity)){
                Stadium newStadium = new Stadium(StadiumName,StadiumLocation,Capacity);
                league.AddStadium(newStadium);
                StadiumNameField.setText("");
                StadiumLocationField.setText("");
                StadiumCapacityField.setText("");
                JOptionPane.showConfirmDialog(this, "The stadium added successfully", "Success", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                cardLayout.show(main,"Stadiums");
                main.add(new AddStadium(league,main,cardLayout),"AddStadium");
                main.add(new EditStadium(league,main,cardLayout),"EditStadium");
                main.add(new DeleteStadium(league,main,cardLayout),"DeleteStadium");


            }else {
                if(Capacity==0){
                    JOptionPane.showConfirmDialog(this, "invalid capacity ", "Invalid Field", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                }
                if (!league.searchStadiumBool(StadiumName)) {
                    JOptionPane.showConfirmDialog(this, "This stadium already exist ", "Invalid Field", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

                } if (StadiumName.equalsIgnoreCase("") || StadiumLocation.equalsIgnoreCase("") || Capacity== 0) {

                    JOptionPane.showConfirmDialog(this, "Invalid Fields", "Invalid Field", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    public boolean Validation(String StadiumName,String StadiumLocation,int Capacity){
        if (StadiumName.equalsIgnoreCase("") || StadiumLocation.equalsIgnoreCase("") || Capacity== 0) {
            return false;
        }
        if (!league.searchStadiumBool(StadiumName)) {
            return false;
        }
        return true;
    }
}

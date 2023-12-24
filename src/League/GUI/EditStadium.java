package League.GUI;

import League.League;
import League.Match.Match;
import League.Stadium.Stadium;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditStadium extends JPanel implements ActionListener {
    JComboBox chooseStadium;
    JButton editStadium;
    JTextField StadiumNameField;
    JTextField StadiumLocationField;
    JTextField StadiumCapacityField;
    League league;
    MainPanel main;
    CardLayout cardLayout;
    public EditStadium(League league, MainPanel main, CardLayout cardLayout){
        this.league = league;
        this.main = main;
        this.cardLayout = cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel(new GridLayout(1, 1));
        JPanel contentPanel=new JPanel(new GridLayout(6, 1,0,30));
        JLabel titleLabel = new JLabel("Edit Stadium");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        this.add(contentPanel);
        JPanel chooseStadiumPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentPanel.add(chooseStadiumPanel);
        String [] StadiumNames=new String[league.stadiums.size()];
        for(int i=0;i<league.stadiums.size();i++){
            StadiumNames[i]=league.stadiums.get(i).getStadiumName();
        }


        chooseStadium = new JComboBox(new DefaultComboBoxModel<>(StadiumNames));

        chooseStadium.addActionListener(this);
        chooseStadium.setEditable(false);
        chooseStadiumPanel.add(chooseStadium);

        JPanel StadiumNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel StadiumNameLabel = new JLabel("Stadium Name : ");
        StadiumNameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        StadiumNameLabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,20));
        StadiumNamePanel.add(StadiumNameLabel);
        StadiumNameField = new JTextField("");
        StadiumNameField.setPreferredSize(new Dimension(300,40));
        StadiumNamePanel.add(StadiumNameField);
        contentPanel.add(StadiumNamePanel);
        //coach name
        JPanel StadiumLocationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel StadiumLocationLabel = new JLabel("Stadium Location : ");
        StadiumLocationLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        StadiumLocationLabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,10));
        StadiumLocationPanel.add(StadiumLocationLabel);
        StadiumLocationField = new JTextField("");
        StadiumLocationField.setPreferredSize(new Dimension(300,40));
        StadiumLocationPanel.add(StadiumLocationField);
        contentPanel.add(StadiumLocationPanel);
        JPanel StadiumCapacityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel StadiumCapacityLabel = new JLabel("Capacity : ");
        StadiumCapacityLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        StadiumCapacityLabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,26));
        StadiumCapacityPanel.add(StadiumCapacityLabel);
        StadiumCapacityField = new JTextField("");
        StadiumCapacityField.setPreferredSize(new Dimension(300,40));
        StadiumCapacityPanel.add(StadiumCapacityField);
        contentPanel.add(StadiumCapacityPanel);
        JPanel editStadiumPanel = new JPanel();
        editStadium = new JButton("Edit Stadium");
        editStadium.setSize(new Dimension(100,30));
        editStadium.setFont(new Font("Comic Sans",Font.BOLD,20));
        editStadium.setHorizontalAlignment(SwingConstants.CENTER);
        editStadium.setFocusable(false);
        editStadium.addActionListener(this);
        editStadiumPanel.add(editStadium);
        try {
            String StadiumName = (String) chooseStadium.getSelectedItem();
            Stadium searched = league.searchStadium(StadiumName);
            StadiumNameField.setText(searched.getStadiumName());
            StadiumLocationField.setText(searched.getStadiumLocation());
            StadiumCapacityField.setText(String.valueOf(searched.getStadiumCapacity()));
        }catch (Exception exp){

        }
        contentPanel.add(editStadiumPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseStadium){
            String StadiumName = (String) chooseStadium.getSelectedItem();
            Stadium searched = league.searchStadium(StadiumName);
            StadiumNameField.setText(searched.getStadiumName());
            StadiumLocationField.setText(searched.getStadiumLocation());
            StadiumCapacityField.setText(String.valueOf(searched.getStadiumCapacity()));
        } else if (e.getSource() == editStadium) {
            String StadiumName = StadiumNameField.getText();
            String StadiumLocation = StadiumLocationField.getText();
            int capacity;
            try {
                capacity = Integer.parseInt(StadiumCapacityField.getText());
            }catch (Exception exp){
                //JOptionPane.showConfirmDialog(this,"Invalid Coach Age","Invalid Field",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                capacity = 0;
            }

                if (Validation(StadiumName,StadiumLocation,capacity)){
                    String currentTeamName = (String) chooseStadium.getSelectedItem();
                    Stadium searched = league.searchStadium(currentTeamName);
                    searched.setStadiumName(StadiumName);
                    searched.setStadiumLocation(StadiumLocation);
                    searched.setStadiumCapacity(capacity);
                    main.add(new AddStadium(league,main,cardLayout),"AddStadium");
                    main.add(new DeleteStadium(league,main,cardLayout),"DeleteStadium");
                    main.add(new EditStadium(league,main,cardLayout),"EditStadium");
                    main.add(new AddMatch(league,main,cardLayout),"AddMatch");
                    main.add(new EditMatch(league,main,cardLayout),"EditMatch");
                    main.add(new DeleteMatch(league,main,cardLayout),"DeleteMatch");

                    cardLayout.show(main,"Stadiums");
                    }


                }else {
                    JOptionPane.showConfirmDialog(this,"Invalid Fields","Invalid Field",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                }

        }

    public boolean Validation(String TeamName,String CoachName,int CoachAge){
        if (TeamName.equalsIgnoreCase("")|| CoachName.equalsIgnoreCase("") || CoachAge== 0){
            return false;
            }

        return true;
    }
}

package League.GUI;

import League.League;
import League.Stadium.Stadium;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditStadium extends JPanel implements ActionListener {
    JComboBox chooseStaduim;
    JButton editStaduim;
    JTextField StaduimNameField;
    JTextField StaduimLocationField;
    JTextField StaduimCapcityField;
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
        JLabel titleLabel = new JLabel("Edit Staduim");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        this.add(contentPanel);
        JPanel chooseStaduimPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentPanel.add(chooseStaduimPanel);
        String [] StaduimNames=new String[league.stadiums.size()];
        for(int i=0;i<league.stadiums.size();i++){
            StaduimNames[i]=league.stadiums.get(i).getStadiumName();
        }


        chooseStaduim = new JComboBox(new DefaultComboBoxModel<>(StaduimNames));

        chooseStaduim.addActionListener(this);
        chooseStaduim.setEditable(false);
        chooseStaduimPanel.add(chooseStaduim);

        JPanel StaduimNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel StaduimNameLabel = new JLabel("Stadium Name : ");
        StaduimNameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        StaduimNameLabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,20));
        StaduimNamePanel.add(StaduimNameLabel);
        StaduimNameField = new JTextField("");
        StaduimNameField.setPreferredSize(new Dimension(300,40));
        StaduimNamePanel.add(StaduimNameField);
        contentPanel.add(StaduimNamePanel);
        //coach name
        JPanel StaduimLocationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel StaduimLocationLabel = new JLabel("Staduim Location : ");
        StaduimLocationLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        StaduimLocationLabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,10));
        StaduimLocationPanel.add(StaduimLocationLabel);
        StaduimLocationField = new JTextField("");
        StaduimLocationField.setPreferredSize(new Dimension(300,40));
        StaduimLocationPanel.add(StaduimLocationField);
        contentPanel.add(StaduimLocationPanel);
        JPanel StaduimCapcityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel StaduimCapcityLabel = new JLabel("Capcity : ");
        StaduimCapcityLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        StaduimCapcityLabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,26));
        StaduimCapcityPanel.add(StaduimCapcityLabel);
        StaduimCapcityField = new JTextField("");
        StaduimCapcityField.setPreferredSize(new Dimension(300,40));
        StaduimCapcityPanel.add(StaduimCapcityField);
        contentPanel.add(StaduimCapcityPanel);
        JPanel editStaduimPanel = new JPanel();
            editStaduim = new JButton("Edit Staduim");
        editStaduim.setSize(new Dimension(100,30));
        editStaduim.setFont(new Font("Comic Sans",Font.BOLD,20));
        editStaduim.setHorizontalAlignment(SwingConstants.CENTER);
        editStaduim.setFocusable(false);
        editStaduim.addActionListener(this);
        editStaduimPanel.add(editStaduim);
        try {
            String StadiumName = (String) chooseStaduim.getSelectedItem();
            Stadium searched = league.searchStadium(StadiumName);
            StaduimNameField.setText(searched.getStadiumName());
            StaduimLocationField.setText(searched.getStadiumLocation());
            StaduimCapcityField.setText(String.valueOf(searched.getStadiumCapacity()));
        }catch (Exception exp){

        }
        contentPanel.add(editStaduimPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseStaduim){
            String StadiumName = (String) chooseStaduim.getSelectedItem();
            Stadium searched = league.searchStadium(StadiumName);
            StaduimNameField.setText(searched.getStadiumName());
            StaduimLocationField.setText(searched.getStadiumLocation());
            StaduimCapcityField.setText(String.valueOf(searched.getStadiumCapacity()));
        } else if (e.getSource() == editStaduim) {
            String StadiumName = StaduimNameField.getText();
            String StadiumLocation = StaduimLocationField.getText();
            int capacity;
            try {
                capacity = Integer.parseInt(StaduimCapcityField.getText());
            }catch (Exception exp){
                //JOptionPane.showConfirmDialog(this,"Invalid Coach Age","Invalid Field",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
                capacity = 0;
            }

                if (Validation(StadiumName,StadiumLocation,capacity)){
                    String currentTeamName = (String) chooseStaduim.getSelectedItem();
                    Stadium searched = league.searchStadium(currentTeamName);
                    searched.setStadiumName(StadiumName);
                    searched.setStadiumLocation(StadiumLocation);
                    searched.setStadiumCapacity(capacity);

                    main.add(new AddStadium(league,main,cardLayout),"AddStadium");
                    main.add(new DeleteStadium(league,main,cardLayout),"DeleteStadium");
                    main.add(new EditStadium(league,main,cardLayout),"EditStadium");

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

package League.GUI;

import League.League;
import League.Person.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static League.League.searchByNameAndTeam;

public class EditPlayer extends JPanel {
    JComboBox teamsComboBox;
    public EditPlayer(League league){
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(2, 1));
        JPanel titlepanel = new JPanel(new GridLayout(5, 1,0,30));
        JPanel contentPanel=new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
        JLabel titleLabel = new JLabel("Edit Player");
        JLabel title2Label = new JLabel("Search by Team and Name");
        title2Label.setFont(new Font("Comic Sans",Font.BOLD,15));
        title2Label.setVerticalAlignment(JLabel.TOP);
        title2Label.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlepanel.add(titleLabel);
        titlepanel.add(title2Label);
        this.add(titlepanel);
        this.add(contentPanel);

        JPanel namepanel = new JPanel(new GridLayout(1, 1));
        JLabel nameLabel = new JLabel("Enter Name");
        namepanel.add(nameLabel);
        nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        JTextField nameFeild = new JTextField("");
        namepanel.add(nameFeild);
        titlepanel.add(namepanel);

        contentPanel.add(panel2);
        JPanel teampanel = new JPanel(new GridLayout(1, 1));
        JLabel teamLabel = new JLabel("Team");
        teamLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        teampanel.add(teamLabel);
        JTextField teamFeild = new JTextField("");
        teampanel.add(teamFeild);
        titlepanel.add(teampanel);


        JButton searchButton=new JButton("Search");
        searchButton.setFocusable(false);
        searchButton.setFont(new Font("Comic Sans",Font.BOLD,20));
        panel2.add(searchButton);
        searchButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {

                try {
                    String name = nameFeild.getText();
                    String team = teamFeild.getText();

                    if (!Validation(name,team)) {
                        JOptionPane.showMessageDialog(null, "Enter valid name and team");
                    } else {
                        //until League obj is added
                        //League.SearchByNameAndTeam(name, team);
                        System.out.println(league.SearchByNameAndTeam(name,team));
                        Player p = league.SearchByNameAndTeam(name,team).getFirst();
                        JLabel select = new JLabel("Select Values to edit");
                        JButton searchValue = new JButton(p.Name + " " + p.Age + " " + p.Salary);
                        panel2.add(searchValue);
                        panel2.add(select);
                        searchValue.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                if (true) {
                                    JPanel namepanel = new JPanel(new GridLayout(1, 1));
                                    JLabel nameLabel = new JLabel("Name");
                                    namepanel.add(nameLabel);
                                    nameLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
                                    JTextField nameFeild = new JTextField(p.GetPlayerName());
                                    namepanel.add(nameFeild);
                                    titlepanel.add(namepanel);


                                    JPanel agepanel = new JPanel(new GridLayout(1, 1));
                                    JLabel ageLabel = new JLabel("Age");
                                    ageLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
                                    agepanel.add(ageLabel);
                                    JTextField ageFeild = new JTextField("");
                                    agepanel.add(ageFeild);
                                    titlepanel.add(agepanel);

                                    JPanel salarypanel = new JPanel(new GridLayout(1, 1));
                                    JLabel salaryLabel = new JLabel("Salary");
                                    salaryLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
                                    salarypanel.add(salaryLabel);
                                    JTextField salaryFeild = new JTextField(p.getPersonSalary());
                                    salarypanel.add(salaryFeild);
                                    titlepanel.add(salarypanel);

                                    JPanel rankpanel = new JPanel(new GridLayout(1, 1));
                                    JLabel rankLabel = new JLabel("Rank");
                                    rankLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
                                    rankpanel.add(rankLabel);
                                    JTextField rankFeild = new JTextField(p.GetPlayerRank());
                                    rankpanel.add(rankFeild);
                                    panel2.add(rankpanel);


                                    JPanel positionspanel = new JPanel(new GridLayout(1, 1));
                                    JLabel positionsLabel = new JLabel("Position");
                                    positionsLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
                                    positionspanel.add(positionsLabel);
                                    String positions[] = {"GoalKeeper", "Defender", "Midfielder", "Forward"};
                                    JComboBox positionsComboBox = new JComboBox(positions);
                                    positionspanel.add(positionsComboBox);
                                    panel2.add(positionspanel);

                                    JButton saveButton = new JButton("Save");
                                    saveButton.setFocusable(false);
                                    saveButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
                                    saveButton.addActionListener(new ActionListener() {

                                        @Override
                                        public void actionPerformed(ActionEvent arg0) {
                                            if(!p.getPersonName().equals(nameFeild.getText())){
                                                p.setPersonName(nameFeild.getText());
                                            }
                                            /**
                                             *
                                             * @throws NumberFormatException if user enters non integers
                                             */
                                            try{

                                                if(p.GetPlayerAge()!=Integer.parseInt(ageFeild.getText())){
                                                    p.setPersonAge(Integer.parseInt(ageFeild.getText()));
                                                }
                                                if(p.GetPlayerRank()!=Integer.parseInt(rankFeild.getText())){
                                                    p.SetPlayerRank(Integer.parseInt(rankFeild.getText()));
                                                }
                                                if(p.getPersonSalary()!=Integer.parseInt(salaryFeild.getText()))
                                                {
                                                    p.setPersonSalary(Integer.parseInt(salaryFeild.getText()));
                                                }
                                            }
                                            /**
                                             *
                                             * @throws NumberFormatException if user enters non integers
                                             */
                                            catch(NumberFormatException e){
                                                JOptionPane.showMessageDialog(null, "Enter valid number in salary,age and rank");
                                            }

                                            if(!p.GetPlayerTeam().equals(teamsComboBox.getSelectedItem())){
                                                p.SetPlayerTeam((String) teamsComboBox.getSelectedItem());
                                            }


                                        }
                                    });
                                }
                            }

                        });
                    }
                }
                /**
                 *
                 * @throws NullPointerException if given player doesn't exist
                 */
                catch(NullPointerException exp){
                    JOptionPane.showMessageDialog(null, "Player not found");
                }
            }


        });
    }
    public boolean Validation(String name,String Age,String Salary,String rank,String position){
        if (name.isEmpty()||Age.isEmpty()||Salary.isEmpty()||rank.isEmpty()||position.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return false;
        }
        else{
            return true;
        }
    }

    public boolean Validation(String name,String team ){
        if(name.isEmpty()||team.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}

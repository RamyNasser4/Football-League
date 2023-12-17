package League.GUI;
import League.Person.Player.Player;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static League.League.searchByNameAndTeam;
import static League.League.teamnames;

/**
 * This class represents the graphical user interface for managing players in a sports league.
 */
public class PlayerGui extends JPanel implements ActionListener {
    /**
     * Displays the home screen for managing players.
     */
public void PlayerHomeScreen(){
         this.setSize(new Dimension(980, 720));
         this.setLayout(new GridLayout(3, 1));
         JPanel panel1 = new JPanel(new GridLayout(1, 1));
         JPanel panel2 = new JPanel(new GridLayout(1, 1));
         JPanel panel3 = new JPanel(new GridLayout(1, 1));
         ImageIcon addPlayerIcon =new ImageIcon("src/Assets/add-player.png");
         this.setVisible(true);
         //Add Player button
         JButton panel1Button=new JButton("Add Player");
         panel1Button.setFocusable(false);
         panel1Button.setIcon(addPlayerIcon);
         panel1Button.setFont(new Font("Comic Sans",Font.BOLD,20));

         //Edit Player Button
         JButton panel2Button=new JButton("Edit Player");
         panel2Button.setFont(new Font("Comic Sans",Font.BOLD,20));
         panel2Button.setFocusable(false);
         ImageIcon editPlayerIcon =new ImageIcon("src/Assets/edit-player.png");
         panel2Button.setIcon(editPlayerIcon);
         //Delete Player Button
         JButton panel3Button=new JButton("Delete Player");
         panel3Button.setFont(new Font("Comic Sans",Font.BOLD,20));
         panel3Button.setFocusable(false);
         ImageIcon removePlayerIcon =new ImageIcon("src/Assets/remove-player.png");
         panel3Button.setIcon(removePlayerIcon);
         panel1Button.addActionListener(new ActionListener(){

             @Override
             public void actionPerformed(ActionEvent arg0) {
                 removeAll();  // Remove existing panels
                 AddPlayerGui();
                 revalidate(); // Ensure the layout is updated
                 repaint();    // Repaint the components


             }



         });

         panel2Button.addActionListener(new ActionListener(){

             @Override
             public void actionPerformed(ActionEvent arg0) {
                 removeAll();
                 EditPlayerGui();
                 revalidate();
                 repaint();

             }

         });

         panel3Button.addActionListener(new ActionListener(){

             @Override
             public void actionPerformed(ActionEvent arg0) {
                 removeAll();
                 DeletePlayerGui();
                 revalidate();
                 repaint();

             }

         });
         panel1Button.setBounds(300, 0, 980, 240);

         panel1.add(panel1Button);
         panel2.add(panel2Button);
         panel3.add(panel3Button);

         this.add(panel1);
         this.add(panel2);
         this.add(panel3);


     }
    /**
     * Validates player information entered during addition or editing.
     *
     * @param name     The player's name.
     * @param Age      The player's age.
     * @param Salary   The player's salary.
     * @param rank     The player's rank.
     * @param position The player's position.
     * @return True if the information is valid, otherwise false.
     */
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
    /**
     * Adds fields form for adding a new player.
     */
 public void AddPlayerFields(){
     this.setSize(new Dimension(980, 720));
     this.setLayout(new GridLayout(2, 1));
     JPanel titlepanel = new JPanel(new GridLayout(5, 1,0,30));
     JPanel contentPanel=new JPanel(new GridLayout(1, 1));
     JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
     JLabel titleLabel = new JLabel("Add Player");
     titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
     titleLabel.setVerticalAlignment(JLabel.TOP);
     titleLabel.setHorizontalAlignment(JLabel.CENTER);
     titlepanel.add(titleLabel);
     this.add(titlepanel);
     this.add(contentPanel);
     contentPanel.add(panel2);
     JPanel namepanel = new JPanel(new GridLayout(1, 1));
     JLabel nameLabel = new JLabel("Name");
     namepanel.add(nameLabel);
     nameLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
     JTextField nameFeild = new JTextField("");
     namepanel.add(nameFeild);
     titlepanel.add(namepanel);


     JPanel agepanel = new JPanel(new GridLayout(1, 1));
     JLabel ageLabel = new JLabel("Age");
     ageLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
     agepanel.add(ageLabel);
     JTextField ageFeild = new JTextField("");
     agepanel.add(ageFeild);
     titlepanel.add(agepanel);

     JPanel salarypanel = new JPanel(new GridLayout(1, 1));
     JLabel salaryLabel = new JLabel("Salary");
     salaryLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
     salarypanel.add(salaryLabel);
     JTextField salaryFeild = new JTextField("");
     salarypanel.add(salaryFeild);
     titlepanel.add(salarypanel);

     JPanel rankpanel = new JPanel(new GridLayout(1, 1));
     JLabel rankLabel = new JLabel("Rank");
     rankLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
     rankpanel.add(rankLabel);
     JTextField rankFeild = new JTextField("");
     rankpanel.add(rankFeild);
     panel2.add(rankpanel);


     JPanel positionspanel = new JPanel(new GridLayout(1, 1));
     JLabel positionsLabel = new JLabel("Position");
     positionsLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
     positionspanel.add(positionsLabel);
     String positions[]={"GoalKeeper","Defender","Midfielder","Forward"};
     JComboBox positionsComboBox =new JComboBox(positions);
     positionspanel.add(positionsComboBox);
     panel2.add(positionspanel);

     JButton saveButton=new JButton("Save");
     saveButton.setFocusable(false);
     saveButton.setFont(new Font("Comic Sans",Font.BOLD,20));

     panel2.add(saveButton);
     teamsComboBox=new JComboBox ((ComboBoxModel) teamnames);

     JPanel comboboxpanel = new JPanel(new GridLayout(1, 1));
     JLabel comboBoxLabel = new JLabel("Team");
     comboBoxLabel.setFont(new Font("Comic Sans",Font.BOLD,20));

     comboboxpanel.add(comboBoxLabel);
     comboboxpanel.add(teamsComboBox);
     this.setVisible(true);
     titlepanel.add(comboboxpanel);
     saveButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
             String name = nameFeild.getText();
             String Age = ageFeild.getText();
             String Salary = salaryFeild.getText();
             String rank =rankFeild.getText();
             String position = (String) positionsComboBox.getItemAt(positionsComboBox.getSelectedIndex());
             String team="Null";
             try{

                 team = (String) teamsComboBox.getItemAt(teamsComboBox.getSelectedIndex());


             }
             /**
              *
              * @throws NullPointerException  if no team exists
              */
             catch(NullPointerException ignorable){
                 JOptionPane.showMessageDialog(null, "Add team first");
             }
             // validation
             if (!Validation(name,Age,Salary,rank,position)) {
                 JOptionPane.showMessageDialog(null, "Please fill all fields");

             }

             else {
                 try{
                     Integer.parseInt(Age);
                     Integer.parseInt(Salary);
                     Integer.parseInt(rank);
                     Player p=new Player(name,Integer.parseInt(Age),Integer.parseInt(Salary),team);
                 }
                 /**
                  *
                  * @throws NumberFormatException if user enters non integers
                  */
                 catch(NumberFormatException e) {
                     JOptionPane.showMessageDialog(null, "Enter a valid number in salary,age and rank");
                 }

             }
          }
     });

 }


    JComboBox teamsComboBox;
    public  PlayerGui() {
        PlayerHomeScreen();


    }
    /**
     * Displays the GUI for adding a new player.
     */
public void AddPlayerGui(){
        int TeamlistSize = 0;
    try

      {

          TeamlistSize= teamnames.size();
          AddPlayerFields();

       }
    /**
     *
     * @throws NullPointerException if no team exist
     */
     catch(NullPointerException ignored)
       {
     JOptionPane.showMessageDialog(null,"Add Team First then you can add Player");
     String arr[]={"null"};
     teamsComboBox=new JComboBox (arr);
           TeamlistSize=0;
   }
    if(TeamlistSize!=0)
    {
        AddPlayerFields();
        }
     else
      //do nothing until validation
       {


       }



}
    /**
     * Displays the GUI for editing a player.
 */
public void EditPlayerGui(){
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
                String team = nameFeild.getText();

                if (!Validation(name,team)) {
                    JOptionPane.showMessageDialog(null, "Enter valid name and team");
                } else {
                    //until League obj is added
                    //League.SearchByNameAndTeam(name, team);

                    Player p = new Player(searchByNameAndTeam.getFirst());
                    JLabel select = new JLabel("Select Values to edit");
                    JButton searchValue = new JButton(p.Name + " " + p.Age + " " + p.Salary);
                    panel2.add(searchValue);
                    panel2.add(select);
                    searchValue.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            if (!searchByNameAndTeam.isEmpty()) {
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
    /**
     * Displays the GUI for deleting a player.
     */
private void DeletePlayerGui(){
    this.setSize(new Dimension(980, 720));
    this.setLayout(new GridLayout(2, 1));
    JPanel titlepanel = new JPanel(new GridLayout(5, 1,0,30));
    JPanel contentPanel=new JPanel(new GridLayout(1, 1));
    JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
    JLabel titleLabel = new JLabel("Delete Player");
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
            String name=nameFeild.getText();
            String team =nameFeild.getText();
            boolean found=false;
            try {
                for (String s : teamnames) {
                    if (s.equals(team)) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    JOptionPane.showMessageDialog(null, "Team not found");
                }
            }
            /**
             *
             * @throws NullPointerException if no team exists
             */
            catch(NullPointerException exp){
                JOptionPane.showMessageDialog(null,"No teams Exist");
            }
            if(name.isEmpty()||team.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter valid name and team");
            }
            else{
                //Until League obj is added
                //League.SearchByNameAndTeam(name,team);
               try{ Player p=new Player(searchByNameAndTeam.getFirst());

                JLabel select =new JLabel("Select Player to delete");
                JButton serachValue = new JButton(p.Name +" "+p.Age+" "+p.Salary);
                panel2.add(serachValue);
                panel2.add(select);
                serachValue.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent arg0) {
                   searchByNameAndTeam.remove(0);
               }
                });}
               /**
                *
                * @throws NullPointerException if no player exists
                */
               catch(NullPointerException exp){
                   JOptionPane.showMessageDialog(null,"No results Found");
               }


            }
        }

    });
Player.totalPlayers--;
    }

    @Override
   public void actionPerformed(ActionEvent e) {

   }

}


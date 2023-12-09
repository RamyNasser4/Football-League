package League.GUI;
import League.*;
import League.Person.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PlayerGui extends JPanel implements ActionListener {

    JPanel panel1 = new JPanel(new GridLayout(1, 1));
    JPanel panel2 = new JPanel(new GridLayout(1, 1));
    JPanel panel3 = new JPanel(new GridLayout(1, 1));
    ImageIcon addPlayerIcon =new ImageIcon("src/Assets/add-player.png");
        //this.setVisible(true);
    public  PlayerGui() {

        AddPlayerGui();
     /* this.setSize(new Dimension(980, 720));
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

                 AddPlayerGui();


            }



        });

        panel2Button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                panel1.removeAll();
                panel2.removeAll();
                panel3.removeAll();
                EditPlayerGui();
            }

        });

        panel3Button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {

                DeletePlayerGui();
            }

        });
        panel1Button.setBounds(300, 0, 980, 240);

        panel1.add(panel1Button);
        panel2.add(panel2Button);
        panel3.add(panel3Button);
        this.validate();
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
*/

    }
public void AddPlayerGui(){

    this.setSize(new Dimension(980, 720));
    this.setLayout(new GridLayout(2, 1));
    JPanel titlepanel = new JPanel(new GridLayout(5, 1,0,30));
    JPanel contentPanel=new JPanel(new GridLayout(1, 1));
    JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
    JLabel titleLabel = new JLabel("Add Player");
    titleLabel.setFont(new Font("Comic Sans",Font.BOLD,40));
    titleLabel.setVerticalAlignment(JLabel.TOP);
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    titlepanel.add(titleLabel);
    this.add(titlepanel);
    this.add(contentPanel);


    contentPanel.add(panel2);
    JComboBox teamsComboBox=new JComboBox();

        int s = 0;
  //  try

    //  {

        // s = League.teamnames.size();
    JPanel comboboxpanel = new JPanel(new GridLayout(1, 1));
    JLabel comboBoxLabel = new JLabel("Team");
    comboBoxLabel.setFont(new Font("Comic Sans",Font.BOLD,20));

         // teamsComboBox.addItem(League.teamnames);
           teamsComboBox.addItem(1);
          comboboxpanel.add(comboBoxLabel);
            comboboxpanel.add(teamsComboBox);
            this.setVisible(true);
            titlepanel.add(comboboxpanel);

       //}
    /* catch(NullPointerException ignored)
       {
     JOptionPane.showMessageDialog(null,"Add Team First then you can add Player");
       teamsComboBox.addItem("null");
     titlepanel.setVisible(false);
   }*/
   // if(s==0)
   // {
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

   /* JPanel scorepanel = new JPanel(new GridLayout(1, 1));
    JLabel scoreLabel = new JLabel("Score");
    scoreLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
    scorepanel.add(scoreLabel);
    JTextField scoreFeild = new JTextField("");
    scorepanel.add(scoreFeild);
    panel2.add(scorepanel);*/

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
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = nameFeild.getText();
                String Age = ageFeild.getText();
                String Salary = salaryFeild.getText();
                String rank =rankFeild.getText();
                String position = (String) positionsComboBox.getItemAt(positionsComboBox.getSelectedIndex());
                /*try{
                    String team = (String) teamsComboBox.getItemAt(teamsComboBox.getSelectedIndex());
                }
                catch(NullPointerException ignorable){

                }*/
            // validation
                if (name.equals("")||Age.equals("")||Salary.equals("")||rank.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields");
                }

                else {

                   //  Player p=new Player(name,Age,Salary,team);
                }
            }
 });

       // }
    // else

      // {


      //  }



}
private void EditPlayerGui(){

}
private void DeletePlayerGui(){
Player.totalPlayers--;
    }

    @Override
   public void actionPerformed(ActionEvent e) {

   }


}


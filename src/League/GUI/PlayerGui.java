package League.GUI;
import League.*;
import League.Person.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerGui extends JPanel implements ActionListener {

    public  PlayerGui() {
        AddPlayerGui();

       /* this.setPreferredSize(new Dimension(980, 720));
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

        panel1Button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                panel1.setVisible(false);
                panel2.setVisible(false);
                panel3.setVisible(false);
                 AddPlayerGui();

            }



        });
        //Edit Player Button

        JButton panel2Button=new JButton("Edit Player");
        panel2Button.setFont(new Font("Comic Sans",Font.BOLD,20));
        panel2Button.setFocusable(false);
        ImageIcon editPlayerIcon =new ImageIcon("src/Assets/edit-player.png");
        panel2Button.setIcon(editPlayerIcon);
        panel2Button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                panel1.setVisible(false);
                panel2.setVisible(false);
                panel3.setVisible(false);
                EditPlayerGui();
            }

        });
        //Delete Player Button
        JButton panel3Button=new JButton("Delete Player");
        panel3Button.setFont(new Font("Comic Sans",Font.BOLD,20));
        panel3Button.setFocusable(false);
        ImageIcon removePlayerIcon =new ImageIcon("src/Assets/remove-player.png");
        panel3Button.setIcon(removePlayerIcon);
        panel3Button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                panel1.setVisible(false);
                panel2.setVisible(false);
                panel3.setVisible(false);
                DeletePlayerGui();
            }

        });
        panel1Button.setBounds(300, 0, 980, 240);

        panel1.add(panel1Button);
        panel2.add(panel2Button);
        panel3.add(panel3Button);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
*/

    }
public void AddPlayerGui(){

    this.setPreferredSize(new Dimension(980, 720));
    this.setLayout(new GridLayout(2, 1));
    JPanel titlepanel = new JPanel(new GridLayout(5, 1,0,30));
    JPanel contentPanel=new JPanel(new GridLayout(1, 1));
    JPanel panel2 = new JPanel(new GridLayout(4, 1,0,50));
    JLabel titleLabel = new JLabel("Add Player");
    titleLabel.setFont(new Font("Comic Sans",Font.BOLD,40));
    titleLabel.setVerticalAlignment(JLabel.TOP);
    titleLabel.setHorizontalAlignment(JLabel.CENTER);
    JLabel titleLabel1 = new JLabel("Add Player");
    titlepanel.add(titleLabel);
    this.add(titlepanel);
   this.add(contentPanel);


    contentPanel.add(panel2);


        JComboBox teamsComboBox;

        int s = 0;
    try

      {
         s = League.teamnames.size();
    JPanel comboboxpanel = new JPanel(new GridLayout(1, 1));
    JLabel comboBoxLabel = new JLabel("Team");
    comboBoxLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
            teamsComboBox = new JComboBox((ComboBoxModel) League.teamnames);
            comboboxpanel.add(comboBoxLabel);
            comboboxpanel.add(teamsComboBox);
            this.setVisible(true);
            titlepanel.add(comboboxpanel);

       }
     catch(NullPointerException ignored)
       {

   }
    if(s!=0)
    {
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

    JPanel scorepanel = new JPanel(new GridLayout(1, 1));
    JLabel scoreLabel = new JLabel("Score");
    scoreLabel.setFont(new Font("Comic Sans",Font.BOLD,20));
    scorepanel.add(scoreLabel);
    JTextField scoreFeild = new JTextField("");
    scorepanel.add(scoreFeild);
    panel2.add(scorepanel);

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
        }
     else

       {


        }


// validation
    //else
  //add arguments from text inputs
    //  Player p=new Player();


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


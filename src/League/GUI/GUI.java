package League.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import League.League;
 public class GUI extends JFrame implements ActionListener {
    JComboBox comboBox;
    JComboBox teamsComboBox;
    JButton comboBoxBtn;
    JLabel checkBoxLabel,titleLabel,nameLabel,scoreLabel,rankLabel,teamLabel,ageLabel,salaryLabel,numberLabel;
    JTextField scoreField,rankField,teamField,nameField,ageField,salaryField,numberField;
   // String comboBoxChoice="GoalKeeper";

public GUI() {

    this.setSize(1400, 900);
    this.setResizable(false);
    this.setTitle("Football League");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(null);
    //place logo
    //  ImageIcon appicon= new ImageIcon("");
    // this.setIconImage(appicon.getImage());
    //Add Player

     int s=0;
     try{
         s=League.teams.size();
         teamsComboBox = new JComboBox(League.teams.toArray());
         teamsComboBox.setBounds(300, 350, 100, 20);
         this.setVisible(true);
         this.add(teamsComboBox);

     }
     catch(NullPointerException ignored){

    }
     if(s!=0) {
         String positions[] = {"GoalKeeper", "Defender", "Midfielder", "Forward"};
         checkBoxLabel = new JLabel("choose player position");
         checkBoxLabel.setBounds(820, 300, 200, 20);
         this.add(checkBoxLabel);
         comboBox = new JComboBox(positions);
         comboBox.setBounds(820, 350, 100, 20);
         this.setVisible(true);
         this.add(comboBox);
         titleLabel = new JLabel("Add Teams Player");
         titleLabel.setVisible(true);
         titleLabel.setBounds(600, 50, 200, 20);
         this.add(titleLabel);

         comboBoxBtn = new JButton("Next");
         comboBoxBtn.setFont(new Font("Arial", Font.BOLD, 30));
         comboBoxBtn.setBounds(600, 800, 250, 30);
         this.add(comboBoxBtn);
         comboBoxBtn.addActionListener(this);
         scoreField = new JTextField("Enter Player score here");
         rankField = new JTextField("Enter Player Rank here");
         //to be team drop down
         teamField = new JTextField("Enter Player Team here");
         nameField = new JTextField("Enter Player Name here");
         ageField = new JTextField("Enter Player Age here");
         salaryField = new JTextField("Enter Player salary here");
         numberField = new JTextField("Enter Player number here");
         this.add(teamField);
         this.add(nameField);
         this.add(rankField);
         this.add(scoreField);
         this.add(ageField);
         this.add(salaryField);
         this.add(numberField);
         // nameLabel =new JLabel("Player Name");
         // nameLabel.setBounds(200,100,200,20);
         //this.add(nameLabel);
         nameField.setBounds(300, 30, 200, 20);
         ageField.setBounds(300, 130, 200, 20);
         salaryField.setBounds(300, 230, 200, 20);
         numberField.setBounds(300, 330, 200, 20);
         teamField.setBounds(820, 30, 200, 20);
         rankField.setBounds(820, 130, 200, 20);
         scoreField.setBounds(820, 230, 200, 20);
     }
     else{
         this.setVisible(true);
         JPanel p1 = new JPanel();
         JLabel warning=new JLabel("Add team First");
         warning.setBounds(350, 130, 500, 50);
         warning.setFont((new Font("Arial", Font.BOLD, 70)));
         p1.add(warning);
         this.add(warning);
     }



   /*  checkBoxLabel=new JLabel("choose player position");
     checkBoxLabel.setBounds(820,530,200,20);
     this.add(checkBoxLabel);*/





}

//to be added in match

    @Override
    //to add fields of player subclasses
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()== comboBoxBtn){
     /*   comboBoxChoice= (String) comboBox.getItemAt(comboBox.getSelectedIndex());
        if(comboBoxChoice.equals("Forward")){
            JTextField tacklesField=new JTextField("Enter shots here");
        }
        else if(comboBoxChoice.equals("Defender")){
            JTextField savesField=new JTextField("Enter Saves here");
            JTextField tacklesField=new JTextField("Enter tackles here");
        }
        else if(comboBoxChoice.equals("Midfielder")){

        }
        else{
            JTextField savesField=new JTextField("Enter Saves here");
            JTextField cleanSheetField=new JTextField("Enter clean sheets here");
        }*/
    }
    }
}

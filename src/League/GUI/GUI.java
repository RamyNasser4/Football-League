package League.GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame implements ActionListener {
    JComboBox comboBox;
    JButton comboBoxBtn;
    JLabel checkBoxLabel;
            //,nameLabel,scoreLabel,rankLabel,teamLabel,ageLabel,salaryLabel,numberLabel;
    JTextField scoreField,rankField,teamField,nameField,ageField,salaryField,numberField;
    String comboBoxChoice="GoalKeeper";
public GUI(){

    this.setSize(1400,900);
    this.setResizable(false);
    this.setTitle("Football League");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setLocationRelativeTo(null);
this.setLayout(null);
    //place logo
    //  ImageIcon appicon= new ImageIcon("");
    // this.setIconImage(appicon.getImage());
    String positions[]={"GoalKeeper","Defender","Midfielder","Forward"};
     comboBox = new JComboBox(positions);
     comboBox.setBounds(820,350,100,20);
    this.setVisible(true);
     this.add(comboBox);
     checkBoxLabel=new JLabel("choose player position");
     checkBoxLabel.setBounds(820,330,200,20);
     this.add(checkBoxLabel);
     comboBoxBtn=new JButton("Next");
    comboBoxBtn.setFont(new Font("Arial",Font.BOLD,30));
    comboBoxBtn.setBounds(600,800,250,30);
    this.add(comboBoxBtn);
     comboBoxBtn.addActionListener(this);
   scoreField =new JTextField("Enter Player score here");
    rankField =new JTextField("Enter Player Rank here");
    //to be team drop down
   teamField=new JTextField("Enter Player Team here");
    nameField=new JTextField("Enter Player Name here");
   ageField=new JTextField("Enter Player Age here");
  salaryField=new JTextField("Enter Player salary here");
   numberField=new JTextField("Enter Player number here");
   this.add(teamField);
    this.add(nameField);

   this.add(rankField );
  this.add(scoreField);
    this.add(ageField);
    this.add(salaryField);
    this.add(numberField);
   // nameLabel =new JLabel("Player Name");
   // nameLabel.setBounds(200,100,200,20);
    //this.add(nameLabel);
    nameField.setBounds(300,30,200,20);
    ageField.setBounds(300,130,200,20);
    salaryField.setBounds(300,230,200,20);
    numberField.setBounds(300,330,200,20);
    teamField.setBounds(820,30,200,20);
    rankField.setBounds(820,130,200,20);
    scoreField.setBounds(820,230,200,20);

}

    @Override
    //to add fields of player subclasses
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()== comboBoxBtn){
        comboBoxChoice= (String) comboBox.getItemAt(comboBox.getSelectedIndex());
        checkBoxLabel.setText( "here screen"+ comboBoxChoice+"  "+"should be implemented");
    }
    }
}

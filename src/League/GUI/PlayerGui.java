package League.GUI;
import League.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerGui extends JPanel implements ActionListener {

    public  PlayerGui() {
        this.setPreferredSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(3, 1));
        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(1, 1));
        JPanel panel3 = new JPanel(new GridLayout(1, 1));
        ImageIcon addPlayerIcon =new ImageIcon("src/Assets/add-player.png");

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
        this.setVisible(true);

    }
public void AddPlayerGui(){

         JComboBox comboBox;
        JComboBox teamsComboBox;
        JButton comboBoxBtn;
        JLabel checkBoxLabel, titleLabel, nameLabel, scoreLabel, rankLabel, teamLabel, ageLabel, salaryLabel, numberLabel;
        JTextField scoreField,rankField,teamField,nameField,ageField,salaryField,numberField;
        int s = 0;
    try

        {
          s = League.teamnames.size();
            teamsComboBox = new JComboBox(League.teamnames.toArray());
           teamsComboBox.setBounds(300, 350, 100, 20);
            this.setVisible(true);
            this.add(teamsComboBox);

        }
     catch(NullPointerException ignored)

       {

    }
     if(s!=0)

        {
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
            nameField.setBounds(500, 30, 200, 20);
            ageField.setBounds(500, 130, 200, 20);
            salaryField.setBounds(500, 230, 200, 20);
            numberField.setBounds(500, 330, 200, 20);
            teamField.setBounds(820, 30, 200, 20);
            rankField.setBounds(820, 130, 200, 20);
            scoreField.setBounds(820, 230, 200, 20);
        }
     else

        {

            JPanel p1 = new JPanel();
            JLabel warning = new JLabel("Add team First");
            warning.setBounds(350, 130, 500, 50);
            warning.setFont((new Font("Arial", Font.BOLD, 70)));
            p1.add(warning);
            this.add(warning);
        }


        checkBoxLabel=new

        JLabel("choose player position");
     checkBoxLabel.setBounds(820,530,200,20);
     this.add(checkBoxLabel);

}
private void EditPlayerGui(){

}
private void DeletePlayerGui(){

    }

    @Override
   public void actionPerformed(ActionEvent e) {

   }


}


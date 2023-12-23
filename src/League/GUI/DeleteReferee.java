package League.GUI;

import League.League;
import League.Person.Referee.Referee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class DeleteReferee extends JPanel implements ActionListener {
        JButton deleteButton;

        League league;
        MainPanel main;
        CardLayout cardLayout;
        ArrayList<String> refereeNames;

        JComboBox refereeBox;
        public DeleteReferee(League league, MainPanel main,CardLayout cardLayout){
                this.main =main;
                this.league = league;
                this.cardLayout= cardLayout;
                refereeNames = new ArrayList<>();
                for(Referee referee: league.getReferees()){
                        refereeNames.add(referee.getPersonName());
                }
                this.setSize(new Dimension(980,720));
                this.setLayout(new GridLayout(4,1));

                JPanel titlePanel = new JPanel(new GridLayout(1,1,0,30));
                JLabel titleLabel= new JLabel("Delete Referee");
                titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
                titleLabel.setVerticalAlignment(JLabel.TOP);
                titleLabel.setHorizontalAlignment(JLabel.CENTER);
                titlePanel.add(titleLabel);

                JPanel contentPanel = new JPanel(new GridLayout(2,1,0,50));
                refereeBox= new JComboBox(new DefaultComboBoxModel<>(refereeNames.toArray()));
                refereeBox.addActionListener(this);
                contentPanel.add(refereeBox);
                this.add(titlePanel);
                this.add(contentPanel);

                deleteButton = new JButton("Delete");
                deleteButton.setFocusable(false);
                deleteButton.setFont(new Font("Comic Sans",Font.BOLD,20));
                deleteButton.addActionListener(this);
                contentPanel.add(deleteButton);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
                if(e.getSource()==deleteButton){
                        try {
                                String refereeName = (String) refereeBox.getItemAt(refereeBox.getSelectedIndex());
//    Referee searchReferee = league.searchReferee(refereeName);
                                league.DeleteReferee(refereeName);
                                main.add(new DeleteReferee(league, main, cardLayout), "DeleteReferee");
                                cardLayout.show(main, "RefereeHome");
                                JOptionPane.showMessageDialog(null, "Referee Deleted Succesfully");
                        }
                        catch (NullPointerException exp)
                        {
                                System.out.println("Referee is Null");
                        }
                }

        }
}

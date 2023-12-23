package League.GUI;

import League.League;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteStadium extends JPanel implements ActionListener {
    JComboBox chooseStadium;
    JButton DeleteStadium;
    League league;
    MainPanel main;
    CardLayout cardLayout;
    public DeleteStadium(League league,MainPanel main,CardLayout cardLayout){
        this.league = league;
        this.main = main;
        this.cardLayout = cardLayout;
        this.setSize(new Dimension(980, 720));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel titlePanel = new JPanel(new GridLayout(1, 1));
        JPanel contentPanel=new JPanel(new GridLayout(5, 1,0,30));
        JLabel titleLabel = new JLabel("Delete Stadium");
        titleLabel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        titleLabel.setFont(new Font("Comic Sans",Font.BOLD,35));
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.add(titleLabel);
        this.add(titlePanel);
        this.add(contentPanel);
        //contentPanel.add(panel2);
        JPanel chooseTeamPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contentPanel.add(chooseTeamPanel);
        String [] StadiumNames=new String[league.stadiums.size()];
        for(int i=0;i<league.stadiums.size();i++){
            StadiumNames[i]=league.stadiums.get(i).getStadiumName();
        }
        chooseStadium = new JComboBox(new DefaultComboBoxModel<>(StadiumNames));
        chooseStadium.setSize(new Dimension(500,400));
        chooseStadium.addActionListener(this);
        chooseStadium.setEditable(false);
        chooseTeamPanel.add(chooseStadium);

        JPanel DeleteStadiumPanel = new JPanel();
        DeleteStadium = new JButton("Delete Stadium");
        DeleteStadium.setSize(new Dimension(100,30));
        DeleteStadium.setFont(new Font("Comic Sans",Font.BOLD,20));
        DeleteStadium.setHorizontalAlignment(SwingConstants.CENTER);
        DeleteStadium.setFocusable(false);
        DeleteStadium.addActionListener(this);
        DeleteStadiumPanel.add(DeleteStadium);
        contentPanel.add(DeleteStadiumPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == DeleteStadium){
            String StadiumName = (String) chooseStadium.getSelectedItem();
            league.DeleteStadium(StadiumName);
            for (int i = 0; i < league.matches.size(); i++) {
                if (league.matches.get(i).getStadium().getStadiumName().equalsIgnoreCase(StadiumName)){
                    league.matches.get(i).setStadium(null);
                }
            }


            cardLayout.show(main,"Stadiums");
            main.add(new AddStadium(league,main,cardLayout),"AddStadium");
            main.add(new EditStadium(league,main,cardLayout),"EditStadium");
            main.add(new DeleteStadium(league,main,cardLayout),"DeleteStadium");
        }
    }
}

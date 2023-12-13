package League.GUI;

import League.GUI.Components.MatchButton;
import League.League;
import League.Match.Match;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Matches extends JPanel implements ActionListener {
    JButton Search;
    MainPanel main;
    CardLayout cardLayout;
    public Matches(MainPanel main,CardLayout cardLayout){
        this.main = main;
        this.cardLayout = cardLayout;
        this.setPreferredSize(new Dimension(980,720));
        this.setBackground(new Color(0x313741));
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        //Search button
        Search = new JButton("Search");
        Search.setBackground(new Color(0x313741));
        Search.setForeground(Color.white);
        Search.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        Search.setFocusable(false);
        Border line = BorderFactory.createLineBorder(Color.white,2);
        Border empty = BorderFactory.createEmptyBorder(5,15,5,15);
        Search.setBorder(new CompoundBorder(line,empty));
        Search.addActionListener(this);
        JPanel SearchContainer = new JPanel();
        SearchContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
        SearchContainer.setBackground(new Color(0x313741));
        SearchContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE,60));
        SearchContainer.add(Search);
        this.add(SearchContainer);
        JLabel upcoming = new JLabel("Upcoming Matches");
        upcoming.setForeground(Color.white);
        upcoming.setBackground(new Color(0x313741));
        upcoming.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
        upcoming.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));
        this.add(upcoming);
        upcoming.setAlignmentX(0.5f);
        MatchButton match1 = new MatchButton("Team 1 vs Team 2",main,cardLayout);
        this.add(match1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Search){
            SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
            JSpinner dateSpinner = new JSpinner(dateModel);
            JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
            dateSpinner.setEditor(dateEditor);
            int result = JOptionPane.showConfirmDialog(this,dateSpinner,"Select Date",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION){
                Date selectedDate = (Date) dateSpinner.getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println(dateFormat.format(selectedDate) instanceof String);
                ArrayList<Match> currentMatches = new ArrayList<>();
                //ArrayList currentDateMatches = new League().Display_match_ByDateFN(dateFormat.format(selectedDate));
                Matches matches = new Matches(main,cardLayout);
                matches.add(new MatchButton("Team 4 vs Team 5",main,cardLayout));
                main.add(matches,"Matches");
                cardLayout.show(main,"Matches");
            }
        }
    }
}

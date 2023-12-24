package League.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlayerHome extends JPanel {
    public PlayerHome(MainPanel main, CardLayout cardLayout, ArrayList<String> teamnames){
        this.setSize(new Dimension(980, 720));
        this.setLayout(new GridLayout(3, 1));
        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(1, 1));
        JPanel panel3 = new JPanel(new GridLayout(1, 1));
        ImageIcon addPlayerIcon =new ImageIcon("src/Assets/add-player.png");
        //this.setVisible(true);
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
                if (teamnames.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Add Team First then you can add Player");
                }else {
                    cardLayout.show(main,"AddPlayer");
                }

                /**
                 *
                 * @throws NullPointerException if no team exist
                 */

            }



        });

        panel2Button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (teamnames.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Add Team First then you can edit Players");
                }else {
                    cardLayout.show(main,"EditPlayer");
                }
            }

        });

        panel3Button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (teamnames.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Add Team First then you can delete Players");
                }else {
                    cardLayout.show(main,"DeletePlayer");
                }
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
}

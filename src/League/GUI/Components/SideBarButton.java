package League.GUI.Components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SideBarButton extends JButton implements MouseListener {
    public SideBarButton(String text){
        super(text);
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 10));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,this.getPreferredSize().height));
        this.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        this.addMouseListener(this);
        this.setBackground(new Color(0x2a2c2f));
        this.setFocusable(false);
        this.setForeground(Color.white);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.black);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(new Color(0x2a2c2f));
    }
}

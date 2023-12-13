package League.GUI;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    CardLayout cardLayout;
    public MainPanel(){
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        PlayerGui playerGui = new PlayerGui();
        Matches matches = new Matches(this,cardLayout);
        Standings standings = new Standings();
        this.add(playerGui,"PlayerGUI");
        this.add(matches,"Matches");
        this.add(standings,"Standings");
    }
}

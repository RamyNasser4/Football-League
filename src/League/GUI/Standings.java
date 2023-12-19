package League.GUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Standings extends JPanel {
    public JTable table;

    public Standings() {
        try {
            // Applying Nimbus Look and Feel
            //UIManager.setLookAndFeel("javax.swing.pilaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[][] data = new Object[][]{
                {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"},
                {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"},
                {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"},
                {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"}, {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"},
                {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"},
                {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"},
                {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"}, {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"},
                {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"},
                {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"},
                {"Data 1", "Data 2", "Data 3", "Data 4"},
                {"More data 1", "More data 2", "More data 3", "More data 4"}
        };
        DefaultTableModel model = new DefaultTableModel(
                data,
                new Object[]{"Column 1", "Column 2", "Column 3", "Column 4"}
        );

//table view
        table = new JTable(model);


        table.setForeground(Color.WHITE);
        table.setBackground(new Color(0, 0, 0));
        table.setFont(new Font("Arial", Font.BOLD, 16));
        table.setRowHeight(40);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setIntercellSpacing(new Dimension(10, 10));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        // Customizing the header row appearance
        JTableHeader header = table.getTableHeader();
        header.setForeground(Color.BLACK);
        header.setBackground(Color.BLACK); // Change header background color
        header.setFont(new Font("Arial", Font.BOLD, 18));

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                thumbColor = Color.WHITE;
                trackColor = Color.DARK_GRAY;
            }
        });
        JButton ByPoints = new JButton("Points");
        ByPoints.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.setDataVector(data, new Object[]{"Column 1", "Column 2", "Column 3", "Column 4"});
            }
        });


        JPanel buttonPanel = new JPanel();
        JButton showListButton = new JButton("average age");
        showListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Object[][] newData = {
                        {"New Data 1", "New Data 2", "New Data 3", "New Data 4"},
                        {"More new data 1", "More new data 2", "More new data 3", "More new data 4"},
                        {"Even more new data 1", "Even more new data 2", "Even more new data 3", "Even more new data 4"}

                };
                model.setDataVector(newData, new Object[]{"Column 1", "Column 2", "Column 3", "Column 4"});
            }
        });

        JButton ByGoals = new JButton("Goals");
        ByGoals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Object[][] newGoalData = {
                        {"New Data 1", "New Data 2", "New Data 3", "New Data 4"},
                        {"More new data 1", "More new data 2", "More new data 3", "More new data 4"},
                        {"Even more new data 1", "Even more new data 2", "Even more new data 3", "Even more new data 4"}, {"New Data 1", "New Data 2", "New Data 3", "New Data 4"},
                        {"More new data 1", "More new data 2", "More new data 3", "More new data 4"},
                        {"Even more new data 1", "Even more new data 2", "Even more new data 3", "Even more new data 4"}

                };
                model.setDataVector(newGoalData, new Object[]{"Column 1", "Column 2", "Column 3", "Column 4"});
            }
        });
        buttonPanel.add(showListButton);
        buttonPanel.add(ByPoints);
        buttonPanel.add(ByGoals);


        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setBackground(new Color(240, 240, 240));
        setVisible(true);
    }
}

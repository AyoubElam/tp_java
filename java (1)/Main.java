import Controllers.*;
import Models.*;
import Views.*;
import javax.swing.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {
    // Set look and feel to a more modern style
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }

    JFrame frame = new JFrame();
    frame.setTitle("Employees & Holidays Management");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(900, 600);
    frame.setLocationRelativeTo(null); // Center the window

    // Create a custom JPanel with a border and background color
    JPanel headerPanel = new JPanel();
    headerPanel.setBackground(new Color(61, 77, 103)); // Dark Blue Header
    headerPanel.setPreferredSize(new Dimension(frame.getWidth(), 50));
    JLabel headerLabel = new JLabel("Employees & Holidays Management", SwingConstants.CENTER);
    headerLabel.setForeground(Color.WHITE);
    headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
    headerPanel.add(headerLabel);

    // Employee View setup
    JPanel eview = new EmployeeView();  // Correct class name
    EmployeeModel em = new EmployeeModel();
    EmployeeController ec = new EmployeeController(em, (EmployeeView) eview);  // Correct casting

    // Holiday View setup
    JPanel hview = new HolidayView();  // Ensure correct HolidayView class
    HolidayModel hm = new HolidayModel();
    HolidayController hc = new HolidayController(hm, (HolidayView) hview);  // Ensure correct casting

    // Create a tabbed pane with custom styling
    JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.setBackground(new Color(61, 77, 103)); // Tab background color
    tabbedPane.setForeground(Color.WHITE); // Tab text color
    tabbedPane.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font for tabs

    // Adding tabs
    tabbedPane.addTab("Employees", eview);
    tabbedPane.addTab("Holidays", hview);

    // Apply some styling to the tabbed pane
    tabbedPane.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI() {
      protected void paintTabArea(Graphics g, int tabPlacement, int width, int height) {
        super.paintTabArea(g, tabPlacement, width);
        g.setColor(new Color(61, 77, 103)); // Highlight color for active tab
        g.fillRect(0, 0, width, height);
      }
    });

    // Adding components to the main frame
    frame.add(headerPanel, BorderLayout.NORTH);
    frame.add(tabbedPane, BorderLayout.CENTER);

    // Make the frame visible
    frame.setVisible(true);
  }
}

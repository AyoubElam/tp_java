package Views;

import Models.EmployeeModel.Post;
import Models.EmployeeModel.Role;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeView extends JPanel {

  private JPanel inputsPanel = new JPanel();
  private JPanel tablePanel = new JPanel();
  private JPanel buttonsPanel = new JPanel();

  public JButton addBtn = new JButton("Add");
  public JButton deleteBtn = new JButton("Delete");
  public JButton updateBtn = new JButton("Update");
  public JButton showBtn = new JButton("Show");

  public JTextField idField = new JTextField();
  public JTextField lnameField = new JTextField("");
  public JTextField fnameField = new JTextField("");
  public JTextField emailField = new JTextField("");
  public JTextField phoneField = new JTextField("");
  public JTextField salaryField = new JTextField("");

  public JComboBox<Role> roleComboBox = new JComboBox<>(Role.values());
  public JComboBox<Post> postComboBox = new JComboBox<>(Post.values());

  public JTable table = new JTable();
  public DefaultTableModel tableModel = new DefaultTableModel();

  public EmployeeView() {

    this.setLayout(new BorderLayout());
    this.add(inputsPanel, BorderLayout.NORTH);
    this.add(tablePanel, BorderLayout.CENTER);
    this.add(buttonsPanel, BorderLayout.SOUTH);

    tablePanel.setLayout(new BorderLayout());
    tablePanel.add(new JScrollPane(table));
    tableModel.setRowCount(0);
    tableModel.addColumn("ID");
    tableModel.addColumn("Last name");
    tableModel.addColumn("First name");
    tableModel.addColumn("Email");
    tableModel.addColumn("Phone");
    tableModel.addColumn("Salary");
    tableModel.addColumn("Post");
    tableModel.addColumn("Role");
    tableModel.addColumn("Solde");
    table.setModel(tableModel);

    inputsPanel.setLayout(new GridLayout(8, 2));
    inputsPanel.add(new JLabel("ID"));
    inputsPanel.add(idField);
    inputsPanel.add(new JLabel("Last name"));
    inputsPanel.add(lnameField);
    inputsPanel.add(new JLabel("First name"));
    inputsPanel.add(fnameField);
    inputsPanel.add(new JLabel("Email"));
    inputsPanel.add(emailField);
    inputsPanel.add(new JLabel("Phone"));
    inputsPanel.add(phoneField);
    inputsPanel.add(new JLabel("Salary"));
    inputsPanel.add(salaryField);
    inputsPanel.add(new JLabel("Role"));
    inputsPanel.add(roleComboBox);
    inputsPanel.add(new JLabel("Post"));
    inputsPanel.add(postComboBox);

    addBtn.setBackground(new Color(61, 77, 103));  // Green background
    addBtn.setForeground(Color.WHITE);  // White text
    addBtn.setBorderPainted(false);  // Remove border

    deleteBtn.setBackground(new Color(61, 77, 103));  // Red background
    deleteBtn.setForeground(Color.WHITE);  // White text
    deleteBtn.setBorderPainted(false);  // Remove border

    updateBtn.setBackground(new Color(61, 77, 103));  // Blue background
    updateBtn.setForeground(Color.WHITE);  // White text
    updateBtn.setBorderPainted(false);  // Remove border

    showBtn.setBackground(new Color(61, 77, 103));  // Yellow background
    showBtn.setForeground(Color.WHITE);  // Black text
    showBtn.setBorderPainted(false);  // Remove border


    buttonsPanel.setLayout(new FlowLayout());
    buttonsPanel.add(addBtn);
    buttonsPanel.add(deleteBtn);
    buttonsPanel.add(updateBtn);
    buttonsPanel.add(showBtn);

  }
}

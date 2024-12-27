package Controllers;

import DAO.EmployeeDAOImpl;
import Models.EmployeeModel;
import Views.EmployeeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmployeeController {

  private EmployeeView view;
  private EmployeeModel model;

  public EmployeeController(EmployeeModel model, EmployeeView view) {
    this.model = model;
    this.view = view;
    populateTable();
    initAddEvent();
    initDeleteEvent();
    initUpdateEvent();
    initShowEvent();
  }

  private void initAddEvent() {
    view.addBtn.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                model =
                        new EmployeeModel(
                                view.lnameField.getText(),
                                view.fnameField.getText(),
                                view.emailField.getText(),
                                view.phoneField.getText(),
                                Double.parseDouble(view.salaryField.getText()),
                                view.postComboBox.getSelectedItem().toString(),
                                view.roleComboBox.getSelectedItem().toString());

                boolean isAdded = model.addEmployee();
                if (isAdded) {
                  populateTable();
                  JOptionPane.showMessageDialog(
                          null,
                          "Employee " + model.getFname() + " added!",
                          "New",
                          JOptionPane.INFORMATION_MESSAGE);
                } else {
                  JOptionPane.showMessageDialog(
                          null, "Can't add employee " + model, "New", JOptionPane.ERROR_MESSAGE);
                }
              }
            });
  }

  private void initDeleteEvent() {
    view.deleteBtn.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(view.idField.getText());
                boolean isDeleted = model.deleteEmployee(id);
                if (isDeleted) {
                  populateTable();
                  JOptionPane.showMessageDialog(
                          null,
                          "Employee with ID " + id + " deleted!",
                          "Delete",
                          JOptionPane.INFORMATION_MESSAGE);
                } else {
                  JOptionPane.showMessageDialog(
                          null,
                          "Can't delete Employee with ID " + id,
                          "Delete",
                          JOptionPane.ERROR_MESSAGE);
                }
              }
            });
  }

  private void initUpdateEvent() {
    view.updateBtn.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                // Get the selected row index
                int selectedRow = view.table.getSelectedRow();

                if (selectedRow != -1) { // If a row is selected
                  // Extract ID from selected row
                  int id = (int) view.table.getValueAt(selectedRow, 0);

                  // Create updated EmployeeModel from user inputs
                  EmployeeModel em =
                          new EmployeeModel(
                                  view.lnameField.getText(),
                                  view.fnameField.getText(),
                                  view.emailField.getText(),
                                  view.phoneField.getText(),
                                  Double.parseDouble(view.salaryField.getText()),
                                  view.postComboBox.getSelectedItem().toString(),
                                  view.roleComboBox.getSelectedItem().toString());

                  // Update the employee
                  boolean isUpdated = em.updateEmployee(id);
                  if (isUpdated) {
                    populateTable();
                    JOptionPane.showMessageDialog(
                            null,
                            "Employee with ID " + id + " updated with new values.",
                            "Update",
                            JOptionPane.INFORMATION_MESSAGE);
                  } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Can't update Employee with ID " + id,
                            "Update",
                            JOptionPane.ERROR_MESSAGE);
                  }
                } else {
                  JOptionPane.showMessageDialog(
                          null,
                          "Please select an employee from the table to update.",
                          "Update",
                          JOptionPane.WARNING_MESSAGE);
                }
              }
            });
  }

  public void initShowEvent() {
    view.showBtn.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                populateTable();
              }
            });
  }

  public void populateTable() {
    EmployeeModel em = null;
    String query = "SELECT * FROM employee";
    try {
      EmployeeDAOImpl.rs = EmployeeDAOImpl.st.executeQuery(query);
      view.tableModel.setRowCount(0);
      while (EmployeeDAOImpl.rs.next()) {
        em = new EmployeeModel(EmployeeDAOImpl.rs);
        view.tableModel.addRow(
                new Object[] {
                        em.getId(),
                        em.getLname(),
                        em.getFname(),
                        em.getEmail(),
                        em.getPhone(),
                        em.getSalary(),
                        em.getPost(),
                        em.getRole(),
                        em.getSolde()
                });
      }
      view.table.setModel(view.tableModel);
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public void emptyFields() {
    view.idField.setText("");
    view.lnameField.setText("");
    view.fnameField.setText("");
    view.emailField.setText("");
    view.phoneField.setText("");
    view.salaryField.setText("");
    view.postComboBox.setSelectedIndex(0);
    view.roleComboBox.setSelectedIndex(0);
  }
}

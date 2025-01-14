package DAO;

import Models.EmployeeModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// public class EmployeeDAOImpl implements GenericDAOI<EmployeeModel> {
public class EmployeeDAOImpl implements EmployeeDAOI {
  public static Connection con = null;
  public static Statement st = null;
  public static ResultSet rs = null;

  public EmployeeDAOImpl() {
    if (con != null && st != null) return;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

      con = DriverManager.getConnection(url, dbuser, dbpw);
      System.out.println("[EmployeeDAOImpl] Connection established!!");
      st = con.createStatement();
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  @Override
  public boolean addEmployee(EmployeeModel em) {
    boolean ret = false;
    String query =
        "INSERT INTO employee(lname, fname, email, phone, salary, post, role) VALUES ( '"
            + em.getLname()
            + "', '"
            + em.getFname()
            + "', '"
            + em.getEmail()
            + "', '"
            + em.getPhone()
            + "', "
            + em.getSalary()
            + ", '"
            + em.getPost()
            + "', '"
            + em.getRole()
            + "'"
            + ")";

    try {
      if (1 <= st.executeUpdate(query)) ret = true;
    } catch (SQLException e) {
      System.err.println(e);
    }
    return ret;
  }

  @Override
  public boolean deleteEmployee(int id) {
    boolean ret = false;
    String query = "DELETE FROM employee WHERE id=" + id;
    try {
      if (1 <= st.executeUpdate(query)) ret = true;
    } catch (Exception e) {
      System.err.println(e);
    }
    return ret;
  }

  @Override
  public boolean updateEmployee(int id, EmployeeModel em) {
    boolean ret = false;
    String query =
        "UPDATE employee SET lname='"
            + em.getLname()
            + "', fname='"
            + em.getFname()
            + "', email='"
            + em.getEmail()
            + "', phone='"
            + em.getPhone()
            + "', salary="
            + em.getSalary()
            + ", post='"
            + em.getPost()
            + "', role='"
            + em.getRole()
            + "' WHERE id="
            + id;

    try {
      if (1 <= st.executeUpdate(query)) ret = true;
    } catch (Exception e) {
      System.err.println(e);
    }
    return ret;
  }
}

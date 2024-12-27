package DAO;

import Models.EmployeeModel;

interface EmployeeDAOI {
  public String url = "jdbc:mysql://localhost:3306/employees";
  public String dbuser = "root";
  public String dbpw = "";

  public boolean addEmployee(EmployeeModel em);

  public boolean deleteEmployee(int id);

  public boolean updateEmployee(int id, EmployeeModel em);
}

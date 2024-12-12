// Interface definissant les operations de base pour la gestion des employees en base de donnees
package DAO;

import Models.Employee;

interface EmployeeDAOI {
  // Constantes de connexion a la base de donnees MySQL
  public String url = "jdbc:mysql://localhost:3306/java_db";    // URL de connexion
  public String dbuser = "root";                               // Nom utilisateur DB
  public String dbpw = "root";                                 // Mot de passe DB



  // Ajoute un nouvel employee dans la base
  public boolean addEmployee(Employee em);

  // Supprime un employee par son ID
  public boolean deleteEmployee(int id);

  // Met a jour les infos d'un employee existant
  public boolean updateEmployee(int id, Employee em);
}
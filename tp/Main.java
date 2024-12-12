// Import des classes necessaires 
import Controllers.EmployeeController;    // Controleur pour la logique business
import DAO.EmployeeDAOImpl;              // Implementation DAO pour acces donnees
import Views.EmployeeView;               // Vue pour interface utilisateur

public class Main {
  public static void main(String[] args) {
    // Creation objet DAO pour acces aux donnees employees
    EmployeeDAOImpl dao = new EmployeeDAOImpl();

    // Creation controleur pour gerer interactions vue et DAO
    EmployeeController ec = new EmployeeController();

    // Creation vue pour afficher infos employees
    EmployeeView ev = new EmployeeView();

  }
}
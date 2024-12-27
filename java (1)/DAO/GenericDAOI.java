package DAO;

import java.util.List;

public interface GenericDAOI<T> {
  public String url = "jdbc:mysql://localhost:3306/employees";
  public String dbuser = "root";
  public String dbpw = "";

  public List<T> getAll();

  public T findById(int id);

  public boolean add(T m);

  public boolean delete(int id);

  public boolean update(int id, T m);

  public int updateSolde(int id, int decriment);
}

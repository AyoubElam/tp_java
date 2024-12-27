package Models;

import DAO.HolidayDAOImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class HolidayModel {
  private HolidayDAOImpl dao = null;

  private int eid, id;
  private String EmployeeName = "";
  private String startDate = null;
  private String endDate = null;
  private String type = null;

  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  // Constructors
  public HolidayModel() {
    this.dao = new HolidayDAOImpl();
  }

  public HolidayModel(HolidayDAOImpl dao) {
    this.dao = dao;
  }

  public HolidayModel(int eid, String startDate, String endDate, String type) {
    this.eid = eid;
    this.startDate = startDate;
    this.endDate = endDate;
    this.type = type;
    this.dao = new HolidayDAOImpl();
  }

  public HolidayModel(ResultSet rs) {
    if (dao == null) dao = new HolidayDAOImpl();
    try {
      this.id = rs.getInt("id");
      this.eid = rs.getInt("eid");
      this.EmployeeName = rs.getString("fname") + " " + rs.getString("lname");
      this.startDate = rs.getString("startdate");
      this.endDate = rs.getString("enddate");
      this.type = rs.getString("type");
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  // Getters
  public int getId() {
    return this.id;
  }

  public int getEid() {
    return this.eid;
  }

  public String getEmployeeName() {
    return this.EmployeeName;
  }

  public String getStartDate() {
    return this.startDate;
  }

  public String getEndDate() {
    return this.endDate;
  }

  public String getType() {
    return this.type;
  }

  // Setters
  public void setId(int id) {
    this.id = id;
  }

  public void setEid(int eid) {
    this.eid = eid;
  }

  public void setEmployeeName(String EmployeeName) {
    this.EmployeeName = EmployeeName;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public void setType(String type) {
    this.type = type;
  }

  // Methods
  public void addHoliday() {
    int days =
        (int)
            ChronoUnit.DAYS.between(
                LocalDate.parse(startDate, formatter), LocalDate.parse(endDate, formatter));
    int oldSolde = dao.updateSolde(eid, 0);
    if (oldSolde > 0 && days > 0 && days <= oldSolde) {
      if (dao.add(this)) {
        dao.updateSolde(eid, days);
        System.out.println("holiday added successffuly!");
        return;
      }
      System.err.println("solde is not enough");
    }
  }

  public void deleteHoliday(int id) {
    if (dao.delete(id)) {
      System.out.println("holiday deleted!");
    } else {
      System.err.println("holiday can't be deleted!");
    }
  }

  public void updateHoliday(int id, HolidayModel n) {
    if (dao.update(id, n)) {
      System.out.println("holiday update!");
    } else {
      System.err.println("holiday can't be updated!");
    }
  }

  public List<HolidayModel> getAllHolidys() {
    return dao.getAll();
  }

  public HolidayModel findHolidayById(int id) {
    return this.dao.findById(id);
  }
}

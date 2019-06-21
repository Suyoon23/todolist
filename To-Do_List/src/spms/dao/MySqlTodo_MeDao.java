package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import spms.annotation.Component;
import spms.vo.Todo_Me;

@Component("todomeDao")
public class MySqlTodo_MeDao implements Todo_MeDao {
  DataSource ds;

  public void setDataSource(DataSource ds) {
    this.ds = ds;
  }

  public List<Todo_Me> selectList() throws Exception {
    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      connection = ds.getConnection();
      stmt = connection.createStatement();
      rs = stmt.executeQuery(
          "SELECT MNO,MNAME,EMAIL,CRE_DATE" + 
              " FROM TODO_ME" +
          " ORDER BY MNO ASC");

      ArrayList<Todo_Me> todomes = new ArrayList<Todo_Me>();

      while(rs.next()) {
        todomes.add(new Todo_Me()
        .setNo(rs.getInt("MNO"))
        .setName(rs.getString("MNAME"))
        .setEmail(rs.getString("EMAIL"))
        .setCreatedDate(rs.getDate("CRE_DATE"))	);
      }

      return todomes;

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (rs != null) rs.close();} catch(Exception e) {}
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }

  public int insert(Todo_Me todome) throws Exception  {
    Connection connection = null;
    PreparedStatement stmt = null;

    try {
      connection = ds.getConnection();
      stmt = connection.prepareStatement(
          "INSERT INTO TODO_ME(EMAIL,PWD,MNAME,CRE_DATE,MOD_DATE)"
              + " VALUES (?,?,?,NOW(),NOW())");
      stmt.setString(1, todome.getEmail());
      stmt.setString(2, todome.getPassword());
      stmt.setString(3, todome.getName());
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }

  public int delete(int no) throws Exception {  
    Connection connection = null;
    Statement stmt = null;

    try {
      connection = ds.getConnection();
      stmt = connection.createStatement();
      return stmt.executeUpdate(
          "DELETE FROM TODO_ME WHERE MNO=" + no);

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }

  public Todo_Me selectOne(int no) throws Exception { 
    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      connection = ds.getConnection();
      stmt = connection.createStatement();
      rs = stmt.executeQuery(
          "SELECT MNO,EMAIL,MNAME,CRE_DATE FROM TODO_ME" + 
              " WHERE MNO=" + no);    
      if (rs.next()) {
        return new Todo_Me()
        .setNo(rs.getInt("MNO"))
        .setEmail(rs.getString("EMAIL"))
        .setName(rs.getString("MNAME"))
        .setCreatedDate(rs.getDate("CRE_DATE"));

      } else {
        throw new Exception("가입한 내역이 없습니다.");
      }

    } catch (Exception e) {
      throw e;
    } finally {
      try {if (rs != null) rs.close();} catch(Exception e) {}
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }

  public int update(Todo_Me todome) throws Exception { 
    Connection connection = null;
    PreparedStatement stmt = null;
    try {
      connection = ds.getConnection();
      stmt = connection.prepareStatement(
          "UPDATE TODO_ME SET EMAIL=?,MNAME=?,MOD_DATE=now()"
              + " WHERE MNO=?");
      stmt.setString(1, todome.getEmail());
      stmt.setString(2, todome.getName());
      stmt.setInt(3, todome.getNo());
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }
  
  public Todo_Me exist(String email, String password) throws Exception {
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      connection = ds.getConnection();
      stmt = connection.prepareStatement(
          "SELECT MNAME,EMAIL FROM TODO_ME"
              + " WHERE EMAIL=? AND PWD=?");
      stmt.setString(1, email);
      stmt.setString(2, password);
      rs = stmt.executeQuery();
      if (rs.next()) {
        return new Todo_Me()
          .setName(rs.getString("MNAME"))
          .setEmail(rs.getString("EMAIL"));
      } else {
        return null;
      }
    } catch (Exception e) {
      throw e;

    } finally {
      try {if (rs != null) rs.close();} catch (Exception e) {}
      try {if (stmt != null) stmt.close();} catch (Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }

}

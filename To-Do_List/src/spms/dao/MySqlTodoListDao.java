package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import spms.annotation.Component;
import spms.vo.TodoList;

@Component("todolistDao")
public class MySqlTodoListDao implements TodoListDao {
  DataSource ds;

  public void setDataSource(DataSource ds) {
    this.ds = ds;
  }

  public List<TodoList> selectList() throws Exception {
    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      connection = ds.getConnection();
      stmt = connection.createStatement();
      rs = stmt.executeQuery(
          "SELECT TNO,TNAME,STA_DATE,END_DATE,STATE" + 
          " FROM TODOLISTS" +
          " ORDER BY PNO DESC");

      ArrayList<TodoList> todolists = new ArrayList<TodoList>();

      while(rs.next()) {
        todolists.add(new TodoList()
          .setNo(rs.getInt("TNO"))
          .setTitle(rs.getString("TNAME"))
          .setStartDate(rs.getDate("STA_DATE"))
          .setEndDate(rs.getDate("END_DATE"))
          .setState(rs.getInt("STATE"))	);
      }

      return todolists;

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (rs != null) rs.close();} catch(Exception e) {}
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }

  public int insert(TodoList todolist) throws Exception  {
    Connection connection = null;
    PreparedStatement stmt = null;

    try {
      connection = ds.getConnection();
      stmt = connection.prepareStatement(
        "INSERT INTO TODOLISTS"
        + "(TNAME,CONTENT,STA_DATE,END_DATE,STATE,CRE_DATE,TAGS)"
        + " VALUES (?,?,?,?,0,NOW(),?)");
      stmt.setString(1, todolist.getTitle());
      stmt.setString(2, todolist.getContent());
      stmt.setDate(3, new java.sql.Date(todolist.getStartDate().getTime()));
      stmt.setDate(4, new java.sql.Date(todolist.getEndDate().getTime()));
      stmt.setString(5, todolist.getTags());
      
      return stmt.executeUpdate();

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }
  
  public TodoList selectOne(int no) throws Exception { 
    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      connection = ds.getConnection();
      stmt = connection.createStatement();
      rs = stmt.executeQuery(
        "SELECT TNO,TNAME,CONTENT,STA_DATE,END_DATE,STATE,CRE_DATE,TAGS"
        + " FROM TODOLISTS WHERE TNO=" + no);    
      if (rs.next()) {
        return new TodoList()
          .setNo(rs.getInt("TNO"))
          .setTitle(rs.getString("TNAME"))
          .setContent(rs.getString("CONTENT"))
          .setStartDate(rs.getDate("STA_DATE"))
          .setEndDate(rs.getDate("END_DATE"))
          .setState(rs.getInt("STATE")) 
          .setCreatedDate(rs.getDate("CRE_DATE"))
          .setTags(rs.getString("TAGS"));

      } else {
        throw new Exception("<TODO-LIST>를 찾을 수 없습니다.");
      }

    } catch (Exception e) {
      throw e;
    } finally {
      try {if (rs != null) rs.close();} catch(Exception e) {}
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }

  public int update(TodoList todolist) throws Exception { 
    Connection connection = null;
    PreparedStatement stmt = null;
    try {
      connection = ds.getConnection();
      stmt = connection.prepareStatement(
        "UPDATE TODOLISTS SET "
        + " TNAME=?,"
        + " CONTENT=?,"
        + " STA_DATE=?,"
        + " END_DATE=?,"
        + " STATE=?,"
        + " TAGS=?"
        + " WHERE TNO=?");
      stmt.setString(1, todolist.getTitle());
      stmt.setString(2, todolist.getContent());
      stmt.setDate(3, new java.sql.Date(todolist.getStartDate().getTime()));
      stmt.setDate(4, new java.sql.Date(todolist.getEndDate().getTime()));
      stmt.setInt(5, todolist.getState());
      stmt.setString(6, todolist.getTags());
      stmt.setInt(7, todolist.getNo());
      
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
          "DELETE FROM TODOLISTS WHERE TNO=" + no);

    } catch (Exception e) {
      throw e;

    } finally {
      try {if (stmt != null) stmt.close();} catch(Exception e) {}
      try {if (connection != null) connection.close();} catch(Exception e) {}
    }
  }
}

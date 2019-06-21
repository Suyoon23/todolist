package spms.dao;

import java.util.List;

import spms.vo.TodoList;

public interface TodoListDao {
  List<TodoList> selectList() throws Exception;
  int insert(TodoList todolist) throws Exception;
  TodoList selectOne(int no) throws Exception;
  int update(TodoList todolist) throws Exception;
  int delete(int no) throws Exception;
}

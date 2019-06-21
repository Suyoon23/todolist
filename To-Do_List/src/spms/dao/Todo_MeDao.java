package spms.dao;

// MemberDao 인터페이스 정의 
import java.util.List;

import spms.vo.Todo_Me;

public interface Todo_MeDao {
  List<Todo_Me> selectList() throws Exception;
  int insert(Todo_Me todome) throws Exception;
  int delete(int no) throws Exception;
  Todo_Me selectOne(int no) throws Exception;
  int update(Todo_Me todome) throws Exception;
  Todo_Me exist(String email, String password) throws Exception;
}

package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.controls.Controller;
import spms.dao.TodoListDao;

@Component("/todolist/list.do")
public class TodoListListController implements Controller {
  TodoListDao todolistDao;
  
  public TodoListListController setTodo_MeDao(TodoListDao todolistDao) {
    this.todolistDao = todolistDao;
    return this;
  }

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    model.put("todolists", todolistDao.selectList());
    return "/todolist/TodoListList.jsp";
  }
}

package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.TodoListDao;
import spms.vo.TodoList;

@Component("/todolist/add.do")
public class TodoListAddController implements Controller, DataBinding {
  TodoListDao todolistDao;
  
  public TodoListAddController setProjectDao(TodoListDao todolistDao) {
    this.todolistDao = todolistDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "todolist", spms.vo.TodoList.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    TodoList todolist = (TodoList)model.get("todolist");
    if (todolist.getTitle() == null) {
      return "/todolist/TodoListForm.jsp";
      
    } else {
      todolistDao.insert(todolist);
      return "redirect:list.do";
    }
  }
}

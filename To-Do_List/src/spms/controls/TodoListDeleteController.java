package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.controls.Controller;
import spms.dao.TodoListDao;

@Component("/todolist/delete.do")
public class TodoListDeleteController implements Controller, DataBinding {
  TodoListDao todolistDao;
  
  public TodoListDeleteController setTodoListDao(TodoListDao todolistDao) {
    this.todolistDao = todolistDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "no", Integer.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Integer no = (Integer)model.get("no");
    todolistDao.delete(no);
    
    return "redirect:list.do";
  }
}

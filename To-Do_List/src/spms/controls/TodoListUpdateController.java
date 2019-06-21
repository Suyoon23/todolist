package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.TodoListDao;
import spms.vo.TodoList;

@Component("/todolist/update.do")
public class TodoListUpdateController implements Controller, DataBinding {
  TodoListDao todolistDao;
  
  public TodoListUpdateController setTodoListDao(TodoListDao todolistDao) {
    this.todolistDao = todolistDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "no", Integer.class,
        "todolist", spms.vo.TodoList.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    TodoList todolist = (TodoList)model.get("todolist");
    if (todolist.getTitle() == null) { 
      Integer no = (Integer)model.get("no");
      TodoList detailInfo = TodoListDao.selectOne(no);
      model.put("todolist", detailInfo);
      return "/todolist/TodolistUpdateForm.jsp";
    } else { 
      TodoListDao.update(todolist);
      return "redirect:list.do";
    }
  }
}

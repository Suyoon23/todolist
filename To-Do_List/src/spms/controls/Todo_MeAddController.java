package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.Todo_MeDao;
import spms.vo.Todo_Me;


@Component("/todome/add.do")
public class Todo_MeAddController implements Controller, DataBinding {
  Todo_MeDao todomeDao;
  
  public Todo_MeAddController setTodo_MeDao(Todo_MeDao todomeDao) {
    this.todomeDao = todomeDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "todome", spms.vo.Todo_Me.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Todo_Me todome = (Todo_Me)model.get("todome");
    if (todome.getEmail() == null) { 
      return "/todome/Todo_MeForm.jsp";
    } else { 
      Todo_MeDao.insert(todome);
      return "redirect:list.do";
    }
  }
}

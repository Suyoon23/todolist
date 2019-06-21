package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.Todo_MeDao;


@Component("/todome/delete.do")
public class Todo_MeDeleteController implements Controller, DataBinding {
  Todo_MeDao todomeDao;
  
  public Todo_MeDeleteController setTodo_MeDao(Todo_MeDao todomeDao) {
    this.todomeDao = todomeDao;
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
    todomeDao.delete(no);
    
    return "redirect:list.do";
  }
}

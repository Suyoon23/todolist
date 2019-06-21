package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.Todo_MeDao;
import spms.vo.Todo_Me;


@Component("/todome/update.do")
public class Todo_MeUpdateController implements Controller, DataBinding {
  Todo_MeDao todomeDao;
  
  public Todo_MeUpdateController setMemberDao(Todo_MeDao todomeDao) {
    this.todomeDao = todomeDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "no", Integer.class,
        "todome", spms.vo.Todo_Me.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Todo_Me todome = (Todo_Me)model.get("todome");
    
    if (todome.getEmail() == null) { 
      Integer no = (Integer)model.get("no");
      Todo_Me detailInfo = todomeDao.selectOne(no);
      model.put("todome", detailInfo);
      return "/todome/Todo_MeUpdateForm.jsp";

    } else { 
      todomeDao.update(todome);
      return "redirect:list.do";
    }
  }
}

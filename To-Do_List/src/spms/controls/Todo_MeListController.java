package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.dao.Todo_MeDao;

@Component("/todome/list.do")
public class Todo_MeListController implements Controller {
  Todo_MeDao todomeDao;
  
  public Todo_MeListController setMemberDao(Todo_MeDao todomeDao) {
    this.todomeDao = todomeDao;
    return this;
  }

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    model.put("todomes", todomeDao.selectList());
    return "/todome/Todo_MeList.jsp";
  }
}

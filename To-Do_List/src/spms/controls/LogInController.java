package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.Todo_MeDao;
import spms.vo.Todo_Me;

// Annotation 적용
@Component("/auth/login.do")
public class LogInController implements Controller, DataBinding {
  Todo_MeDao todomeDao;
  
  public LogInController setMemberDao(Todo_MeDao todomeDao) {
    this.todomeDao = todomeDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "loginInfo", spms.vo.Todo_Me.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Todo_Me loginInfo = (Todo_Me)model.get("loginInfo");
    
    if (loginInfo.getEmail() == null) { 
      return "/auth/LogInForm.jsp";
      
    } else { 
      Todo_Me todome = todomeDao.exist(
          loginInfo.getEmail(), 
          loginInfo.getPassword());
      
      if (todome != null) {
        HttpSession session = (HttpSession)model.get("session");
        session.setAttribute("todome", todome);
        return "redirect:../todome/list.do";
      } else {
        return "/auth/LogInFail.jsp";
      }
    }
  }
}

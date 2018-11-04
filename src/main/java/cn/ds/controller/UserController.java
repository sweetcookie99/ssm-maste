package cn.ds.controller;


import cn.ds.pojo.*;
import cn.ds.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

/**
 * 用户的控制层
 *
 * @author ds
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //注入service
    @Autowired
    private UserService userService;

    // 用户登录
    @RequestMapping(value = "/login")
    public String login(@RequestParam String username,@RequestParam String password, Model model) {
        User user = userService.login(username);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        if (user != null) {
            if (user.getPassword().equals(password)) {
                //登录成功
               //return "page/page";
                return "page/admin/adhome";
            } else {
                model.addAttribute("message", "登录失败");
                return "page/loginInfo";
            }
        } else {
            model.addAttribute("message", "你输入的用户名或密码有误");
            return "page/loginInfo";
        }
    }

   //显示所有老师
    @RequestMapping("/findallteacher")
    public String findTeacherAll(Model model){
               List<Teacher>teachers  = userService.findTeacherAll();
        for(int i = 0 ; i < teachers.size() ; i++) {
            System.out.println(teachers.get(i));
        }
        model.addAttribute("teachers",teachers);
        return  "page/admin/adteacher";
    }

    //保存老师
    @RequestMapping(value = "/save")
    public String create(Teacher teacher, Model model) {
        try {
            userService.create(teacher);
            model.addAttribute("message", "保存客户信息系成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
           return "redirect:findallteacher.do";
    }

    //老师删除的方法
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam Long id, Model model) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:findallteacher.do";
    }

    //查找知识点
  @RequestMapping("/findpoint1")
    public String findPoint1All(Model model){
        List<Point1>point1  = userService.findPoint1All();
      for (Point1 c : point1) {
          System.out.println(c);
          List<Point2> ps = c.getPoint2();
          for (Point2 p : ps) {
              System.out.println("\t"+p);
          }
      }
      model.addAttribute("point1",point1);
      return "page/admin/adpoint";
    }



    //跳转到老师列表页面
    @RequestMapping(value = "/ListTeacher")
    public String toListPage(Model model) {
        return "redirect:findallteacher.do";
    }
    // 回到登录页
    @RequestMapping(value="/index")
    public String index(){
        return    "index";
    }
    //跳转到老师
    @RequestMapping("/toteacher")
    public String toSavePage() {
        return "page/admin/adteacher";
    }
    //跳转到题库
    @RequestMapping("/ListTk")
    public String Tk() {
        return "page/admin/adpoint";
    }
}

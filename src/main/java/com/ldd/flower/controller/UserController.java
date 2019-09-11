package com.ldd.flower.controller;

import com.alibaba.fastjson.JSONObject;
import com.ldd.flower.entity.OperationInfo;
import com.ldd.flower.entity.User;
import com.ldd.flower.service.OperationInfoService;
import com.ldd.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Author liudongdong
 * @Date Created in 16:07 2019/9/5
 * @Description
 */
@Controller
public class UserController {
    private Logger logger= Logger.getLogger("UserController");
    @Autowired
    private UserService userService;
    @Autowired
    private OperationInfoService operationInfoService;
    /**
     * 属于user角色
     * @RequiresRoles("user")
     *必须同时属于user和admin角色
     * @RequiresRoles({"user","admin"})
     *属于user或者admin之一;修改logical为OR 即可
     * @RequiresRoles(value={"user","admin"},logical=Logical.OR)
     * */

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    /**
     * @responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
     * 可以直接用ModelandView类
     * */

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody User user, HttpSession session){
        logger.info("login_post");
        JSONObject json=new JSONObject();
        json.put("message",userService.login(user));
        logger.info("login_post: message"+json.getString("message"));
        session.setAttribute("user",userService.findByUsername(user.getUsername()));
        return json;
    }
    @RequestMapping(value = "/loginout",method = RequestMethod.GET)
    public String loginout(HttpSession session){
        session.removeAttribute("user");
        return "/login";
    }
    @RequestMapping(value ="regist",method = RequestMethod.GET)
    public String regist(){
        logger.info("regist_get");
        return "regist";
    }
    @RequestMapping(value = "/regist",method ={ RequestMethod.POST})
    @ResponseBody
    public JSONObject regist(@RequestBody User user){
        logger.info("regist_post");
        JSONObject json=new JSONObject();
        User user1=userService.findByUsername(user.getUsername());
        if(user1==null) {
            userService.saveAndFlush(user);
            json.put("message","注册成功");
        }
        else{
            json.put("message","注册失败");
        }
        logger.info("regist_post: "+json.getString("message"));
        return json;
    }

    /**
     * 用户信息管理逻辑
     * */
    @RequestMapping(value = "/userinfo/list")
    public String userinfoList(HttpServletRequest request, @RequestParam(value="username",required = false) String username, @RequestParam(value="role",required = false) String role)
    {
        logger.info("/userinfo/list:"+username+" role: "+role);
        List<User> userList=new ArrayList<>();
        if(role!=null)
            userList=userService.findUsersByRole(role);
        else if(username!=null)
            userList.add(userService.findByUsername(username));
        else userList=userService.findAll();
        logger.info("/userinfo/list:userlist.size="+userList.size());
        request.setAttribute("myusername",username);
        request.setAttribute("myrole",role);
        request.setAttribute("users",userList);
        return "user/userinfo/list";
    }
    @RequestMapping(value = "/userinfo/useradd")
    public String userinfoAdd(){
        return "user/userinfo/add";
    }
    
    @RequestMapping(value = "/userinfo/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public JSONObject delUser(@PathVariable Integer id){
        JSONObject json=new JSONObject();
        /**
         * userService.deleteUserById(这个函数有问题)；可能不存在
         * */
        logger.info("/userinfo/{id}_delete: id="+id);
        User user=userService.findById(Long.valueOf(id));
        logger.info("/userinfo/{id}_delete: user="+user.toString());
        if(user!=null)
        {
            userService.delete(user);
            json.put("message","操作成功");
        }
        else{
            json.put("message","操作失败");
        }
        return json;
    }
    @RequestMapping(value = "/userinfo/{id}",method = RequestMethod.GET)
    public String userInfoEdit(@PathVariable Integer id,HttpServletRequest request){
        logger.info("UserInfo_get:id="+id);
        request.setAttribute("user",userService.findById(Long.valueOf(id)));
        return "user/userinfo/edit";
    }
    @RequestMapping(value = "/userinfoshow/{id}",method = RequestMethod.GET)
    public String userInfoShow(@PathVariable Integer id,HttpServletRequest request){
        logger.info("UserInfoShow_get:id="+id);
        request.setAttribute("user",userService.findById(Long.valueOf(id)));
        return "user/userinfo/show";
    }
    @RequestMapping(value = "/userinfo",method = RequestMethod.PUT)
    @ResponseBody
    public JSONObject userUpdate(@RequestBody User user){
        JSONObject json=new JSONObject();
        User user1= userService.saveAndFlush(user);
        if(user1!=null)
          json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }
    @RequestMapping(value = "/userinfo",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject userAdd(@RequestBody User user){
        JSONObject json=new JSONObject();
        User user1= userService.saveAndFlush(user);
        if(user1!=null)
            json.put("message","添加成功");
        else
            json.put("message","操作失败");
        return json;
    }



    /*@RequiresRoles(value = {"ADMIN"}, logical= Logical.OR)
    @GetMapping("/add")
    public String save(Model model) {
        List<RoleType> roles = RoleType.list();
        List<Status> status = new LinkedList<>();
        status.add(Status.ACTIVED);
        status.add(Status.LOCKED);
        model.addAttribute("roles", roles).addAttribute("status", status);
        return "admin/user/add";
    }*/
}

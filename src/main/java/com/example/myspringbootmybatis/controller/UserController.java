package com.example.myspringbootmybatis.controller;

import com.example.myspringbootmybatis.mapper.UserMapper;
import com.example.myspringbootmybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    User user;

    //    @GetMapping("finduser")//http://localhost:8080/finduser?id=10
//    public User findUserById( @RequestParam("id") Integer id){
    @GetMapping("finduser/{id}")//http://localhost:8080/finduser/10
    public User findUserById(@PathVariable Integer id) {
        return userMapper.findUserById(id);
    }
    //        List<User> list = (List<User>) userMapper.selectbyname(username);
    @GetMapping("/selectbyname/{username}")
    public List<User>  selectbyname(@PathVariable("username") String username){
        return userMapper.selectbyname(username);
    }

//    @GetMapping("insertUser/{username}/{birthday}/{sex}/{address}")
//    public User insertUser(@PathVariable("username") String username, @PathVariable("birthday") Date birthday,
//                            @PathVariable("sex") String sex,@PathVariable("address") String address){
    //插入方法一
    @GetMapping("/insertUser")//http://localhost:8080/insertUser?username=武晋仪&birthday=1997-10-17&sex=1&address=taiyuanshi
    public User insert(@RequestParam("username") String username, @RequestParam("birthday") Date birthday,
                       @RequestParam("sex") String sex, @RequestParam("address") String address) {
        user.setUsername(username);
        user.setBirthday(birthday);
        user.setSex(sex);
        user.setAddress(address);
        userMapper.insert(user);
        return user;
    }
//插入方法二
    @PostMapping("/insertUser")//http://localhost:8080/insertUser?username=武晋仪&birthday=1997-10-17&sex=1&address=taiyuanshi
    public User insert(User user) {
        userMapper.insert(user);
        return user;
    }

//    @PostMapping("/insertUser")//http://localhost:8080/insertUser?username=武晋仪&birthday=1997-10-17&sex=1&address=taiyuanshi
//    public ModelAndView insert(User user,ModelAndView mv) {
//        userMapper.insert(user);
////        return user;
//        mv.setViewName("selectAll");
//        return mv;
//    }

//    @GetMapping("/update/{id}/{name}/{birthday}/{sex}/{address}")
//    public User update(@PathVariable("id") Integer id,@PathVariable("name") String name,
//                      @PathVariable("birthday") Date birthday, @PathVariable("sex") String sex,
//                      @PathVariable("address") String address){

//    @GetMapping("/insert")
//    public User update(@RequestParam("id") Integer id, @RequestParam("username") String username,
//                       @RequestParam("birthday") Date birthday,
//                       @RequestParam("sex") String sex, @RequestParam("address") String address) {
//        user.setId(id);
//        user.setUsername(username);
//        user.setBirthday(birthday);
//        user.setSex(sex);
//        user.setAddress(address);
//        userMapper.update(user);
//        return user;
//    }
//更新方法一
    @GetMapping("/update/{id}/{username}/{birthday}/{sex}/{address}")
    public int update(@PathVariable("id") Integer id,@PathVariable("username") String username,
                      @PathVariable("birthday") Date birthday,
                      @PathVariable("sex") String sex,@PathVariable("address") String address){
        user.setId(id);
        user.setUsername(username);
        user.setSex(sex);
        user.setAddress(address);
        user.setBirthday(birthday);
        return userMapper.updateUserById(user);
    }
    //更新方法二
    @RequestMapping("update")
    public ModelAndView update(@RequestParam("id") Integer id, ModelAndView mv){
        User user = userMapper.findUserById(id);
        System.out.println(user.getId());
        mv.addObject("user",user);
        mv.setViewName("update");
        return mv;
    }
    @PostMapping("do_update")
    public ModelAndView updateUserById(User user, ModelAndView mv){
        userMapper.updateUserById(user);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        mv.setViewName("redirect:selectAll");
        return mv;
    }
//删除方法一
    @GetMapping("/delete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return userMapper.deleteUserById(id);
    }
//删除方法二
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam Integer id,ModelAndView mv){
        userMapper.deleteUserById(id);
        mv.setViewName("redirect:selectAll");
        return mv;
    }
    @RequestMapping("selectAll")
    public ModelAndView selectAll(ModelAndView mv){
        List<User> list = userMapper.selectAll();
        mv.addObject("users", list);
        mv.setViewName("selectAll");
        return mv;
    }
}


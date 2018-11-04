package cn.ds.service.impl;

import cn.ds.mapper.UserMapper;
import cn.ds.pojo.Point1;
import cn.ds.pojo.Teacher;
import cn.ds.pojo.User;
import cn.ds.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ds
 *
 */
@Service
public class UserServiceImpl implements UserService {

    //注入
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录的方法
     */
    public User login(String username) {
        return userMapper.login(username);
    }
    //查找所有的老师
    @Override
    public List<Teacher> findTeacherAll() {
        return userMapper.findTeacherAll();
    }

    //x新建老师
    @Override
    public void create(Teacher teacher) {
            userMapper.create(teacher);
    }



    //知识点一级目录
    @Override
    public List<Point1> findPoint1All() {
        return userMapper.findPoint1All();
    }


   /* @Override
    public Point1 selectUserInfoByName(String name) {
        return userMapper.selectUserInfoByName(name);
    }*/

    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }


    public void create(User user) {

    }

    public void delete(Long id) {
        userMapper.delete(id);

    }

    @Override
    public void update(User user) {

    }

    public void update(Teacher teacher) {
        userMapper.update(teacher);
    }


}

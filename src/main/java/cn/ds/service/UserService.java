package cn.ds.service;

import cn.ds.pojo.Point1;
import cn.ds.pojo.Teacher;
import cn.ds.pojo.User;

import java.util.List;

/**
 * @author ds
 * @date 业务层
 */
public interface UserService extends BaseService<User> {

    User login(String username);
    List<Teacher> findTeacherAll();
    void create(Teacher teacher);
    List<Point1> findPoint1All();

}

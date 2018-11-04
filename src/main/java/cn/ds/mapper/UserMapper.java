package cn.ds.mapper;

import cn.ds.pojo.*;

import java.util.List;

/**
 * @author ds
 */
public interface UserMapper {

    User login(String username);
    void create(Teacher teacher);
    void delete(Long id);
    void update(Teacher teacher);
    Teacher findById(Long id);
    List<Teacher> findTeacherAll();
    List<Point1> findPoint1All();


    //  List<Point1> findPoint();
}

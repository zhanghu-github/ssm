package com.zh;

import com.zh.dao.UserMapper;
import com.zh.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class App {

    @Resource
    private UserMapper userMapper;

    public static void main(String[] args) {
        // 启动spring
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取spring bean
        App app = context.getBean("app", App.class);

        app.testFindById();

        app.testInsert();
        app.testFindAll();

        app.testUpdate();
        app.testFindAll();

        app.testDelete();
        app.testFindAll();
    }

    public void testFindById() {
        try {
            User user = userMapper.findById(4);
            System.out.println(user);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testFindAll() {
        try {
            List<User> userList = userMapper.findAll();
            for (User u : userList) {
                System.out.println(u);
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testInsert() {
        User user = new User("小明", "123456", "xiaoMing@163.com", "2009-01-01");
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testUpdate() {
        try {
            User user = userMapper.findByName("小明");
            user.setPassword("abcdef");
            userMapper.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testDelete() {
        try {
            User user = userMapper.findByName("小明");
            userMapper.deleteById(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

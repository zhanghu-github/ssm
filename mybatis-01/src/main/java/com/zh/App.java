package com.zh;

import com.zh.dao.UserMapper;
import com.zh.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class App {

    private static SqlSessionFactory sqlSessionFactory;

    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testFindById();

        testInsert();
        testFindAll();

        testUpdate();
        testFindAll();

        testDelete();
        testFindAll();
    }

    public static void testFindById() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findById(4);
            System.out.println(user);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void testFindAll() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> userList = userMapper.findAll();
            for (User u : userList) {
                System.out.println(u);
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void testInsert() {
        User user = new User("小明", "123456", "xiaoMing@163.com", "2009-01-01");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.insert(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void testUpdate() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findByName("小明");
            user.setPassword("abcdef");
            userMapper.update(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void testDelete() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.findByName("小明");
            userMapper.deleteById(user.getId());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}

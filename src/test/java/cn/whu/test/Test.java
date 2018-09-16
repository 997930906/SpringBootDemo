package cn.whu.test;


import cn.whu.APP;
import cn.whu.dao.UserDao;
import cn.whu.model.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = APP.class)
//@Sql("/init-schema.sql")
public class Test {

    @Autowired
    UserDao userDao;

    @org.junit.Test
    public void context(){
        Random random = new Random();
        User user = new User();
        user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
        user.setName(String.format("USER%d", 2));
        user.setPassword("");
        user.setSalt("");
        userDao.addUser(user);
    }

}

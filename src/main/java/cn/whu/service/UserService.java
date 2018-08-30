package cn.whu.service;

import cn.whu.dao.LoginTicketDAO;
import cn.whu.dao.UserDao;
import cn.whu.model.LoginTicket;
import cn.whu.model.User;
import cn.whu.util.UserUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao userDAO;

    @Autowired
    private LoginTicketDAO loginTicketDAO;
    public User getUser(int id) {
        return userDAO.selectById(id);
    }

    public Map<String,String> register(String username, String password){
        Map< String, String> map = new HashMap< String, String>();
        if(StringUtils.isBlank(username)){
            map.put("msg", "用户名不能为空！");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("msg", "密码不能为空！");
            return map;
        }
        User user = userDAO.selectByName(username);
        if(user != null){
            map.put("msg", "用户名已经被注册！");
            return map;
        }

        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png",
                new Random().nextInt(1000)));
        user.setPassword(UserUtil.MD5(password+user.getSalt()));

        userDAO.addUser(user);

        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);

        return  map;
    }

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isBlank(username)) {
            map.put("msg", "用户名不能为空");
            return map;
        }

        if (StringUtils.isBlank(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }

        User user = userDAO.selectByName(username);

        if (user == null) {
            map.put("msg", "用户名不存在");
            return map;
        }

        if (!UserUtil.MD5(password+user.getSalt()).equals(user.getPassword())) {
            map.put("msg", "密码不正确");
            return map;
        }

        String ticket = addLoginTicket(user.getId());
        map.put("ticket", ticket);
        return map;
    }

    private String addLoginTicket(int userId) {
        LoginTicket ticket = new LoginTicket();
        ticket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        ticket.setExpired(date);
        ticket.setStatus(0);
        ticket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicketDAO.addTicket(ticket);
        return ticket.getTicket();
    }

    public void logout(String ticket) {
        loginTicketDAO.updateStatus(ticket, 1);
        //或者删除
        //loginTicketDAO.delete(ticket);
    }
}

package cn.whu.interceptor;

import cn.whu.model.User;
import org.springframework.stereotype.Component;


@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();//本地线程，存放用户信息

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();;
    }
}

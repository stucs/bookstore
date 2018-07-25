package mypack.pojo;

import mypack.OnlineUsers;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
    private String name;
    private OnlineUsers users = OnlineUsers.getInstance();

    public User(String name) {
        this.name = name;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        users.addUser(name);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        users.removeUser(name);
    }
}

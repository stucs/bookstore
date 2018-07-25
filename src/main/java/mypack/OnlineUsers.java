package mypack;

import java.util.ArrayList;
import java.util.List;

public class OnlineUsers {

    private static OnlineUsers users = new OnlineUsers();
    private ArrayList userList = new ArrayList();

    public void addUser(String name) {
        userList.add(name);
    }

    public static OnlineUsers getInstance() {
        return users;
    }

    public void removeUser(String name) {
        userList.remove(name);
    }

    public List<String> getUsers() {
        return userList;
    }
}

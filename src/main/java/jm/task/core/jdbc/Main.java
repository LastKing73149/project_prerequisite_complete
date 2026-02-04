package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // implement algorithm here
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Billy", "Genie", (byte)32);
        userService.saveUser("Van", "Kachalkin", (byte) 35);
        userService.saveUser("Uncle", "Bogdan", (byte) 40);

        userService.getAllUsers().forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

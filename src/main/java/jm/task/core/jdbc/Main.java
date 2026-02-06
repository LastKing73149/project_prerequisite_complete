package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // implement algorithm here
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        User user1 = new User("Billy", "Genie", (byte)32);
        User user2 = new User("Van", "Kachalkin", (byte) 35);
        User user3 = new User("Uncle", "Bogdan", (byte) 40);
        User user4 = new User("Johnny", "Makarony", (byte) 20)

        User[] users = {user1, user2, user3, user4};
        for(User user : users){
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("Добавлен пользователь с именем - " + user.getName() + "в базу данных");
        }

        userService.getAllUsers().forEach(System.out::println);

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}

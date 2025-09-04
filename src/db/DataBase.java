package db;

import model.Train;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static List<Train> trains = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    public static User user;

    static {
        users.add(new User(1, "Islom", "islom", "123", 0));
        users.add(new User(2, "Asad", "asad", "123", 0));
        users.add(new User(3, "Humoyun", "humoyun", "123", 0));
        users.add(new User(4, "Samandar", "samandar", "123", 0));
    }

    static {
        trains.add(new Train(1, "Toshkent", "Samarqand", 100_000, 5));
        trains.add(new Train(2, "Toshkent", "Buxoro", 150_000, 3));
        trains.add(new Train(3, "Toshkent", "Andijon", 120_000, 4));
    }
}

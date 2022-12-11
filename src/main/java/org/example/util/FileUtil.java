package org.example.util;

import org.example.domain.entity.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import static org.example.util.FilePath.USER_DIRECTORY;

public class FileUtil {

    public static void writeUserToFile(List<User> users) {
        try (FileOutputStream fos = new FileOutputStream(USER_DIRECTORY);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<User> readUserFromFile() {
        try (FileInputStream fis = new FileInputStream(USER_DIRECTORY);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (List<User>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

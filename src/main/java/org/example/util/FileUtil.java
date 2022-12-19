package org.example.util;

import org.example.domain.entity.Book;
import org.example.domain.entity.User;

import java.io.*;
import java.util.List;

import static org.example.util.FilePath.BOOK_DIRECTORY;
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

    public static void writeBookToFile(List<Book> books) {
        try (FileOutputStream fos = new FileOutputStream(BOOK_DIRECTORY);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<User> readUserFromFile() {
        File f = new File(USER_DIRECTORY);
        if (f.exists() && !f.isDirectory()) {
            try (FileInputStream fis = new FileInputStream(USER_DIRECTORY);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                return (List<User>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<Book> readBookFromFile() {
        File f = new File(BOOK_DIRECTORY);
        if (f.exists() && !f.isDirectory()) {
            try (FileInputStream fis = new FileInputStream(BOOK_DIRECTORY);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                return (List<Book>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

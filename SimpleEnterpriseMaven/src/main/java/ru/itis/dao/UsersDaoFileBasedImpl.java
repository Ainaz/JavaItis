package ru.itis.dao;

import com.google.common.base.Splitter;
import ru.itis.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoFileBasedImpl implements UsersDao {

    public static final String FILE_PATH = "C:\\Users\\KFU-user\\Desktop\\JavaItis\\SimpleEnterpriseMaven";
    public static final String FILE_USERS = "\\users.txt";
    private BufferedReader fileReader;
    private BufferedWriter fileWriter;

    public UsersDaoFileBasedImpl(String fileName) {
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try {
            String currentLine = fileReader.readLine();
            while (currentLine != null) {
                User currentUser = parseStringAsUser(currentLine);
                result.add(currentUser);
                currentLine = fileReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("SomeError");
        }
        return result;
    }

    @Override
    public User get(int userId) {
        for (User user : getAll()) {
            if (userId == user.getId()){
                return user;
            }
        }
        return null;
    }

    @Override
    public void save(User user) {
        try {
            fileWriter = new BufferedWriter(new FileWriter(FILE_PATH + FILE_USERS, true));
            fileWriter.write(user.getId() + " " + user.getName() + " " + user.getPassword() + " " + user.getAge());
            fileWriter.newLine();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("SomeError");
        }
    }

    @Override
    public void delete(int userId) throws IOException{
        List<User> temp = new ArrayList<>();
        for (User user : getAll()) {
            if(userId != user.getId()){
            temp.add(user);
            }
        }

        fileWriter = new BufferedWriter(new FileWriter(FILE_PATH + FILE_USERS));

        for (User user : temp) {
            save(user);
        }
        fileWriter.close();
    }

    private User parseStringAsUser(String line) {
        Splitter splitter = Splitter.on(" ");

        List<String> lines = splitter.splitToList(line);

        int id = Integer.parseInt(lines.get(0));
        String name = lines.get(1);
        String password = lines.get(2);
        int age = Integer.parseInt(lines.get(3));

        return new User(name, password, age, id);
    }
}

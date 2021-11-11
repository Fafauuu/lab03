package dataBase;

import exceptions.NoSuchUserException;
import model.users.User;

import java.util.List;

public class UsersDataBase {
    private List<User> usersList;

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public User getUser(String name, String surname) throws NoSuchUserException{
        for (User user : usersList) {
            if (user.getName().equals(name) && user.getSurname().equals(surname)){
                return user;
            }
        }
        throw new NoSuchUserException("There's no person such as " + name + " " + surname);
    }
}

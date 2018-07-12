package smth.account;

import smth.database.DBException;

public interface AccountService {
    MyUser getUserByName(String name) throws DBException;
    void addNewUser(MyUser myUser) throws DBException;
}
package lab.anastasya.account;

import lab.anastasya.database.DBException;

public interface AccountService {
    MyUser getUserByName(String name) throws DBException;
    // void addNewUser(String name, int age, String homeTown) throws DBException;
    void addNewUser2(MyUser myUser) throws DBException;
}

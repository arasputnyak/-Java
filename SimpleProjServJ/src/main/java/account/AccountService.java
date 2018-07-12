package account;

import database.DBException;
import database.DBService;

public class AccountService {
    private final DBService dbService;

    public AccountService(DBService dbService) {
        this.dbService = dbService;
    }

    public MyUser getUserByName(String name) throws DBException {
        return dbService.getUser(name);
    }

    public void addNewUser(String name, int age, String homeTown) throws DBException {
        dbService.addUser(name, age, homeTown);
    }
}

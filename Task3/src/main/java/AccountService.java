import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final DBService dbService;

    public AccountService(DBService dbService) {
        this.dbService = dbService;
    }

    public void addNewUser(String name, String pass) throws DBException {
        try {
            dbService.addUser(name, pass);
        } catch (DBException e) {
            throw new DBException(e);
        }
    }

    public UsersDataSet getUserByLogin(String login, String pass) throws DBException {
        try {
            return dbService.myGetUser(login, pass);
        } catch (DBException e) {
            throw new DBException(e);
        }
    }
}

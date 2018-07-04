package lab.anastasya.account;

import lab.anastasya.database.DBException;
import lab.anastasya.database.UsersRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private UsersRep usersRepo;

    @Override
    @Transactional
    public void addNewUser2(MyUser myUser) {
        MyUser user = myUser;
        usersRepo.save(user);
    }

    @Override
    @Transactional
    public MyUser getUserByName(String name) throws DBException {
        return null;// usersRepo.findByName(name);
    }

    /*
    private final DBService dbService;

    public AccountServiceImpl(DBService dbService) {
        this.dbService = dbService;
    }

    public MyUser getUserByName(String name) throws DBException {
        return dbService.getUser(name);
    }

    public void addNewUser(String name, int age, String homeTown) throws DBException {
        dbService.addUser(name, age, homeTown);
    }

    public void addNewUser2(MyUser myUser) throws DBException {
        addNewUser(myUser.getName(), myUser.getAge(), myUser.getHomeTown());
    }
    */
}

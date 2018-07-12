package smth.account;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smth.database.DBException;
import smth.database.MyUserRepository;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private MyUserRepository usersRepo;

    @Override
    @Transactional
    public void addNewUser(MyUser myUser) {
        MyUser user = myUser;
        usersRepo.save(user);
    }

    @Override
    @Transactional
    public MyUser getUserByName(String name) throws DBException {
        return usersRepo.findByName(name);
    }
}

package smth.database;

import org.springframework.data.jpa.repository.JpaRepository;
import smth.account.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    //@Query("select u from MyUser u where u.name = ?1")
    MyUser findByName(String name);
}
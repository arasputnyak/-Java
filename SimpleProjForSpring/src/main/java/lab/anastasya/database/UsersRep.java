package lab.anastasya.database;

import lab.anastasya.account.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRep extends JpaRepository<MyUser, Integer> {

/*    @Query("select u from users u where u.name = ?1")
    MyUser findByName(String name);*/
}

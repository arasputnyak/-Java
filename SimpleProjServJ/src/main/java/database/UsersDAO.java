package database;

import account.MyUser;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO {
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public MyUser get(long id) throws HibernateException {
        return (MyUser) session.get(MyUser.class, id);
    }

    public long myGetUserId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(MyUser.class);
        return ((MyUser) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getId();
    }

    public long insertUser(String name, int age, String homeTown) throws HibernateException {
        return (Long) session.save(new MyUser(name, age, homeTown));
    }
}

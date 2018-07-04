package lab.anastasya.account;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class MyUser implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, updatable = false)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "homeTown", updatable = false)
    private String homeTown;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age= " + age + ", hometown= " + homeTown + "]";
    }

        /*
    public MyUser(String name, int age, String homeTown) {
        this.setId(-1);
        this.setName(name);
        this.setAge(age);
        this.setHomeTown(homeTown);
    }

    public MyUser(long id, String name, int age, String homeTown) {
        this.setId(id);
        this.setName(name);
        this.setAge(age);
        this.setHomeTown(homeTown);
    }
    */
}

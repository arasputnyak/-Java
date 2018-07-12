package smth.account;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@NamedQueries({@NamedQuery(name="MyUser.findByName", query = "select u from MyUser u where u.name = ?1")})
@Table(name = "users")
public class MyUser implements Serializable {
    private static final Long serialVersionUID = -8706689714326132798L;

    public MyUser() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 10)
    @NotNull
    @Column(name = "name", unique = true, updatable = false)
    private String name;

    @Min(0)
    @NotNull
    @Column(name = "age")
    private Integer age;

    @Size(min = 1, max = 20)
    @NotNull
    @Column(name = "homeTown", updatable = false)
    private String homeTown;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age= " + age + ", hometown= " + homeTown + "]";
    }
}

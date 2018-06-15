package accserver;

public class AccountServer implements AccountServerI {
    private int usersLimit = 10;

    public int getUsersLimit() {
        return usersLimit;
    }

    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }
}

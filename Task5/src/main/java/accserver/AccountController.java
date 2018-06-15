package accserver;

public class AccountController implements AccountControllerMBean {
    private final AccountServer accountServer;

    public AccountController(AccountServer accountServer) {
        this.accountServer = accountServer;
    }
    @Override
    public int getLimit() {
        return accountServer.getUsersLimit();
    }

    @Override
    public void setLimit(int limit) {
        accountServer.setUsersLimit(limit);
    }
}

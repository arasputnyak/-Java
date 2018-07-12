package smth.account;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NameForm {

    public NameForm() {
    }

    @Size(min = 1, max = 10)
    @NotNull
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

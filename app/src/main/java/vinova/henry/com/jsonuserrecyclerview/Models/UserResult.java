package vinova.henry.com.jsonuserrecyclerview.Models;

import java.util.List;

/**
 * Created by dminh on 1/29/2018.
 */

public class UserResult {
    private String status;
    private List<User> users;

    public String getStatus() {
        return status;
    }

    public List<User> getUsers() {
        return users;
    }
}

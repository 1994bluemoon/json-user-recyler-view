package vinova.henry.com.jsonuserrecyclerview.Models;

import android.widget.ListAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dminh on 1/29/2018.
 */

public class User {

    String name;
    String username;
    String avatar;
    String email;
    Address address;
    List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getEmail() {
        return email;
    }
}

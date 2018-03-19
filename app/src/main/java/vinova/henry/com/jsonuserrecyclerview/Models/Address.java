package vinova.henry.com.jsonuserrecyclerview.Models;

/**
 * Created by dminh on 1/29/2018.
 */

public class Address {
    String streetA;
    String streetB;
    String streetC;
    String streetD;
    String city;
    String state;
    String country;
    String zipcode;
    Geo geo;

    public String getStreetA() {
        return streetA;
    }

    public String getStreetB() {
        return streetB;
    }

    public String getStreetC() {
        return streetC;
    }

    public String getStreetD() {
        return streetD;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Geo getGeo() {
        return geo;
    }
}

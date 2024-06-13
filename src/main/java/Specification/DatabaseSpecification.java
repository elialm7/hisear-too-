package Specification;

public class DatabaseSpecification {


    private String baseurl;
    private String user;
    private String password;
    private String databaseName;


    public DatabaseSpecification(){}

    public DatabaseSpecification(String url, String user, String password) {
        this.baseurl = url;
        this.user = user;
        this.password = password;
    }

    public String url() {
        return this.baseurl + databaseName;
    }

    public DatabaseSpecification setBaseurl(String baseurl) {
        this.baseurl = baseurl;
        return this;
    }

    public String user() {
        return user;
    }

    public DatabaseSpecification setUser(String user) {
        this.user = user;
        return this;
    }

    public String password() {
        return password;
    }

    public DatabaseSpecification setPassword(String password) {
        this.password = password;
        return this;
    }

    public String databaseName() {
        return databaseName;
    }

    public DatabaseSpecification setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }
}

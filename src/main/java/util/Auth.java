package util;

public class Auth {
    private static String login = null;
    private static String pwd = null;

    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        Auth.login = login;
    }

    public static String getPwd() {
        return pwd;
    }

    public static void setPwd(String pwd) {
        Auth.pwd = pwd;
    }
}
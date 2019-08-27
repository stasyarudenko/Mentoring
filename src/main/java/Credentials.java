import java.util.HashMap;
import java.util.Map;

public class Credentials {

    private static final String FIRST_NAME = "test";
    private static final String SECOND_NAME = "user";
    private static final String LOGIN = "anrud.user";
    private static final String PASSWORD = "anrud.user123";
    private static final String EMAIL = "anrud.user@gmail.com";

    public Map<String, String> getCredentials() {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("login", LOGIN);
        credentials.put("password", PASSWORD);
        return credentials;
    }

    public String getEmail() {
        return EMAIL;
    }
}

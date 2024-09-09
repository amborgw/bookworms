package bookworms;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;


public class Auth {

    /**
     * Creates new user account with given credentials
     * @param username
     * @param email
     * @param name
     * @param password
     * @return token
     */
    public String userRegister(String username, String email, String name, String password) {
        return "";
    }

    /**
     * Given a username and password, logs user into bookworms account
     * @param username
     * @param password
     * @return token
     */
    public static User userLogin(String username, String password) throws Exception {
        if (!isUsernameValid(username)) {
            throw new HttpException(400, "Username is not valid");
        }
        
        // verify password 
        JSONObject responseBody = PocketBaseClient.authenticateUser(username, password);
        
        // extract details from database to create user instance
        String token = responseBody.getString("token");
        JSONObject record = responseBody.getJSONObject("record");
        String id = record.getString("id");
        String email = record.getString("email");
        String name = record.getString("name");

        // TODO: get their books

        return new User(id, username, email, name, token);
    }

    /**
     * Given a user token, invalidates it, preventing user from accessing system
     * @param token
     */
    public void userLogout(String token) {
        
    }

    /**
     * Sends an email to given email with a link to reset password
     * @param email
     */
    public void passwordResetRequest(String email) {
        
    }

    /**
     * Given a code and password, reset user's password in database to new password
     * @param resetCode
     * @param newPassword
     */
    public void passwordReset(String resetCode, String newPassword) {

    }

    /**
     * Deletes user's account (might need to mve to user object? not sure yet)
     */
    public void userDeleteAccount() {

    }

    /**
     * Given a username, checks if it exists in the database
     * @param username
     * @return isValid
     */
    public boolean usernameValid(String username) {
        return true;
    }

    /**
     * Given a username and password, checks if input password for that 
     * user matches password in database
     * @param username
     * @return isValid
     */
    public boolean passwordValid(String username, String password) {
        return true;
    }

    /**
     * Given a username, check if it exists in the database
     * @param username
     * @return
     */
    public boolean usernameExists(String username) {
        return true;
    }

    /**
     * Given an email, check if it exists in the database
     * @param email
     * @return
     */
    public boolean emailExists(String email) {
        return true;
    }

    /**
     * Returns a unique token
     * @return token
     */
    public String generateToken() {
        return "";
    }

    public static void main(String[] args) throws Exception {
        // Map<String, String> d = Map.of(
        //     "username", "john_doe",
        //     "email", "john.doe@example.com",
        //     "emailVisibility", "true",
        //     "password", "12345678",
        //     "passwordConfirm", "12345678",
        //     "name", "test"
        // );

        // System.out.println(PocketBaseClient.createRecord("users", d));
        System.out.println(userLogin("john_doe", "12345678"));
    }

    // HELPER FUCTIONS

    /**
     * Checks if given username matches any in database
     * @param username
     * @return
     * @throws Exception
     */
    private static boolean isUsernameValid(String username) throws Exception {
        String data = PocketBaseClient.getUserRecord(username);
        
        // verify username 
        JSONObject jsonObject = new JSONObject(data);
        JSONArray items = jsonObject.getJSONArray("items");
        if (items.isEmpty()) {
            return false;
        }

        return true;
    }
}


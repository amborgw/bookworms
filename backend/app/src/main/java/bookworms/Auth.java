package backend.app.src.main.java.bookworms;

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
    public String userLogin(String username, String password) {

        // verify username and password

        // create new user instance and extract info from database

        // generate token and store hashed token in user instance

        return "";
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
     * Returns a unique tokem
     * @return token
     */
    public String generateToken() {
        return "";
    }
}

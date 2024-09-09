package bookworms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Token {
    private static final String TOKEN_SALT = "eg5ry5hj3895hnt9ghj3985ihtugj3igjitohj3eiou5ygtn3eoyhjo5i6hi5e3uht3";
    private String id;
    private String token;

    public Token(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getHashOfToken() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // add salt to token and hash
            String saltedToken = token + TOKEN_SALT;
            byte[] encodedHash = digest.digest(saltedToken.getBytes());

            // convert bytes array to hex string
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        
    }
}

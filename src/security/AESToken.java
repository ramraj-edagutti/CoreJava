package security;

import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import java.util.Base64;

//import org.apache.commons.codec.binary.Base64;

public class AESToken {
    private static final String ALGO = "AES/CBC/PKCS5Padding";
    //private final static byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't','S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };

    public static String encrypt(String Data) throws Exception {
            Key key = generateKey();
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(Data.getBytes());
            byte[] encryptedValue = Base64.getEncoder().encode(encVal);
            String encryptedPass = new String (encryptedValue);
            return encryptedPass;
        }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        //Base64.decodeBase64(encryptedData);
        byte[] decordedValue =  Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private static Key generateKey() throws Exception {
       // Key key = new SecretKeySpec(keyValue, ALGO);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = secureRandom.generateSeed(8);
        KeySpec spec = new PBEKeySpec("demoUser1".toCharArray(), salt, 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey key = new SecretKeySpec(tmp.getEncoded(), "AES");
        return key;
    }
    
    public static void main(String[] args) {
		try {
			System.out.println(encrypt("Ramraj|abcdef"));
			System.out.println(decrypt(encrypt("Ramraj|abcdef")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
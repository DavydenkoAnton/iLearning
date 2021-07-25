import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Cryptographer {

    public Cryptographer() {
    }

    public String key128() {
        SecureRandom random = null;
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] values = new byte[16]; // 128 bit
        random.nextBytes(values);
        StringBuilder sb = new StringBuilder();
        for (byte b : values) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString().toUpperCase();
    }

    public static String HASH(String msg, String key) {
        Mac sha256_HMAC = null;
        try {
            sha256_HMAC = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            sha256_HMAC.init(new SecretKeySpec(key.getBytes(), "HmacSHA256"));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        byte[] result = sha256_HMAC.doFinal(msg.getBytes());
        return DatatypeConverter.printHexBinary(result);
    }
}

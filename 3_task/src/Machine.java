import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Machine {

    Cryptographer cryptographer;
    private String key;
    private int choice;
    private String HMAC;

    public Machine() {
        cryptographer = new Cryptographer();
    }

    public void generateKey128() {
        key = cryptographer.key128();
    }

    public void randomChoice(String[] args) {
        SecureRandom random = null;
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (
                NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        choice = random.nextInt(args.length);
    }

    public void generateHMAC(String[] args) {
        HMAC=Cryptographer.HASH(args[choice], key);
    }

    public String getKey() {
        return key;
    }

    public int getChoice() {
        return choice;
    }

    public String getHMAC() {
        return HMAC;
    }
}

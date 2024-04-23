import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class SymmetricCrypto {
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int AES_KEY_SIZE = 256;  // AES-256
    private static final int GCM_NONCE_LENGTH = 12;  // 96 bits
    private static final int GCM_TAG_LENGTH = 128;  // bits

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(AES_KEY_SIZE);
        return keyGenerator.generateKey();
    }

    public static String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecureRandom random = new SecureRandom();
        byte[] nonce = new byte[GCM_NONCE_LENGTH];
        random.nextBytes(nonce);

        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, nonce);
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);

        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        byte[] cipherTextWithNonce = new byte[nonce.length + cipherText.length];
        System.arraycopy(nonce, 0, cipherTextWithNonce, 0, nonce.length);
        System.arraycopy(cipherText, 0, cipherTextWithNonce, nonce.length, cipherText.length);

        return Base64.getEncoder().encodeToString(cipherTextWithNonce);
    }

    public static String decrypt(String cipherText, SecretKey key) throws Exception {
        byte[] cipherTextWithNonce = Base64.getDecoder().decode(cipherText);
        byte[] nonce = new byte[GCM_NONCE_LENGTH];
        byte[] cipherTextOnly = new byte[cipherTextWithNonce.length - GCM_NONCE_LENGTH];

        System.arraycopy(cipherTextWithNonce, 0, nonce, 0, nonce.length);
        System.arraycopy(cipherTextWithNonce, nonce.length, cipherTextOnly, 0, cipherTextOnly.length);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, nonce);
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] plainText = cipher.doFinal(cipherTextOnly);

        return new String(plainText);
    }
}

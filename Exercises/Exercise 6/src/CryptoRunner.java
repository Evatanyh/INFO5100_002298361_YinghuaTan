import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;

public class CryptoRunner {

    public static void main(String[] args) {
        try {
            // Symmetric Encryption/Decryption
            SecretKey aesKey = SymmetricCrypto.generateKey();
            String secretMessage = "Hello, Bob!";
            String encryptedMessage = SymmetricCrypto.encrypt(secretMessage, aesKey);
            String decryptedMessage = SymmetricCrypto.decrypt(encryptedMessage, aesKey);

            System.out.println("Encrypted (AES): " + encryptedMessage);
            System.out.println("Decrypted (AES): " + decryptedMessage);

            // Asymmetric Encryption/Decryption
            KeyPair keyPair = AsymmetricCrypto.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            String asymmetricEncrypted = AsymmetricCrypto.encrypt(secretMessage, publicKey);
            String asymmetricDecrypted = AsymmetricCrypto.decrypt(asymmetricEncrypted, privateKey);

            System.out.println("Encrypted (RSA): " + asymmetricEncrypted);
            System.out.println("Decrypted (RSA): " + asymmetricDecrypted);

            // Signing and Verification
            byte[] signature = DigitalSignature.sign(secretMessage, privateKey);
            boolean isSignatureValid = DigitalSignature.verify(secretMessage, signature, publicKey);

            System.out.println("Signature Valid: " + isSignatureValid);

        } catch (Exception e) {
            System.err.println("Error during cryptographic operations: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

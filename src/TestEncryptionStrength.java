import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;


public class TestEncryptionStrength {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(restrictedCryptography());

  }

  public static boolean restrictedCryptography() {
    try {
      return Cipher.getMaxAllowedKeyLength("AES/CBC/PKCS5Padding") < Integer.MAX_VALUE;
    } catch (final NoSuchAlgorithmException e) {
      throw new IllegalStateException(
          "The transform \"AES/CBC/PKCS5Padding\" is not available (the availability of this algorithm is mandatory for Java SE implementations)",
          e);
    }
  }

}

package javacodechecker;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
public class MissingRequiredCryptographicStep {
  public void notValid() throws Throwable
                {
       
            final String CIPHER_INPUT = "ABCDEFG123456";
            KeyGenerator kG = KeyGenerator.getInstance("AES");
            SecretKey secretKey = kG.generateKey();
            byte[] byteKey = secretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(byteKey, "AES");
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = aesCipher.doFinal(CIPHER_INPUT.getBytes("UTF-8"));
	  IO.writeLine(IO.toHex(encrypted));
                 }
         private void inValid() throws Throwable
	        {
	        
	            final String CIPHER_INPUT = "ABCDEFG123456";
	            KeyGenerator kGVal = KeyGenerator.getInstance("AES");
	            kGVal.equals(kGVal);
	            SecretKey secretKey = kGVal.generateKey();
	            byte[] byteKey = secretKey.getEncoded();
	            SecretKeySpec secretKeySpec = new SecretKeySpec(byteKey, "AES");
	            Cipher aesCipher = Cipher.getInstance("AES");
	            aesCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
	            byte[] encrypted = aesCipher.doFinal(CIPHER_INPUT.getBytes("UTF-8"));
		 IO.writeLine(IO.toHex(encrypted));
	        }
}

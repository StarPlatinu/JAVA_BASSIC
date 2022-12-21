package fa.training.util;
import org.apache.commons.codec.binary.Base64;
public class Validation {
	
	   public String encodedPassword(String password) {
		   String encodedString = new String(Base64.encodeBase64(password.getBytes()));
		return encodedString;  
	   }
	   
	   public String decodePassword(String password) {
		   String decodedString = new String(Base64.decodeBase64(password.getBytes()));
		   return decodedString;
	   }
	   public static void main(String[] args) {
		String decode = "dGhhbmh2dTEyMw==";
		
	}
	
}

package squad.servlet;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class CryptoUtil {
	public static String encode(String value) throws UnsupportedEncodingException {
		Base64.Encoder e = Base64.getEncoder();
		return e.encodeToString(value.getBytes("utf-8"));
	}
	
	public static String decode(String encrypted) throws UnsupportedEncodingException{
		byte[] b = Base64.getDecoder().decode(encrypted);
		return new String(b,"utf-8");
	}
	
	/*
	 * public static void main(String[] args) throws UnsupportedEncodingException {
	 * System.out.println(encode("team6")); }
	 */
	
	/*
	 * public static void main(String[] args) throws UnsupportedEncodingException {
	 * System.out.println(decode("dGVhbTY=")); }
	 */

}

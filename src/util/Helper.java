package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Helper {

	public static byte[] sha256(String plaintext) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			return digest.digest(plaintext.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
			return null;
		}
	}

	public static String bcrypt(String plaintext) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(plaintext);
	}

	public static long randomLong() {
		Random rand = new Random();
		return Math.abs(rand.nextLong());
	}

	public static String randomString(int n) {
		final String pattern = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		final Random rnd = new Random();
		int len = pattern.length();
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			sb.append(pattern.charAt(rnd.nextInt(len)));
		}
		return sb.toString();
	}

}

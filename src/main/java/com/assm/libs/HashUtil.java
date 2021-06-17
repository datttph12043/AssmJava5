package com.assm.libs;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtil {
	public static String hash(String plain) {
		return BCrypt.hashpw(plain, BCrypt.gensalt());
	}

	public static boolean verify(String plain, String hashed) {
		return BCrypt.checkpw(plain, hashed);
	}
}
//mã hóa mk

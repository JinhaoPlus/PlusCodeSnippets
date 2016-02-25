//AES128加密解密+Base64信息可视化

public static String encrypt(String plainText) {
		try {
			// 双方协定的加密密钥字符串
			byte[] key = new String("testtesttesttest").getBytes("utf-8");
			// 初始化密码器
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			// 初始化密钥
			SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			// 密码器注入密码
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			// 执行AES加密
			byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
			// 执行Base64加密处理
			String encryptedString = new String(Base64.encodeBase64(cipherText));
			return encryptedString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String encryptedText) {
		try {
			// 双方协定的加密密钥字符串
			byte[] key = new String("testtesttesttest").getBytes("utf-8");
			// 初始化密码器
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			// 初始化密钥
			SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
			// 密码器注入密码
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			// 执行Base64解密处理
			byte[] cipherText = Base64.decodeBase64(encryptedText
					.getBytes("utf-8"));
			// 执行AES解密
			String decryptedString = new String(cipher.doFinal(cipherText),
					"UTF-8");
			return decryptedString;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
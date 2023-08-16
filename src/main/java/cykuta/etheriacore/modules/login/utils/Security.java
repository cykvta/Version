package cykuta.etheriacore.modules.login.utils;

import cykuta.etheriacore.files.config.Config;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.entity.Player;
import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {

    private static boolean passwordIsSafe(String password) {
        String allowedChars = Config.ALLOWED_CHARS.getString();

        // Check characters in password
        for (char c: password.toCharArray()) {
            if (!allowedChars.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPassword(String password, Player player) {
        if (!passwordIsSafe(password)) {
            Chat.reply(player, Lang.PASSWORD_BAD_CHARACTERS.get());
            return false;
        }

        int max_password_length = Config.MAX_PASSWORD_LENGTH.getInt();
        int min_password_length = Config.MIN_PASSWORD_LENGTH.getInt();

        if (password.length() > max_password_length || password.length() < min_password_length) {
            Chat.reply(player, Lang.PASSWORD_BAD_LENGTH.get()
                    .replace("%min%", String.valueOf(min_password_length))
                    .replace("%max%", String.valueOf(max_password_length)));
            return false;
        }

        return true;
    }

    // Encrypt password with MD5 algorithm
    public static String hashPassword(String password) {
        String salt = Config.PASS_SALT.getString();

        if (salt == null || salt.equals("")) {
            salt = createSalt();
        }

        password = password + salt;
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

        byte[] messageDigest = md.digest(password.getBytes());

        BigInteger no = new BigInteger(1, messageDigest);
        String hashtext = no.toString(16);

        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    private static String createSalt() {
        // Create random String
        String newSalt = "";

        for (int i = 0; i < 10; i++) {
            newSalt += (char) (Math.random() * 26 + 97);
        }

        // Save new salt
        Config.PASS_SALT.set(newSalt);
        Config.reload();
        return newSalt;
    }
}

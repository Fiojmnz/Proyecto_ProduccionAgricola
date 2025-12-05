/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validaciones;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

/**
 *
 * @author AsusVivobook
 */
public class EncriptadorContrasena {
     public static String hash(String password) {
        try {
            SecureRandom sr = SecureRandom.getInstanceStrong();
            byte[] salt = new byte[16];
            sr.nextBytes(salt);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));

            String sSalt = Base64.getEncoder().encodeToString(salt);
            String sDigest = Base64.getEncoder().encodeToString(digest);
            return sSalt + ":" + sDigest;
        } catch (Exception e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }

    public static boolean verifica (String password, String stored) {
        try {
            if (stored == null || !stored.contains(":")) return false;
            String[] parts = stored.split(":");
            if (parts.length != 2) return false;

            byte[] salt = Base64.getDecoder().decode(parts[0]);
            byte[] expected = Base64.getDecoder().decode(parts[1]);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashed = md.digest(password.getBytes(StandardCharsets.UTF_8));

           
            return MessageDigest.isEqual(hashed, expected);
        } catch (Exception e) {
            return false;
        }
    }
}
    

package com.example.universitytask.utills;

import com.example.universitytask.errors.exceptions.CredentialsException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

public final class CredentialsHelper {

    private CredentialsHelper() {
        throw new AssertionError("Cannot be instantiated");
    }

    //عملت hash لل password
    public  static String hashPassword(final String password)throws CredentialsException {
        Optional.ofNullable(password).orElseThrow(()->new CredentialsException("Invalid password"));
        byte[] hash;
        try {
            final MessageDigest md = MessageDigest.getInstance("SHA-256");
            hash = md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new CredentialsException("SHA-256 is not supported");
        }

        return Base64.getEncoder().encodeToString(hash);

    }

}

package com.example.rest.utills;

import com.example.universitytask.errors.exceptions.CredentialsExceptions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

public class CredentialsHelper {


    //عملت hash لل password
    public static String hashPassword(final String password)throws CredentialsExceptions {
        Optional.ofNullable(password).orElseThrow(()->new CredentialsExceptions("Invalid password"));
        byte[] hash;
        try {
            final MessageDigest md = MessageDigest.getInstance("SHA-256");
            hash = md.digest(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new CredentialsExceptions("SHA-256 is not supported");
        }

        return Base64.getEncoder().encodeToString(hash);

    }

}

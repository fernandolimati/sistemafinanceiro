package com.fatesg.sistemafinanceiro.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {

	/*
	 * Algorithms "MD5", "SHA-1", "SHA-256"
	 */
	
	public static String hashGenerator(String string, String algorith) {
		String hexa = "";
		try {
		    MessageDigest m = MessageDigest.getInstance(algorith);	 
		    m.update( string.getBytes(), 0 , string.length() );		             
		    byte[] digest = m.digest(); 
		    hexa = new BigInteger(1,digest).toString(16);
		             
		} catch (NoSuchAlgorithmException e) {
		    e.printStackTrace();
		}
		return hexa;
	}
}

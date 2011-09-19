package com.projecthl7;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Mdfiveconverter {
        
       public String converter(String password)
       {
    	   String pass = password;
    	   String hashword = null;
    	   MessageDigest md5;
		try{
			md5 = MessageDigest.getInstance("MD5");
		
    	   md5.update(pass.getBytes());
    	   BigInteger hash = new BigInteger(1,md5.digest());
    	   hashword = hash.toString(16);
    	   
          }
         catch(Exception e)
         {
    	   
         }
         
         return hashword;
    }
   }
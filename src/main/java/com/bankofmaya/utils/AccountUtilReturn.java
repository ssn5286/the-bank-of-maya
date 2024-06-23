package com.bankofmaya.utils;

import java.math.BigInteger;
import java.time.Year;

public class AccountUtilReturn {

    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACOUNT_EXISTS_MESSAGE = "This user already has an account created";

    public  static  final String ACCOUNT_CREATION_CODE = "002";
    public static  final String ACCOUNT_CREATION_MESSAGE = "Account has been created";

    public static String createAccountNumber(){
        Year currentYear = Year.now();
        int min = 100000000;
        int max = 999999999;
        int randNumber = (int) Math.floor((Math.random() * (max - min + 1) + min));
        return (String.valueOf(currentYear) + String.valueOf(randNumber));
    }
}

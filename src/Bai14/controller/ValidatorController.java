package Bai14.controller;

import Bai14.exception.BirthdayException;
import Bai14.exception.FullNameException;
import Bai14.exception.PhoneException;

import java.time.LocalDate;

public class ValidatorController {
    public static void birthdayCheck(String birthday) throws BirthdayException{
        if(!birthday.matches("\\d{2}/\\d{2}/\\d{4}")){
            throw new BirthdayException("Invalid date of birth format");
        }
    }
    public static void phoneCheck(String phone) throws PhoneException {
        if (!phone.matches("(090|098|091|031|035|038)\\d{7}")) {
            throw new PhoneException("Invalid phone number");
        }
    }

    public static void nameCheck(String fullName) throws FullNameException{
        if(fullName.length() < 10 || fullName.length() > 50){
            throw new FullNameException("Invalid fullname length");
        }
    }
}

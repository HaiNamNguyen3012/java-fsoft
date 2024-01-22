package Bai13.controller;

import Bai13.exception.BirthdayException;
import Bai13.exception.EmailException;
import Bai13.exception.FullNameException;
import Bai13.exception.PhoneException;

import java.time.LocalDate;

public class ValidatorController {
    public static void birthdayCheck(LocalDate birthday) throws BirthdayException{
        LocalDate currentDate = LocalDate.now();
        if(birthday.isAfter(currentDate) || birthday.isBefore(currentDate)){
            throw new BirthdayException("Ngày sinh nhật không đúng");
        }
    }
    public static void phoneCheck(String phone) throws PhoneException {
        String phonePattern = "\\d{10}";

        if (!phone.matches(phonePattern)) {
            throw new PhoneException("Số điện thoại chưa đúng định dạng.");
        }
    }

    public static void emailCheck(String email) throws EmailException {
        String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

        if (!email.matches(emailPattern)) {
            throw new EmailException("Email chưa đúng định dạng.");
        }
    }

    public static void nameCheck(String name) throws FullNameException {
        String namePattern = "^[A-Za-z]+( [A-Za-z]+)?$";

        if (!name.matches(namePattern)) {
            throw new FullNameException("Tên chưa đúng định dạng.");
        }
    }
}

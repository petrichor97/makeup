package com.tianxuan.makeup.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
            //3到8个汉字
   final static String nameRegex = "^[\\u0391-\\uFFE5]{3,8}";
   final static String phoneRegex ="^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$";
   final static String idCardRegex="^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";
//   匹配6位数字密码
   final static String passwordRegex="^\\d{6}$";

    //   只能输入汉字
   final static String chineseRegex = "^[\\u0391-\\uFFE5]+$";
    //   姓名校验
    public static boolean nameValidator(String name) {
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        boolean isMatches = matcher.matches();
        return isMatches;

    }
    //汉字校验
    public static boolean chineseValidator(String chinese) {
        Pattern pattern = Pattern.compile(chineseRegex);
        Matcher matcher = pattern.matcher(chinese);
        boolean isMatches = matcher.matches();
        return isMatches;

    }

    //    电话校验
    public static boolean phoneValidator(String phone) {

        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone);
        boolean isMatches = matcher.matches();
        return isMatches;
    }

    //    身份证号校验
    public static boolean idCardValidator(String idCard) {
        Pattern pattern = Pattern.compile(idCardRegex);
        Matcher matcher = pattern.matcher(idCard);
        boolean isMatches = matcher.matches();
        return isMatches;
    }

//    密码校验
public static boolean idPasswordValidator(String password) {
    Pattern pattern = Pattern.compile(passwordRegex);
    Matcher matcher = pattern.matcher(password);
    boolean isMatches = matcher.matches();
    return isMatches;
}
}

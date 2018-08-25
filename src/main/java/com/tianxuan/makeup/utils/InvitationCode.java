package com.tianxuan.makeup.utils;


public class InvitationCode {
    public static final String KEY = "tianxuan";

    public static String createInvitationCode(String openid) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(openid.charAt(0)).append(openid.charAt(5)).append(openid.charAt(10)).append(openid.charAt(15)).append(openid.charAt(20)).append(openid.charAt(25));


        String code = RC4Util.encry_RC4_string(String.valueOf(stringBuilder), KEY);

        return code;
    }
}

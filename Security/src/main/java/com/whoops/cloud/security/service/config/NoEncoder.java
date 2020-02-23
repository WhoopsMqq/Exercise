package com.whoops.cloud.security.service.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

public class NoEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        String s2 = charSequence.toString();
        if(StringUtils.equals(s,s2)){
            return true;
        }
        return false;
    }
}

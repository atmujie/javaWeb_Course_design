package com.ProClinic.sevice.po.impl;

import com.ProClinic.sevice.po.EncodeTools;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EncodeToolsImpl implements EncodeTools {
    @Override
    public String md5Encode(String text){
        return DigestUtils.md5DigestAsHex(text.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public String dateDecode(Date date) {
        if (date != null){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        }
        return "";
    }

    @Override
    public String dateDiagonalLineDecode(Date date) {
        if (date != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        }
        return "";
    }
}

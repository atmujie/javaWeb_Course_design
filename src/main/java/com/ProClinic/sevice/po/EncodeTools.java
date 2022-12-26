package com.ProClinic.sevice.po;

import java.util.Date;

public interface EncodeTools {
    // md5加密
    String md5Encode(String text);
    // 时间格式解码
    String dateDecode(Date date);
    // 斜线分割的时间格式解码
    String dateDiagonalLineDecode(Date date);
}

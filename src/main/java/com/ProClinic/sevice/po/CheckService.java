package com.ProClinic.sevice.po;

import java.io.IOException;

public interface CheckService {
    // 传入用户名，判断用户是否存在
    boolean userExists(String username);
    // 检查字符串是否为空
    boolean strIsNull(String str);
    // 检查字符串是否不为空
    boolean strNotIsNull(String str);
}

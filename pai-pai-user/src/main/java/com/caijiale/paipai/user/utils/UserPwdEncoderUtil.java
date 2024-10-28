package com.caijiale.paipai.user.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * @author MAKABAKA
 */
public class UserPwdEncoderUtil {

    /**
     * 生成随机盐
     *
     * @return 盐
     */
    public static String generateSalt() {
        return new String(RandomUtil.randomBytes(16));
    }

    /**
     * 加密
     *
     * @param password 密码
     * @return 加密后的密码
     */
    public static String encode(String password, String salt) {
        return SecureUtil.md5().digestHex(password + salt);
    }

    /**
     * 验证密码
     *
     * @param rawPassword     原密码
     * @param salt            加密盐
     * @param encodedPassword 加密后的密码
     * @return 是否匹配
     */
    public static boolean matches(String rawPassword, String salt, String encodedPassword) {
        return SecureUtil.md5().digestHex(rawPassword + salt).equals(encodedPassword);
    }
}

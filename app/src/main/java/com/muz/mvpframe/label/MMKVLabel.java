package com.muz.mvpframe.label;

/**
 * @author Muz
 * @description MMKV 标签
 * @date 2018/10/25 10:17
 */

public class MMKVLabel {
    public static class loginState {
        /**
         * 登录状态文件名
         */
        public static final String LOGIN_STATE_FILE_NAME_LABEL = "loginState";
        /**
         * 登录状态信息密钥
         */
        public static final String LOGIN_STATE_FILE_KEY_LABEL = "login_state_data";
    }

    public static class loginUser {
        /**
         * 用户登录信息文件名
         */
        public static final String LOGIN_USER_FILE_NAME_LABEL = "login_user_data";
        /**
         * 用户登录信息密钥
         */
        public static final String LOGIN_USER_FILE_KEY_LABEL = "login_user_data";
        /**
         * 登录手机号
         */
        public static final String LOGIN_USER_MOBILE_LABEL = "mobile";
    }
}

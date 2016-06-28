package com.company.util;

import com.company.model.UserEntity;

/**
 * Created by Administrator on 2016/6/23.
 */
public class Util {
    public static String toJsonString(UserEntity user) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"id\":");
        sb.append("\"" + user.getId() + "\"");
        sb.append(",\"username\":");
        sb.append("\"" + user.getUsername() + "\"");
        sb.append(",\"password\":");
        sb.append("\"" + user.getPassword() + "\"");
        sb.append(",\"hometown\":");
        sb.append("\"" + user.getHometown() + "\"");
        sb.append(",\"gender\":");
        sb.append("\"" + user.getGender() + "\"");
        sb.append(",\"birthday\":");
        sb.append("\"" + user.getBirthday() + "\"");
        sb.append(",\"inarmydate\":");
        sb.append("\"" + user.getInarmydate() + "\"");
        sb.append(",\"outarmydate\":");
        sb.append("\"" + user.getOutarmydate() + "\"");
        sb.append(",\"department\":");
        sb.append("\"" + user.getDepartment() + "\"");
        sb.append("}");
        return sb.toString();
    }
}

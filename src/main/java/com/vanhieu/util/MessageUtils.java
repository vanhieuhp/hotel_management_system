package com.vanhieu.util;

import java.util.HashMap;
import java.util.Map;

public class MessageUtils {

    public static Map<String, String> getMessage(String message) {
        Map<String, String> map = new HashMap<>();
        if (message.equals("update_success")) {
            map.put("message", "Update successful!");
            map.put("alert", "success");
        } else if (message.equals("insert_success")) {
            map.put("message", "Insert successfully!");
            map.put("alert", "success");
        } else if (message.equals("delete_success")) {
            map.put("message", "Delete successfully!");
            map.put("alert", "success");
        } else if (message.equals("error_system")) {
            map.put("message", "Error system!");
            map.put("alert", "danger");
        }
        return map;
    }
}

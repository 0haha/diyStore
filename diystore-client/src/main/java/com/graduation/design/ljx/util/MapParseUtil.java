package com.graduation.design.ljx.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hehe on 18-5-7.
 */
public class MapParseUtil {

    /**
     *
     * @param mapStr should be use as the format {key=value,key=value}
     * @return
     */
    public static Map<String,String> parseMapStrToMap(String mapStr) {
      /*  String[] keyVau = mapStr.split("[{,}]");
        if(keyVau.length == 0) return null;
        Map<String,String> map = new HashMap<>();
        for(String tmp :keyVau){
            String[] tmpArr = tmp.split("=");
            if(tmpArr.length != 2) return null;
            map.put(tmpArr[0],tmpArr[1]);
        }
        return map;
    */
        Map<String, String> map = new HashMap<>();
        Pattern pattern = Pattern.compile("\\b[^{](\\w|\\W|[\\u4e00-\\u9fa5])+?=(\\w|\\W|[\\u4e00-\\u9fa5])+?,[^}]");
        Matcher matcher = pattern.matcher(mapStr);
        while (matcher.find()) {
            String strTmp = matcher.group();
            String[] arrTmp = strTmp.split("=");
            map.put(arrTmp[0], arrTmp[1]);
        }
        return map;
    }
}

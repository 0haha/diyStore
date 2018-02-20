package com.gradutation.design.ljx.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hehe on 18-2-5.
 */
public class AttributeUtils {

    public static final String ATTRIBUTE_KV_SPLITER = ";";
    public static final String ATTRIBUTE_EL_SPLITER = ":";

    public AttributeUtils(){}

    public static Map<String,String> parseAttributeByStr(String str){
        Map<String,String> attr = new HashMap<String, String>();
        if(StringUtils.isNotBlank(str)){
            String[] elements = str.split(ATTRIBUTE_KV_SPLITER);
            if(elements != null){
                for(String element : elements){
                    String[] kvarr = element.split(ATTRIBUTE_EL_SPLITER);
                    if(kvarr != null && kvarr.length == 2){
                        attr.put(kvarr[0],kvarr[1]);
                    }
                }
            }
        }
        return  attr;
    }

    public static String toAttributeStr(Map<String,String> attr){
        if(attr != null && attr.size() != 0){
            StringBuilder strbuilder = new StringBuilder();
            for(Map.Entry<String,String> entry : attr.entrySet()){
                if(strbuilder.length()>0){
                  strbuilder.append(ATTRIBUTE_KV_SPLITER);
                }
                strbuilder.append(entry.getKey());
                strbuilder.append(ATTRIBUTE_EL_SPLITER);
                strbuilder.append(entry.getValue());
            }
            return strbuilder.toString();
        }
        else{
            return null;
        }
    }

}

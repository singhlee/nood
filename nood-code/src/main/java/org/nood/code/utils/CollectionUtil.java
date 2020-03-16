package org.nood.code.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @program: nood
 * @description: 集合工具类
 * @author: singhlee
 * @create: 2020-03-12 09:57
 **/
public class CollectionUtil {
    /**
     * @param map 取值的集合
     * @param key 所想取值的集合的key
     * @return 返回key对应的value
     */
    public static String getMapValue(Map<String,Object> map, String key){
        String result = null;
        if(map != null){
            Iterator<String> iterable = map.keySet().iterator();
            while (iterable.hasNext()){
                Object object = iterable.next();
                if(key.equals(object)) {
                    if (map.get(object) != null) {
                        result = map.get(object).toString();
                    }
                }
            }
        }
        return result;
    }

}

package com.coalition.until;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:abc
 * @Description:
 * @params:$params$
 * @return: $returns$
 * @Date: $date$ $time$
 */
public class BeanUtils extends org.springframework.beans.BeanUtils  {
    /**
     * Tern N Object[] into LIst<bean>，number and order are exactly the same as Object[]
     * @param sourceList
     * @param clazz Bean class
     * @return
     * @throws Exception
     */
    public static <T> List<T> ObjectArrListToBeanList(Class<T> clazz, Object[]...sourceList) throws Exception {
        List<T> list = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();

        for (Object[] objs : sourceList) {
            if (fields.length != objs.length) {
                throw new RuntimeException("Fields in bean and Object[] collection un-match!");
            }
            T bean = clazz.newInstance();
            for(int i=0; i<fields.length; i++) {
                fields[i].setAccessible(true);
                fields[i].set(bean, objs[i]);
            }
            list.add(bean);
        }
        return list;
    }

    /**
     * Convert Object[] into Bean
     * @param clazz
     * @param source
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T ObjtctToBean(Class<T> clazz, Object[] source) throws Exception {
        List<T> ts = ObjectArrListToBeanList(clazz, source);
        if (ts != null && ts.size() > 0) {
            return ts.get(0);
        }
        return null;
    }
}

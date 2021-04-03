package cn.com.pism.gfd.util;

import com.alibaba.fastjson.JSON;

/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/03 下午 02:25
 * @since 0.0.1
 */
public class ObjectToBeanUtil {

    /**
     * <p>
     * 将object 转换为实体
     * </p>
     *
     * @param o     : 待转换对象
     * @param clazz ：clazz
     * @return {@link T} 转换后的对象
     * @author PerccyKing
     * @date 2021/04/03 下午 02:25
     */
    public static <T> T parse(Object o, Class<T> clazz) {
        String s = JSON.toJSONString(o);
        return JSON.parseObject(s, clazz);
    }
}

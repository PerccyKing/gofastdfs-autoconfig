package cn.com.pism.gfd.util.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Locale;

/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/03 下午 03:03
 * @since 0.0.1
 */
public class StringToLowerSerializer implements ObjectSerializer {
    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;
        if (object == null) {
            out.writeNull();
            return;
        }
        out.writeString(object.toString().toLowerCase(Locale.ROOT));
    }
}

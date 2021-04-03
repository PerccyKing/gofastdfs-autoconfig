package cn.com.pism.gfd.model.params;

import cn.com.pism.gfd.enums.ActionEnum;
import cn.com.pism.gfd.model.config.GoFastDfsConfig;
import cn.com.pism.gfd.util.serializer.StringToLowerSerializer;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/03 下午 02:27
 * @since 0.0.1
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Reload {

    /**
     * 参数
     */
    @JSONField(name = "action", serializeUsing = StringToLowerSerializer.class)
    private ActionEnum action;
    /**
     * json参数
     */
    @JSONField(name = "cfg")
    private GoFastDfsConfig cfg;
}

package cn.com.pism.gfd.model.params;

import cn.com.pism.gfd.enums.OutputEnum;
import cn.com.pism.gfd.util.serializer.StringToLowerSerializer;
import cn.hutool.core.io.resource.InputStreamResource;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 文件上传参数
 *
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/04 下午 04:43
 * @since 0.0.1
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Upload {

    /**
     * 文件流 会将
     */
    @JSONField(name = "file")
    private InputStreamResource file;

    /**
     * 场景
     */
    @JSONField(name = "scene")
    private String scene;

    /**
     * 文件名
     */
    @JSONField(name = "filename")
    private String filename;

    /**
     * 输出
     */
    @JSONField(name = "output", serializeUsing = StringToLowerSerializer.class)
    private OutputEnum output;

    /**
     * 自定义路径
     */
    @JSONField(name = "path")
    private String path;

    /**
     * google认证码
     */
    @JSONField(name = "code")
    private String code;

    /**
     * 自定义认证
     */
    @JSONField(name = "auth_token")
    private String authToken;
}

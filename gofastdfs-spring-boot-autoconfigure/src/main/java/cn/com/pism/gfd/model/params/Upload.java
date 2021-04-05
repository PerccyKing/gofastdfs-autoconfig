package cn.com.pism.gfd.model.params;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.File;

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
    private File file;

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

    /**
     * 文件秒传
     */
    @JSONField(name = "md5")
    private String md5;
}

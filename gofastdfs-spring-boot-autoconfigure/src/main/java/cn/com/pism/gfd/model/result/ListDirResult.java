
package cn.com.pism.gfd.model.result;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/05 下午 05:05
 * @since 0.0.1
 */
@Data
public class ListDirResult {

    @JSONField(name = "is_dir")
    private Boolean isDir;
    private String md5;
    private Long mtime;
    private String name;
    private String path;
    private Long size;

}

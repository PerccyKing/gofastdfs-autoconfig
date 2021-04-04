
package cn.com.pism.gfd.model.result;

import lombok.Data;

/**
 * 文件上传响应对象
 *
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/04 下午 04:21
 * @since 0.0.1
 */
@Data
public class UploadResult {
    private String domain;
    private String md5;
    private Long mtime;
    private String path;
    private Long retcode;
    private String retmsg;
    private String scene;
    private String scenes;
    private Long size;
    private String src;
    private String url;
}

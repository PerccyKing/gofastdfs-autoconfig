
package cn.com.pism.gfd.model.result;


import lombok.Data;

import java.util.List;
/**
 * 文件信息
 *
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/05 下午 04:58
 * @since 0.0.1
 */
@Data
public class GetFileInfoResult {

    private String md5;
    private String name;
    private Long offset;
    private String path;
    private List<String> peers;
    private String rename;
    private String scene;
    private Long size;
    private Long timeStamp;
}

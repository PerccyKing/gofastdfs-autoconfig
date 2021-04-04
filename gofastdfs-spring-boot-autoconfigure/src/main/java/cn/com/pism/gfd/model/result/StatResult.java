package cn.com.pism.gfd.model.result;

import lombok.Data;

/**
 * 文件统计信息 响应对象
 *
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/04 下午 04:21
 * @since 0.0.1
 */
@Data
public class StatResult {
    private String date;
    private Long fileCount;
    private Long totalSize;
}

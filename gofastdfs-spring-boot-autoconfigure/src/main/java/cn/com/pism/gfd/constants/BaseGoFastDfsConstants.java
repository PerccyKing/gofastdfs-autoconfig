package cn.com.pism.gfd.constants;

/**
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/03 下午 10:08
 * @since 0.0.1
 */
public abstract class BaseGoFastDfsConstants {

    private BaseGoFastDfsConstants() {
    }

    /**
     * 配置管理API
     */
    public static final String RELOAD_URL = "reload";

    /**
     * 文件统计信息
     */
    public static final String STAT_URL = "stat";

    /**
     * 文件上传
     */
    public static final String UPLOAD_URL = "upload";

    /**
     * 文件删除
     */
    public static final String DELETE_URL = "delete";

    /**
     * 文件信息
     */
    public static final String GET_FILE_INFO_URL = "get_file_info";

    /**
     * 文件列表
     */
    public static final String LIST_DIR_URL = "list_dir";

    /**
     * 修复统计信息
     */
    public static final String REPAIR_STAT_URL = "repair_stat";

    /**
     * 同步失败修复
     */
    public static final String REPAIR_URL = "repair";

    /**
     * 从文件目录中修复元数据（性能较差）
     */
    public static final String REPAIR_FILE_INFO_URL = "repair_fileinfo";

    public static final String SLASH = "/";

    public static final String HTTP = "http://";

    public static final String COLON = ":";

    public static final String OK = "ok";
}

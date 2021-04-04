package cn.com.pism.gfd.enums;

/**
 * 数据
 *
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/04/04 下午 04:48
 * @since 0.0.1
 */
public enum OutputEnum {
    /**
     * json
     * <pre>
     * {
     *     "url": "http://127.0.0.1:8080/group1/default/20210404/16/50/3/start_with_pages.html?name=start_with_pages.html&download=1",
     *     "md5": "32bb2e011b6065fc3facf28ca6f4abec",
     *     "path": "/group1/default/20210404/16/50/3/start_with_pages.html",
     *     "domain": "http://127.0.0.1:8080",
     *     "scene": "default",
     *     "size": 178,
     *     "mtime": 1617526210,
     *     "scenes": "default",
     *     "retmsg": "",
     *     "retcode": 0,
     *     "src": "/group1/default/20210404/16/50/3/start_with_pages.html"
     * }
     * </pre>
     */
    JSON,
    /**
     * text
     * <br>
     *     ex:http://127.0.0.1:8080/group1/default/20210404/16/50/3/start_with_pages.html?name=start_with_pages.html&download=1
     */
    TEXT,
    /**
     * json2
     * <pre>
     * {
     *     "message": "",
     *     "status": "ok",
     *     "data": {
     *         "url": "http://127.0.0.1:8080/group1/default/20210404/16/50/3/start_with_pages.html?name=start_with_pages.html&download=1",
     *         "md5": "32bb2e011b6065fc3facf28ca6f4abec",
     *         "path": "/group1/default/20210404/16/50/3/start_with_pages.html",
     *         "domain": "http://127.0.0.1:8080",
     *         "scene": "default",
     *         "size": 178,
     *         "mtime": 1617526230,
     *         "scenes": "default",
     *         "retmsg": "",
     *         "retcode": 0,
     *         "src": "/group1/default/20210404/16/50/3/start_with_pages.html"
     *     }
     * }
     * </pre>
     */
    JSON2
}

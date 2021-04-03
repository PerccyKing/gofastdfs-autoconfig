package cn.com.pism.gfd.model.config;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <pre>
 * {
 *   "addr": "",
 *   "peers": null,
 *   "enable_https": false,
 *   "group": "",
 *   "rename_file": false,
 *   "show_dir": false,
 *   "extensions": null,
 *   "refresh_interval": 0,
 *   "enable_web_upload": false,
 *   "download_domain": "",
 *   "enable_custom_path": false,
 *   "scenes": null,
 *   "alarm_receivers": null,
 *   "default_scene": "app",
 *   "mail": {
 *     "user": "",
 *     "password": "",
 *     "host": ""
 *   },
 *   "alarm_url": "",
 *   "download_use_token": false,
 *   "download_token_expire": 0,
 *   "queue_size": 0,
 *   "auto_repair": false,
 *   "host": "",
 *   "file_sum_arithmetic": "",
 *   "peer_id": "",
 *   "support_group_manage": false,
 *   "admin_ips": null,
 *   "enable_merge_small_file": false,
 *   "enable_migrate": false,
 *   "enable_distinct_file": false,
 *   "read_only": false,
 *   "enable_cross_origin": false,
 *   "enable_google_auth": false,
 *   "auth_url": "",
 *   "enable_download_auth": false,
 *   "default_download": false,
 *   "enable_tus": false,
 *   "sync_timeout": 0,
 *   "enable_fsnotify": false,
 *   "enable_disk_cache": false,
 *   "connect_timeout": false,
 *   "read_timeout": 0,
 *   "write_timeout": 0,
 *   "idle_timeout": 0,
 *   "read_header_timeout": 0,
 *   "sync_worker": 0,
 *   "upload_worker": 0,
 *   "upload_queue_size": 0,
 *   "retry_count": 0,
 *   "sync_delay": 0,
 *   "watch_chan_size": 0
 * }
 * </pre>
 *
 * @author PerccyKing
 * @version 0.0.1
 * @date 2021/03/28 下午 07:41
 * @since 0.0.1
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoFastDfsConfig {
    /**
     * 端口
     */
    private String addr;
    /**
     * "是否开启https":
     * "默认不开启，如需启开启，
     * 请在conf目录中增加证书文件 server.crt 私钥 文件 server.key",
     */
    @JSONField(name = "enable_https")
    private Boolean enableHttps;

    /**
     * "PeerID":
     * "集群内唯一,请使用0-9的单字符，默认自动生成"
     */
    @JSONField(name = "peer_id")
    private String peerId;

    /**
     * "本主机地址":
     * "本机http地址,默认自动生成(注意端口必须与addr中的端口一致），
     * 必段为内网，自动生成不为内网请自行修改，下同",
     */
    @JSONField(name = "host")
    private String host;

    /**
     * "集群":
     * "集群列表,注意为了高可用，
     * IP必须不能是同一个,同一不会自动备份，
     * 且不能为127.0.0.1,且必须为内网IP，默认自动生成",
     */
    @JSONField(name = "peers")
    private List<String> peers;

    /**
     * "组号":
     * "用于区别不同的集群(上传或下载)
     * 与support_group_manage配合使用,
     * 带在下载路径中",
     */
    @JSONField(name = "group")
    private String group;

    /**
     * "是否支持按组（集群）管理,
     * 主要用途是Nginx支持多集群":
     * "默认支持,不支持时路径为http://10.1.5.4:8080/action,
     * 支持时为http://10.1.5.4:8080/group(配置中的group参数)/action,
     * action为动作名，如status,delete,sync等",
     */
    @JSONField(name = "support_group_manage")
    private Boolean supportGroupManage;

    /**
     * "是否合并小文件":
     * "默认不合并,
     * 合并可以解决inode不够用的情况（当前对于小于1M文件）进行合并",
     */
    @JSONField(name = "enable_merge_small_file")
    private Boolean enableMergeSmallFile;

    /**
     * "允许后缀名":
     * "允许可以上传的文件后缀名，
     * 如jpg,jpeg,png等。留空允许所有。"
     */
    @JSONField(name = "extensions")
    private List<String> extensions;

    /**
     * "重试同步失败文件的时间": "单位秒",
     */
    @JSONField(name = "refresh_interval")
    private Long refreshInterval;

    /**
     * "是否自动重命名": "默认不自动重命名,使用原文件名"
     */
    @JSONField(name = "rename_file")
    private Boolean renameFile;

    /**
     * "是否支持web上传,方便调试": "默认支持web上传",
     */
    @JSONField(name = "enable_web_upload")
    private Boolean enableWebUpload;

    /**
     * "是否支持非日期路径": "默认支持非日期路径,也即支持自定义路径,需要上传文件时指定path",
     */
    @JSONField(name = "enable_custom_path")
    private Boolean enableCustomPath;

    /**
     * "下载域名": "用于外网下载文件的域名,不包含http://",
     */
    @JSONField(name = "download_domain")
    private Long downloadDomain;

    /**
     * "场景列表":
     * "当设定后，用户指的场景必项在列表中，默认不做限制
     * (注意：如果想开启场景认功能，格式如下：'
     * 场景名:googleauth_secret' 如 default:N7IET373HB2C5M6D "
     */
    @JSONField(name = "scenes")
    private List<String> scenes;

    /**
     * "默认场景": "默认default",
     */
    @JSONField(name = "default_scene")
    private String defaultScene;

    /**
     * "是否显示目录": "默认显示,方便调试用,上线时请关闭",
     */
    @JSONField(name = "show_dir")
    private Boolean showDir;

    /**
     * "邮件配置": "",
     * "mail": {
     * "user": "abc@163.com",
     * "password": "abc",
     * "host": "smtp.163.com:25"
     * },
     * ,
     */
    private Mail mail;

    /**
     * "告警接收邮件列表": "接收人数组"
     */
    @JSONField(name = "alarm_receivers")
    private List<String> alarmReceivers;

    /**
     * "告警接收URL": "方法post,参数:subject,message"
     */
    @JSONField(name = "alarm_url")
    private String alarmUrl;

    /**
     * "下载是否需带token": "真假"
     */
    @JSONField(name = "download_use_token")
    private Boolean downloadUseToken;

    /**
     * "下载token过期时间": "单位秒"
     */
    @JSONField(name = "download_token_expire")
    private Long downloadTokenExpire;

    /**
     * "是否自动修复": "在超过1亿文件时出现性能问题，取消此选项，请手动按天同步，请查看FAQ"
     */
    @JSONField(name = "auto_repair")
    private Boolean autoRepair;

    /**
     * "文件去重算法md5可能存在冲突，默认md5": "sha1|md5"
     */
    @JSONField(name = "file_sum_arithmetic")
    private String fileSumArithmetic;

    /**
     * "管理ip列表": "用于管理集的ip白名单,"
     */
    @JSONField(name = "admin_ips")
    private List<String> adminIps;

    /**
     * "是否启用迁移": "默认不启用"
     */
    @JSONField(name = "enable_migrate")
    private Boolean enableMigrate;

    /**
     * "是否开启跨站访问": "默认开启"
     */
    @JSONField(name = "enable_cross_origin")
    private Boolean enableCrossOrigin;

    /**
     * "是否开启Google认证，实现安全的上传、下载": "默认不开启"
     */
    @JSONField(name = "enable_google_auth")
    private Boolean enableGoogleAuth;

    /**
     * "认证url": "当url不为空时生效,
     * 注意:普通上传中使用http参数 auth_token 作为认证参数,
     * 在断点续传中通过HTTP头Upload-Metadata中的auth_token作为认证参数,
     * 认证流程参考认证架构图",
     */
    @JSONField(name = "auth_url")
    private String authUrl;

    /**
     * "下载是否认证": "默认不认证(注意此选项是在auth_url不为空的情况下生效)"
     */
    @JSONField(name = "enable_download_auth")
    private Boolean enableDownloadAuth;

    /**
     * "默认是否下载": "默认下载"
     */
    @JSONField(name = "default_download")
    private Boolean defaultDownload;

    /**
     * "本机是否只读": "默认可读可写"
     */
    @JSONField(name = "read_only")
    private Boolean readOnly;

    /**
     * "是否开启断点续传": "默认开启"
     */
    @JSONField(name = "enable_tus")
    private Boolean enableTus;

    /**
     * "同步单一文件超时时间（单位秒）": "默认为0,程序自动计算，在特殊情况下，自已设定",
     */
    @JSONField(name = "sync_timeout")
    private Long syncTimeout;


    @JSONField(name = "queue_size")
    private Long queueSize;

    @JSONField(name = "enable_fsnotify")
    private Boolean enableFsnotify;

    @JSONField(name = "enable_disk_cache")
    private Boolean enableDiskCache;

    @JSONField(name = "connect_timeout")
    private Boolean connectTimeout;

    @JSONField(name = "read_timeout")
    private Long readTimeout;

    @JSONField(name = "write_timeout")
    private Long writeTimeout;

    @JSONField(name = "idle_timeout")
    private Long idleTimeout;

    @JSONField(name = "read_header_timeout")
    private Long readHeaderTimeout;

    @JSONField(name = "sync_worker")
    private Long syncWorker;

    @JSONField(name = "upload_worker")
    private Long uploadWorker;

    @JSONField(name = "upload_queue_size")
    private Long uploadQueueSize;

    @JSONField(name = "retry_count")
    private Long retryCount;

    @JSONField(name = "sync_delay")
    private Long syncDelay;

    @JSONField(name = "watch_chan_size")
    private Long watchChanSize;
}

/**
 * @Time: 2024/4/4 9:19
 * @Author: guoxun
 * @File: CmdDTO
 * @Description: 本包是向沙箱发送请求时的数据格式
 * 可见文档：https://github.com/criyle/go-judge/blob/master/README.cn.md
 */

package com.pipi.xoj.sandbox.dto;

import lombok.Data;

@Data
public class CmdDTO {

    private String[] args;      // 程序命令行参数
    private String[] env;       // 程序环境变量

    // 该参数请看文档，不只是简单的字符串
    private String files;       // 指定 标准输入、标准输出和标准错误的文件 (null 是为了 pipe 的使用情况准备的，而且必须被 pipeMapping 的 in / out 指定)
    private Boolean tty;        // 开启 TTY （需要保证标准输出和标准错误为同一文件）同时需要指定 TERM 环境变量 （例如 TERM=xterm）

    // 资源限制
    private Integer cpuLimit;       // CPU时间限制，单位纳秒
    private Integer clockLimit;     // 等待时间限制，单位纳秒 （通常为 cpuLimit 两倍）
    private Integer memoryLimit;    // 内存限制，单位 byte
    private Integer stackLimit;     // 栈内存限制，单位 byte
    private Integer procLimit;      // 线程数量限制
    private Integer cpuRateLimit;   // 仅 Linux，CPU 使用率限制，1000 等于单核 100%
    private String cpuSetLimit;     // 仅 Linux，限制 CPU 使用，使用方式和 cpuset cgroup 相同 （例如，`0` 表示限制仅使用第一个核）
    private Boolean strictMemoryLimit;  // deprecated: 使用 dataSegmentLimit （这个选项依然有效）
    private Boolean dataSegmentLimit;   // 仅linux，开启 rlimit 堆空间限制（如果不使用cgroup默认开启）
    private Boolean addressSpaceLimit;  // 仅linux，开启 rlimit 虚拟内存空间限制（非常严格，在所以申请时触发限制）

    // 该参数请看文档，不只是简单的字符串
    // 在执行程序之前复制进容器的文件列表
    private String copyIn;

    // 在执行程序后从容器文件系统中复制出来的文件列表
    // 在文件名之后加入 '?' 来使文件变为可选，可选文件不存在的情况不会触发 FileError
    private String[] copyOut;
    // 和 copyOut 相同，不过文件不返回内容，而是返回一个对应文件 ID ，内容可以通过 /file/:fileId 接口下载
    private String[] copyOutCached;
    // 指定 copyOut 复制文件大小限制，单位 byte
    private Integer copyOutMax;
}

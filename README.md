# Apache Log4j 2 
Apache log4j2 开源日志组件远程代码执行

> 攻击者通过构造恶意请求，触发服务器log4j 2 日志组件的远程代码执行漏洞。漏洞无需特殊配置，进验证，最新版的补丁可以防护此问题

[官方最新补丁： log4j-2.15.0-rc2](https://github.com/apache/logging-log4j2/releases/tag/log4j-2.15.0-rc2)

## 紧急处置方案
1. 修改配置  log4j2.formatMsgNoLookups=True
2. 修改jvm参数 -Dlog4j2.formatMsgNoLookups=true
3. 通过防火墙自定义规则，限制`jndi` 、`ldap` 等恶意payload
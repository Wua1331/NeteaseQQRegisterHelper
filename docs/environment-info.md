# 环境信息清单

## 已确认

- 手机型号：OnePlus Ace 6（一加 Ace 6）
- Android：16
- ColorOS：16.0.3.502
- Root/模块环境：GhostLock 临时 root 环境，KernelSU 挂载 NyaZygisk + Vector
- NyaZygisk：v2.5-351
- Vector：v2.2-3080
- 目标应用：网易云音乐 Android 9.6.08
- 目标包名：`com.netease.cloudmusic`
- Vector 允许勾选网易云音乐作用域：是

## 待补充

- [ ] Vector 中模块作用域是否已实际勾选并重启/重新启动目标应用
- [ ] QQ 授权返回后出现绑定页时的脱敏日志
- [ ] 模块管理器中是否有加载错误或兼容性警告

## 诊断提醒

当前组合包含 Android 16、ColorOS 16、GhostLock 临时 root、KernelSU、NyaZygisk 和 Vector。仅凭版本号无法确认 Vector 的具体加载 API、模块入口格式或兼容性，因此在加入 Xposed 代码前，应先核对 Vector v2.2-3080 对应的官方模块接口与示例，避免套用不匹配的传统 Xposed 模板。

## 获取日志注意事项

在复现前后记录模块加载与目标应用的相关错误。分享前删除访问令牌、Cookie、手机号、验证码、OpenID、账号 ID 和其他个人信息。不要提交完整登录请求/响应正文。

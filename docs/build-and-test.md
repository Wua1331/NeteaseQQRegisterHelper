# 构建与冒烟测试

## 当前实现

本模块使用 Vector v2.2 对应的现代 libxposed API 102，目标包为 com.netease.cloudmusic。它记录模块初始化、包进程和（若 Hook 安装成功）Activity 类名，不修改 QQ 授权、登录/注册判断、网络响应、手机号验证或账号状态。

## 构建配置

- JDK 17
- Android SDK Platform 35
- Android Gradle Plugin 8.7.3
- Gradle 8.9

GitHub Actions 自动执行 gradle assembleDebug，并检查 APK 包含正确的 META-INF/xposed/java_init.list、module.prop 和 scope.list。成功后生成 artifact NeteaseQQRegisterHelper-debug，保留 14 天。可在手机浏览器打开仓库的 Actions 页面下载 ZIP 并解压出 APK。

## 安装与检查

1. 安装 debug APK。
2. 在 Vector 管理界面启用模块，并确认作用域包含网易云音乐。
3. 按 Vector 提示重启/强行停止后重新启动网易云音乐。
4. 在 Vector 日志或系统日志中搜索 NeteaseQQRegisterHelper。
5. 手动执行一次 QQ 登录流程，比较页面出现前后的 “Activity resumed; class=...” 日志。
6. 如果只出现 “Target package loaded”，先确认框架已启用；如果出现 “Activity resume tracing unavailable”，说明 Activity 诊断 Hook 未能安装，但不应影响主程序。

## 限制与隐私

出现模块日志只证明入口运行，不代表 QQ 注册成功，也不代表服务端手机号验证已通过。本模块不自动跳过或隐藏手机号绑定页面。分享日志前删除手机号、验证码、Cookie、Authorization 标头、访问令牌、QQ/OpenID 和账号标识；不要分享未经脱敏的完整认证日志。

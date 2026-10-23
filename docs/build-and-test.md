# 构建与冒烟测试

## 当前实现

本模块使用 Vector v2.2 对应的现代 libxposed API 102，目标包为 `com.netease.cloudmusic`。它只记录模块初始化和目标包加载日志，不修改注册、QQ 授权、网络响应、手机号验证或账号状态。

## 构建配置

- JDK 17
- Android SDK Platform 35
- Android Gradle Plugin 8.7.3
- Gradle 8.9（或与 AGP 8.7.3 兼容的版本）

在项目根目录执行：

```bash
gradle assembleDebug
```

APK 通常位于 `app/build/outputs/apk/debug/app-debug.apk`。当前仓库未提交 Gradle Wrapper；需要本机安装匹配版本的 Gradle。

## 安装与检查

1. 在 Vector 管理界面启用模块，并确认作用域包含网易云音乐。
2. 安装 debug APK。
3. 强行停止并重新启动网易云音乐。
4. 在 Vector 日志或系统日志中搜索 `NeteaseQQRegisterHelper`。
5. 如果无日志，检查 Vector 模块状态、作用域、框架激活状态和构建是否成功。

## 注意

出现模块加载日志只证明入口运行，不代表 QQ 注册成功，也不代表服务端手机号验证已通过。不要在日志中分享令牌、Cookie、验证码或账号标识。

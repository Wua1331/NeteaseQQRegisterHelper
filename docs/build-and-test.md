# 构建与冒烟测试

## 当前实现

首个代码版本仅在目标包 `com.netease.cloudmusic` 的进程加载时写入一条 Xposed 日志。它不修改注册、QQ 授权、网络响应、手机号验证或账号状态。

## 构建

- JDK 17
- Android SDK Platform 35
- Android Gradle Plugin 8.7.3
- Gradle 8.9 或与 Android Gradle Plugin 兼容的版本

在项目根目录执行：

```bash
gradle assembleDebug
```

生成位置通常为 `app/build/outputs/apk/debug/app-debug.apk`。本仓库目前没有提交 Gradle Wrapper，因此需自行安装匹配版本的 Gradle。

## 安装与检查

1. 先确认 Vector 状态正常，并在其管理界面勾选本模块。
2. 安装 debug APK。
3. 重新启动网易云音乐进程。
4. 在 Vector/Xposed 日志中搜索 `[NeteaseQQRegisterHelper]`。
5. 如果没有日志，先检查模块是否启用、作用域是否正确、Vector 是否正常激活，以及日志是否被过滤。

## 注意

本项目当前只验证模块加载。出现加载日志并不代表 QQ 注册成功，也不代表可以跳过服务端手机号验证。不要在日志中分享令牌、Cookie、验证码或账号标识。

# NeteaseQQRegisterHelper

对网易云音乐 Android **9.6.08** 中 QQ 授权后要求绑定手机号的流程进行客户端兼容性与加载诊断的研究项目，目标环境为一加 Ace 6、Android 16 / ColorOS 16、KernelSU + NyaZygisk + Vector v2.2-3080。

> 当前状态：已建立 Android 工程和现代 libxposed API 102 的诊断入口；尚未在设备上构建或验证 APK。

## 当前功能

- 记录模块入口初始化日志。
- 在 `com.netease.cloudmusic` 包加载时记录目标包与进程名。
- 只用于确认 Vector 是否正确加载模块，不修改认证或注册逻辑。

## 项目边界

本项目不会伪造注册成功、伪造服务端响应、篡改账号状态，也不会仅通过隐藏绑定页面来声称注册成功。隐藏界面不等于服务端创建了有效账号。

## 文档

- [诊断计划](docs/analysis-plan.md)
- [环境信息](docs/environment-info.md)
- [构建与测试](docs/build-and-test.md)

## 构建

参阅 [构建与测试说明](docs/build-and-test.md)。项目当前没有提交 Gradle Wrapper，且 APK 尚未经过实际构建与测试。

## 隐私

分享日志前请删除手机号、验证码、Cookie、Authorization 标头、访问令牌、QQ/OpenID、网易云账号标识和其他个人信息。

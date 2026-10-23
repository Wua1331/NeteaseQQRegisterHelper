# NeteaseQQRegisterHelper

对网易云音乐 Android 9.6.08 中 QQ 授权后进入手机号绑定页面的流程进行客户端诊断。目标环境为一加 Ace 6、Android 16 / ColorOS 16、KernelSU + NyaZygisk + Vector v2.2-3080。

> 当前版本：0.3.0（诊断版）。GitHub Actions 已成功构建过 0.2.0；0.3.0 的新代码仍需等待本次 CI 结果，而且尚未在目标手机上实测。

## 当前功能

- 记录模块初始化、Vector 版本/API 与目标包进程信息。
- 尝试记录网易云音乐 Activity 的类名，帮助定位 QQ 授权返回后显示了哪个页面。
- 仅记录页面组件类名，不读取页面文字、输入框内容、Intent 参数或网络数据。
- 即使 Activity 诊断 Hook 安装失败，也会保留模块和包加载诊断日志。

## 明确边界

这个项目不会隐藏或绕过手机号验证页面，不会修改登录/注册判断，不会伪造服务端响应或账号状态。页面消失不等于服务端完成注册；若服务器强制要求手机号验证，客户端诊断不能让账号自动变为已验证。

## 构建与下载

每次推送都会触发 GitHub Actions。打开仓库的 Actions 页面，选择最新且显示成功的 Android Debug Build 运行记录，在 Artifacts 中下载 NeteaseQQRegisterHelper-debug，解压 ZIP 获得 APK。Artifact 保留 14 天。

## 文档

- 流程诊断计划：docs/analysis-plan.md
- 环境信息：docs/environment-info.md
- 构建与测试：docs/build-and-test.md

## 隐私

分享日志前请删除手机号、验证码、Cookie、Authorization 标头、访问令牌、QQ/OpenID、网易云账号标识和其他个人信息。此模块本身不会主动记录这些值。

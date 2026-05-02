#!/bin/bash
echo "Android快捷回复应用构建脚本"
echo "============================"

echo "1. 安装Android Studio"
echo "2. 导入QuickReplyApp.zip"
echo "3. 等待Android Studio下载依赖"
echo "4. 点击Build -> Build APK"
echo "5. 安装APK到手机"

echo "快速构建命令:"
echo "./gradlew assembleDebug  # 构建调试版APK"
echo "./gradlew assembleRelease  # 构建发布版APK"

echo "APK文件位置:"
echo "app/build/outputs/apk/debug/app-debug.apk"
echo "app/build/outputs/apk/release/app-release.apk"

echo "安装到手机:"
echo "adb install app/build/outputs/apk/debug/app-debug.apk"
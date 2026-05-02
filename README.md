# Android快捷回复应用

基于"优品生物快回复"功能手册开发的Android快捷回复工具应用。

## 🎯 功能特性

### 核心功能
- ✅ **悬浮窗模式** - Android悬浮窗权限和UI
- ✅ **话术管理** - 公司话术/小组话术/私人话术三级分类
- ✅ **数据库存储** - SQLite + Room数据库持久化
- ✅ **搜索功能** - 关键词快速搜索话术
- ✅ **快捷回复** - 一键发送，快捷键绑定
- ✅ **多彩分类** - 颜色标识分类系统

## 📱 如何使用

### 下载项目
```
git clone https://github.com/jiankujidu/QuickReplyAndroid.git
```

### 编译APK
**使用Android Studio**
1. 打开Android Studio
2. 导入QuickReplyAndroid项目
3. Android Studio会自动下载依赖
4. 点击 **Build → Build APK**

**命令行编译**
```bash
cd QuickReplyAndroid
./gradlew assembleDebug
```

APK文件位置：`app/build/outputs/apk/debug/app-debug.apk`

### 安装到手机
```bash
# 连接Android手机
adb install app/build/outputs/apk/debug/app-debug.apk
```

## 📊 项目结构

```
QuickReplyAndroid/
├── app/
│   ├── src/main/java/com/quickreply/app/
│   │   ├── MainActivity.java          # 主界面
│   │   ├── PhraseListActivity.java    # 话术列表界面
│   │   ├── FloatingWindowManager.java # 悬浮窗管理器
│   │   ├── AppDatabase.java           # Room数据库配置
│   │   ├── Phrase.java                # 话术数据模型
│   ├── src/main/res/
│   │   ├── layout/                    # 布局文件
│   │   ├── values/                    # 资源文件
├── build.gradle                       # Gradle配置
├── README.md                         # 说明文档
```

## 🔧 技术架构
- **开发语言**: Java
- **数据库**: Room框架
- **UI**: Android原生UI组件
- **悬浮窗**: Android系统悬浮窗API

## ⚙️ 编译说明

由于gradle依赖下载可能较慢，建议使用Android Studio编译。如果你使用命令行编译：

```bash
# 需要先下载gradle
./gradlew assembleDebug
```

## 📦 下载链接
**项目地址**: https://github.com/jiankujidu/QuickReplyAndroid

**直接下载zip**: [下载zip文件](https://github.com/jiankujidu/QuickReplyAndroid/archive/refs/heads/main.zip)

## 🚀 快速开始

1. **克隆项目**: `git clone https://github.com/jiankujidu/QuickReplyAndroid.git`
2. **导入到Android Studio**
3. **编译APK**
4. **安装到Android手机**

## 🆘 遇到问题

### gradle构建失败
如果gradle构建失败，可以：
1. 使用Android Studio自动下载依赖
2. 修改gradle-wrapper.properties中的gradle版本

### 依赖下载慢
Android SDK依赖下载可能需要10-20分钟，请耐心等待。

## 📞 支持
如果有任何问题，请查看项目文件或联系开发者。
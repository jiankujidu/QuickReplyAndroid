# 快捷回复应用 - Android版本

基于"优品生物快回复"功能手册开发的Android快捷回复应用。

## 功能概述

### 已实现的核心功能
1. **悬浮窗功能** - Android悬浮窗权限和UI界面
2. **话术管理** - 公司话术/小组话术/私人话术三级分类
3. **数据库存储** - Room数据库存储话术数据
4. **搜索功能** - 话术关键字搜索
5. **多彩分类** - 颜色标识分类系统
6. **快捷键绑定** - 话术快捷键设置

### 技术架构
- **语言**: Java
- **数据库**: SQLite + Room框架
- **UI**: Android原生UI组件
- **悬浮窗**: Android悬浮窗权限和窗口管理器

## 项目结构

```
QuickReplyApp/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   ├── com/quickreply/app/
│   │   │   │   │   ├── MainActivity.java          # 主界面
│   │   │   │   │   ├── PhraseListActivity.java     # 话术列表界面
│   │   │   │   │   ├── models/
│   │   │   │   │   │   ├── Phrase.java             # 话术数据模型
│   │   │   │   │   ├── database/
│   │   │   │   │   │   ├── AppDatabase.java        # Room数据库
│   │   │   │   │   ├── dao/
│   │   │   │   │   │   ├── PhraseDao.java          # 话术DAO
│   │   │   │   │   ├── services/
│   │   │   │   │   │   ├── FloatingService.java    # 悬浮窗服务
│   │   │   │   │   ├── utils/
│   │   │   │   │   │   ├── FloatingWindowManager.java # 悬浮窗管理器
│   │   │   │   │   ├── adapters/
│   │   │   │   │   │   ├── PhraseAdapter.java      # 话术列表适配器
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml           # 主界面布局
│   │   │   │   ├── activity_phrase_list.xml    # 话术列表布局
│   │   │   │   ├── floating_view.xml           # 悬浮窗布局
│   │   │   │   ├── phrase_item.xml             # 话术项布局
│   │   │   ├── values/
│   │   │   │   ├── strings.xml                  # 字符串资源
│   │   │   │   ├── colors.xml                  # 颜色资源
│   │   │   │   ├── themes.xml                  # 主题资源
│   │   │   ├── xml/
│   │   │   │   ├── backup_rules.xml            # 备份规则
│   │   │   │   ├── data_extraction_rules.xml    # 数据提取规则
│   ├── AndroidManifest.xml                     # 应用清单
├── build.gradle                                # Gradle配置
├── gradle.properties                           # Gradle属性
├── local.properties                            # 本地配置
├── settings.gradle                            # Gradle设置
├── gradlew                                    # Gradle包装器
├── project_plan.md                            # 项目计划
├── README.md                                  # 说明文档
```

## 编译和运行

### 环境需求
- Android SDK
- Java JDK 17+
- Gradle

### 编译步骤
```bash
# 进入项目目录
cd QuickReplyApp

# 构建项目
./gradlew build

# 打包APK
./gradlew assembleDebug

# 清理构建
./gradlew clean
```

### 安装到Android设备
```bash
# 安装调试版APK
adb install app/build/outputs/apk/debug/app-debug.apk
```

## 使用方法

1. **安装应用** - 安装APK到Android设备
2. **启动悬浮窗** - 点击主界面的"启动悬浮窗"按钮
3. **管理话术** - 在主界面中添加和管理话术
4. **使用悬浮窗** - 点击悬浮图标查看话术列表，点击话术复制到其他应用

## 未来扩展功能

1. **云同步** - 添加API服务器同步功能
2. **快捷键** - 全局快捷键绑定
3. **多媒体支持** - 图片、表情符号、文件支持
4. **权限系统** - 管理员/小组长/普通用户权限管理
5. **智能搜索** - 更强大的搜索算法

## 开发环境

- Android Studio 或 命令行开发
- 需要Android SDK Platform Tools
- 需要Android Build Tools

## 备注

这个项目是基于"优品生物快回复"功能手册开发的Android版本，实现了基本的核心功能。可以根据手册进一步扩展功能。
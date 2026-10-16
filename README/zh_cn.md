# Great Scrollable Tooltips Reforged

[GreatScrollableTooltips](https://github.com/flowerinsnowdh/GreatScrollableTooltips) 的**个人重构版（Reforged）**，由 [NiButCrazy](https://github.com/NiButCrazy) 维护。

> **项目原地址**：<https://github.com/flowerinsnowdh/GreatScrollableTooltips>（作者：[flowerinsnow](https://github.com/flowerinsnowdh)）
> 原项目的全部著作权归原作者所有。

允许滚动物品栏中的物品工具提示（Lore）。

本重构版新增（1.20.1 Forge）：
- 支持在 JEI / EMI 界面中使用方向键滚动物品提示（容器界面与配方界面均可）
- 新增配置「按键反转」：反转上下左右方向键的滚动方向（默认开启）
- 新增配置「关闭鼠标滚轮位移」：避免滚轮与物品列表滚动冲突（默认开启）

# 链接
- **项目原地址**：[GitHub](https://github.com/flowerinsnowdh/GreatScrollableTooltips) · [Modrinth](https://modrinth.com/mod/great-scrollable-tooltips) · [CurseForge](https://www.curseforge.com/minecraft/mc-mods/great-scrollable-tooltips) · [MC百科](https://www.mcmod.cn/class/14734.html)
- **本重构版**：[GitHub](https://github.com/NiButCrazy/GreatScrollableTooltips-Reforged)

# Great 前缀是什么意思？
仅仅是为了与其他已经叫作 Scrollable Tooltips 区分，避免 ModID 冲突。

参考了曾经居住过的国家 “大不列颠”。

# 用法
将 Mod 文件放入 mods 目录中，将鼠标指针对准一个物品，使用绑定的按键（默认为方向键 ↑ ↓ ← →）即可滚动物品工具提示；在 JEI / EMI 界面中同样有效。

本重构版中鼠标滚轮位移**默认关闭**，可在配置中开启（开启后按住 Shift 使用滚轮可水平滚动，且仅对原版物品槽生效）。

按键绑定可在「按键绑定」中修改。

# 配置方法
如果您正在使用 Forge 版本，请进入 Mod 页面，找到 Great Scrollable Tooltips 并点击 “config”。

如果您正在使用 Fabric 版本，请安装 Mod [模组菜单](https://modrinth.com/mod/modmenu)，并在模组菜单页面中找到 Great Scrollable Tooltips 并点击配置图标。

# 依赖 & 不兼容
- [Fabric API](https://modrinth.com/mod/fabric-api) 必须.
- [Mod Menu](https://modrinth.com/mod/modmenu) 建议
- [Optifine](https://optifine.net/) **不兼容**.

* Forge 上没有任何需要的前置，与 [Optifine](https://optifine.net/) 不兼容

# Versions
**由于本人时间与精力有限，如果需要更多支持的版本、需要兼容的 Mod、需要修复的问题，请开 issue 来告诉我，否则更新随缘**

## Fabric
| Mod 版本 |         Minecraft 版本         | [#38](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/38) | [LegendaryTooltips](https://github.com/AHilyard/LegendaryTooltips) | [#72](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/72) | [#75](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/75) | [AppleSkin](https://github.com/squeek502/AppleSkin) |
| :------: | :----------------------------: | :------------------------------------------------------------------------: | :----------------------------------------------------------------: | :------------------------------------------------------------------------: | :------------------------------------------------------------------------: | :-------------------------------------------------: |
|   6.x    |          1.16-1.16.1           |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|   7.x    |         1.16.2-1.16.5          |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|   8.x    |          1.17-1.17.1           |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|   9.x    |          1.18-1.18.2           |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|   9.x    |          1.18-1.18.2           |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|   10.x   |          1.19-1.19.1           |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|   11.x   |             1.19.2             |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|   13.x   |          1.20-1.20.1           |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|   14.x   |  1.20.2-1.20.4,23w40a-24w13a   |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     ✅                                      |                          ❌                          |
|   15.x   | 1.20.5-1.21.1,24w14a-1.21.1rc1 |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     ✅                                      |                          ✅                          |
|   16.x   |         24w33a-1.20.4          |                                     ✅                                      |                                 -                                  |                                     ✅                                      |                                     ✅                                      |                          ✅                          |

## Forge
| Mod 版本 | Minecraft 版本 | [#38](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/38) | [LegendaryTooltips](https://github.com/AHilyard/LegendaryTooltips) | [#72](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/72) | [#75](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/75) | [Apotheosis](https://github.com/Shadows-of-Fire/Apotheosis) | [AppleSkin](https://github.com/squeek502/AppleSkin) | [Obscure Tooltips](https://www.curseforge.com/minecraft/mc-mods/obscure-tooltips) |
| :------: | :------------: | :------------------------------------------------------------------------: | :----------------------------------------------------------------: | :------------------------------------------------------------------------: | :------------------------------------------------------------------------: | :---------------------------------------------------------: | :-------------------------------------------------: | :-------------------------------------------------------------------------------: |
|   1.x    |   1.8.9-1.10   |                                     -                                      |                                 -                                  |                                     ✅                                      |                                     -                                      |                              -                              |                          -                          |                                         -                                         |
|   3.x    |   1.10-1.11    |                                     ❌                                      |                                 -                                  |                                     ❌                                      |                                     ❌                                      |                              ❌                              |                          ❌                          |                                         -                                         |
|   4.x    |     1.12.2     |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     -                                      |                              ❓                              |                          ✅                          |                                         -                                         |
|   8.x    |     1.18.2     |                                     ✅                                      |                                 ❌                                  |                                     ✅                                      |                                     ❌                                      |                              ❌                              |                          ❌                          |                                         ❌                                         |
|   11.x   |     1.19.2     |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     ✅                                      |                              ❌                              |                          ✅                          |                                         -                                         |
|   13.x   |     1.19.4     |                                     ✅                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                              ❌                              |                          ❌                          |                                         ❌                                         |
|   15.x   |     1.20.1     |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     ✅                                      |                              ✅                              |                          ✅                          |                                         ✅                                         |

# 鸣谢
- **项目原地址**：[GreatScrollableTooltips](https://github.com/flowerinsnowdh/GreatScrollableTooltips)（作者：[flowerinsnow](https://github.com/flowerinsnowdh)）——原项目的全部著作权归原作者所有。
- **本重构版**：由 [NiButCrazy](https://github.com/NiButCrazy) 维护。

以下致谢内容来自原项目：

[<img src="README/CREDITS/jetbrains.png" alt="jetbrains.png"/>](https://www.jetbrains.com)

本项目的开发得到了 [JetBrains](https://www.jetbrains.com/) 的支持，他们慷慨地为开源项目提供了免费的 IDE 许可证。他们的工具大大提高了我的工作效率和开发体验。

我衷心感谢 [JetBrains](https://www.jetbrains.com/) [对开源软件的支持](https://www.jetbrains.com/community/opensource/)。如果您正在寻找功能强大的开发工具，推荐您查看 [JetBrains 的产品](https://www.jetbrains.com/products/)。
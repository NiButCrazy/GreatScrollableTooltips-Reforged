# Languages
[简体中文](README/zh_cn.md)

# GreatScrollableTooltips Reforged

A **Reforged** version of [GreatScrollableTooltips](https://github.com/flowerinsnowdh/GreatScrollableTooltips), maintained by [NiButCrazy](https://github.com/NiButCrazy).

> **Original project**: <https://github.com/flowerinsnowdh/GreatScrollableTooltips> (by [flowerinsnow](https://github.com/flowerinsnowdh))
> All credits for the original work belong to the original author.

Allow scrolling of item tooltips in inventory (Lore).

What's new in this Reforged version (1.20.1 Forge):
- Arrow keys can scroll tooltips in JEI / EMI screens (both container screens and recipe screens).
- New config: **Invert keys** (up/down/left/right), enabled by default.
- New config: **Disable mouse wheel scrolling**, enabled by default to avoid conflicts with list scrolling.

# Links
- **Original project**: [GitHub](https://github.com/flowerinsnowdh/GreatScrollableTooltips) · [Modrinth](https://modrinth.com/mod/great-scrollable-tooltips) · [CurseForge](https://www.curseforge.com/minecraft/mc-mods/great-scrollable-tooltips) · [MC百科](https://www.mcmod.cn/class/14734.html)
- **This Reforged version**: [GitHub](https://github.com/NiButCrazy/GreatScrollableTooltips-Reforged)

# What does the Great prefix mean?
Just to distinguish it from other already called Scrollable Tooltips to avoid ModID conflicts.

Reference to the country where I once lived, "Great Britain".

# Usage
Put the mod file into the mods directory, point the mouse pointer at an item, and scroll the item tooltip with the bound keys (arrow keys ↑ ↓ ← → by default). This also works in JEI / EMI screens.

In this Reforged version, mouse wheel scrolling is **disabled by default**; it can be enabled in the config (when enabled, hold Shift with the mouse wheel to scroll horizontally, and it only applies to vanilla item slots).

Key bindings can be changed in "Key Bindings".

# How to configure
If you are using the Forge version, go to the Mod page, find Great Scrollable Tooltips and click "config".

If you are using the Fabric version, please install Mod [Mod Menu](https://modrinth.com/mod/modmenu), find Great Scrollable Tooltips in the Mod Menu page and click the configure icon.

# Dependencies & Breaks
- [Fabric API](https://modrinth.com/mod/fabric-api) is required.
- [Mod Menu](https://modrinth.com/mod/modmenu) is suggested
- [Optifine](https://optifine.net/) is **INCOMPATIBLE**.

* No dependencies required on forge. [Optifine](https://optifine.net/) is INCOMPATIBLE.

# Versions
**Due to my limited time and energy, if you need more supported versions, compatible to mods, or problems that need to be fixed, please let me know by opening issues. Otherwise, I will update as I wish.**

## Fabric
| Mod version |       Minecraft versions       | [#38](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/38) | [LegendaryTooltips](https://github.com/AHilyard/LegendaryTooltips) | [#72](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/72) | [#75](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/75) | [AppleSkin](https://github.com/squeek502/AppleSkin) |
| :---------: | :----------------------------: | :------------------------------------------------------------------------: | :----------------------------------------------------------------: | :------------------------------------------------------------------------: | :------------------------------------------------------------------------: | :-------------------------------------------------: |
|     6.x     |          1.16-1.16.1           |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|     7.x     |         1.16.2-1.16.5          |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|     8.x     |          1.17-1.17.1           |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     ✅                                      |                          ✅                          |
|     9.x     |          1.18-1.18.2           |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|     9.x     |          1.18-1.18.2           |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|    10.x     |          1.19-1.19.1           |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|    11.x     |             1.19.2             |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     ✅                                      |                          ✅                          |
|    13.x     |          1.20-1.20.1           |                                     ❌                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                          ❌                          |
|    14.x     |  1.20.2-1.20.4,23w40a-24w13a   |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     ✅                                      |                          ❌                          |
|    15.x     | 1.20.5-1.21.1,24w14a-1.21.1rc1 |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     ✅                                      |                          ✅                          |
|    16.x     |         24w33a-1.21.4          |                                     ✅                                      |                                 -                                  |                                     ✅                                      |                                     ✅                                      |                          ✅                          |

## Forge
| Mod version | Minecraft versions | [#38](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/38) | [LegendaryTooltips](https://github.com/AHilyard/LegendaryTooltips) | [#72](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/72) | [#75](https://github.com/flowerinsnowdh/GreatScrollableTooltips/issues/75) | [Apotheosis](https://github.com/Shadows-of-Fire/Apotheosis) | [AppleSkin](https://github.com/squeek502/AppleSkin) | [Obscure Tooltips](https://www.curseforge.com/minecraft/mc-mods/obscure-tooltips) |
| :---------: | :----------------: | :------------------------------------------------------------------------: | :----------------------------------------------------------------: | :------------------------------------------------------------------------: | :------------------------------------------------------------------------: | :---------------------------------------------------------: | :-------------------------------------------------: | :-------------------------------------------------------------------------------: |
|     1.x     |     1.8.9-1.10     |                                     -                                      |                                 -                                  |                                     ✅                                      |                                     -                                      |                              -                              |                          -                          |                                         -                                         |
|     3.x     |     1.10-1.11      |                                     ❌                                      |                                 -                                  |                                     ❌                                      |                                     ❌                                      |                              ❌                              |                          ❌                          |                                         -                                         |
|     4.x     |       1.12.2       |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     -                                      |                              ❓                              |                          ✅                          |                                         -                                         |
|     8.x     |       1.18.2       |                                     ✅                                      |                                 ❌                                  |                                     ✅                                      |                                     ❌                                      |                              ❌                              |                          ❌                          |                                         ❌                                         |
|    11.x     |       1.19.2       |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     ✅                                      |                              ❌                              |                          ✅                          |                                         -                                         |
|    13.x     |       1.19.4       |                                     ✅                                      |                                 ❌                                  |                                     ❌                                      |                                     ❌                                      |                              ❌                              |                          ❌                          |                                         ❌                                         |
|    15.x     |       1.20.1       |                                     ✅                                      |                                 ✅                                  |                                     ✅                                      |                                     ✅                                      |                              ✅                              |                          ✅                          |                                         ✅                                         |

# Credits
- **Original project**: [GreatScrollableTooltips](https://github.com/flowerinsnowdh/GreatScrollableTooltips) by [flowerinsnow](https://github.com/flowerinsnowdh) — all credits for the original work belong to the original author.
- **Reforged version**: maintained by [NiButCrazy](https://github.com/NiButCrazy).

The original project is developed with the support of [JetBrains](https://www.jetbrains.com/); they provide free licenses for their IDEs to open-source projects.

[<img src="README/CREDITS/jetbrains.png" alt="jetbrains.png"/>](https://www.jetbrains.com)

I sincerely thank [JetBrains](https://www.jetbrains.com/) for their [support of open-source software](https://www.jetbrains.com/community/opensource/). If you're looking for powerful development tools, check out [JetBrains' products](https://www.jetbrains.com/products/).
package cn.flowerinsnow.greatscrollabletooltips.config;

import com.electronwill.nightconfig.core.CommentedConfig;
import com.electronwill.nightconfig.core.io.WritingException;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.electronwill.nightconfig.toml.TomlFormat;
import com.electronwill.nightconfig.toml.TomlParser;
import com.electronwill.nightconfig.toml.TomlWriter;
import cn.flowerinsnow.greatscrollabletooltips.common.provider.ModEnvironmentProvider;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

/**
 * <p>模组配置</p>
 * <p>新配置项属于 1.20.1-forge 专属，因此不再复用 common 模块中的配置类</p>
 */
public class GreatScrollableTooltipsConfig {
    /**
     * <p>按键反转的默认值</p>
     */
    public static final boolean DEFAULT_INVERT_KEY = true;
    /**
     * <p>关闭鼠标滚轮位移的默认值</p>
     */
    public static final boolean DEFAULT_DISABLE_MOUSE_SCROLL = true;

    private final ModEnvironmentProvider environmentProvider;

    public GreatScrollableTooltipsConfig(ModEnvironmentProvider environmentProvider) {
        this.environmentProvider = environmentProvider;
    }

    public boolean enable;
    public int sensitivity;
    public boolean autoReset;
    /**
     * <p>按键反转（上下左右方向键）</p>
     */
    public boolean invertKey = DEFAULT_INVERT_KEY;
    /**
     * <p>关闭鼠标滚轮位移</p>
     * <p>避免滚轮与物品列表滚动/翻页产生冲突</p>
     */
    public boolean disableMouseScroll = DEFAULT_DISABLE_MOUSE_SCROLL;

    public void saveDefaultConfig() {
        Path configFile = this.environmentProvider.getConfigFile();
        File file = configFile.toFile();
        if (!file.exists()) {
            try {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
                int len;
                byte[] bytes = new byte[1024];
                try (InputStream in = this.environmentProvider.getDefaultConfigAsStream()) {
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        while ((len = in.read(bytes)) != -1) {
                            fos.write(bytes, 0, len);
                        }
                    }
                }
            } catch (IOException e) {
                this.environmentProvider.crash(e, "failed to save default config");
            }
        }
    }

    public void load() {
        TomlFormat format = TomlFormat.instance();
        TomlParser parser = format.createParser();
        CommentedConfig config;
        try {
            config = parser.parse(this.environmentProvider.getConfigFile(), (path, ignored0) -> {
                this.environmentProvider.crash(new FileNotFoundException(path.toString()), "failed to load config");
                return false;
            }, StandardCharsets.UTF_8);
        } catch (WritingException e) {
            this.environmentProvider.crash(e, "failed to load config file");
            return;
        }
        this.enable = config.get("enable");
        this.sensitivity = config.getInt("sensitivity");
        this.autoReset = config.get("auto_reset");
        // 旧版本生成的配置文件可能没有新增字段，缺省时使用默认值
        Boolean invertKey = config.get("invert_key");
        this.invertKey = invertKey != null ? invertKey : DEFAULT_INVERT_KEY;
        Boolean disableMouseScroll = config.get("disable_mouse_scroll");
        this.disableMouseScroll = disableMouseScroll != null ? disableMouseScroll : DEFAULT_DISABLE_MOUSE_SCROLL;
    }

    public void save() {
        TomlFormat format = TomlFormat.instance();
        CommentedConfig config = format.createConfig();
        config.set("enable", this.enable);
        config.set("sensitivity", this.sensitivity);
        config.set("auto_reset", this.autoReset);
        config.set("invert_key", this.invertKey);
        config.set("disable_mouse_scroll", this.disableMouseScroll);
        TomlWriter writer = format.createWriter();
        try {
            writer.write(config, this.environmentProvider.getConfigFile(), WritingMode.REPLACE, StandardCharsets.UTF_8);
        } catch (WritingException e) {
            this.environmentProvider.crash(e, "failed to save config");
        }
    }
}

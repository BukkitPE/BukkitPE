package net.BukkitPE.plugin;

/**
 * 描述一个Nukkit插件加载顺序的类。<br>
 * Describes a BukkitPE plugin load order.
 * <p>
 * <p>Nukkit插件的加载顺序有两个:{@link net.BukkitPE.plugin.PluginLoadOrder#STARTUP}
 * 和 {@link net.BukkitPE.plugin.PluginLoadOrder#POSTWORLD}。<br>
 * The load order of a BukkitPE plugin can be {@link net.BukkitPE.plugin.PluginLoadOrder#STARTUP}
 * or {@link net.BukkitPE.plugin.PluginLoadOrder#POSTWORLD}.</p>
 *
 * @author MagicDroidX(code) @ BukkitPE Project
 * @author iNevet(code) @ BukkitPE Project
 * @author 粉鞋大妈(javadoc) @ BukkitPE Project
 * @since BukkitPE 1.0 | BukkitPE API 1.0.0
 */
public enum PluginLoadOrder {
    /**
     * 表示这个插件在服务器启动时就开始加载。<br>
     * Indicates that the plugin will be loaded at startup.
     *
     * @see net.BukkitPE.plugin.PluginLoadOrder
     * @since BukkitPE 1.0 | BukkitPE API 1.0.0
     */
    STARTUP,
    /**
     * 表示这个插件在第一个世界加载完成后开始加载。<br>
     * Indicates that the plugin will be loaded after the first/default world was created.
     *
     * @see net.BukkitPE.plugin.PluginLoadOrder
     * @since BukkitPE 1.0 | BukkitPE API 1.0.0
     */
    POSTWORLD
}

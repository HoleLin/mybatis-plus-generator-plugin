package cn.holelin

import cn.holelin.plugin.MyBatisPlusGeneratorPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @Description: 插件启动入口类
 * @Author: HoleLin
 * @CreateDate: 2022/2/15 3:14 PM
 * @UpdateUser: HoleLin
 * @UpdateDate: 2022/2/15 3:14 PM
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */

class PluginApplication implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.plugins.apply(MyBatisPlusGeneratorPlugin)
    }
}

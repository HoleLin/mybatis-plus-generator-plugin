package cn.holelin.plugin

import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @Description: 插件实现类
 * @Author: HoleLin
 * @CreateDate: 2022/2/15 3:16 PM
 * @UpdateUser: HoleLin
 * @UpdateDate: 2022/2/15 3:16 PM
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */

class MyBatisPlusGeneratorPlugin implements Plugin<Project> {

    String EXTENSION_NAME = "mp_generator"

    @Override
    void apply(Project project) {
        MyBatisPlusGeneratorExtension extension = project.extensions.create(EXTENSION_NAME,
                MyBatisPlusGeneratorExtension, project.objects)
        if (extension != null) {
            def task = project.tasks.create(EXTENSION_NAME)
            task.group = "mybatis"
            task.doLast {
                AutoGenerator autoGenerator = new AutoGenerator()
                // 配置全局配置
                autoGenerator.setGlobalConfig(extension.globalConfig)

                // 配置数据源
                autoGenerator.setDataSource(extension.dataSourceConfig)

                // 配置包信息
                autoGenerator.setPackageInfo(extension.packageConfig)

                // 配置生成策略
                autoGenerator.setStrategy(extension.strategyConfig)

                autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine())

                autoGenerator.execute()
            }
        }
    }

}

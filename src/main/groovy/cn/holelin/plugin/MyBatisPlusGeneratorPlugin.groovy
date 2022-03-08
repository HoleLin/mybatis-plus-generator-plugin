package cn.holelin.plugin

import cn.holelin.plugin.custom.config.CustomConfig
import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.InjectionConfig
import com.baomidou.mybatisplus.generator.config.FileOutConfig
import com.baomidou.mybatisplus.generator.config.IFileCreate
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder
import com.baomidou.mybatisplus.generator.config.po.TableInfo
import com.baomidou.mybatisplus.generator.config.rules.FileType
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy
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
    String TASK_GROUP_NAME = "mybatis"

    @Override
    void apply(Project project) {
        MyBatisPlusGeneratorExtension extension = project.extensions.create(EXTENSION_NAME,
                MyBatisPlusGeneratorExtension, project.objects)
        println(EXTENSION_NAME + " Task Start...")
        if (extension != null) {
            def task = project.tasks.create(EXTENSION_NAME)
            task.group = TASK_GROUP_NAME
            task.doLast {
                AutoGenerator autoGenerator = new AutoGenerator()
                // 配置全局配置
                autoGenerator.setGlobalConfig(extension.globalConfig)
                // 配置数据源
                autoGenerator.setDataSource(extension.dataSourceConfig)
                // 配置包信息
                autoGenerator.setPackageInfo(extension.packageConfig)
                // 配置生成策略
                // 默认驼峰
                extension.strategyConfig.naming = NamingStrategy.underline_to_camel
                extension.strategyConfig.columnNaming = NamingStrategy.underline_to_camel
                autoGenerator.setStrategy(extension.strategyConfig)
                // 设置模板引擎
                autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine())

                CustomConfig customConfig = extension.customConfig
                String resourceMapperXMLPath = customConfig.resourceMapperXMLPath
                String resourceMapperXMLSuffix = customConfig.resourceMapperXMLSuffix
                String templateMapperPath = customConfig.mapperXMLTemplatePath
                InjectionConfig injectionConfig = new InjectionConfig() {
                    @Override
                    void initMap() {

                    }
                }
                List<FileOutConfig> customConfigs = new ArrayList<>()
                // Mapper Xml文件输出配置
                FileOutConfig mapperXMLFileOutConfig = new FileOutConfig(templateMapperPath) {
                    @Override
                    String outputFile(TableInfo tableInfo) {
                        println("deal Xml")
                        def path = project.projectDir.path + resourceMapperXMLPath
                        def fileName = tableInfo.getEntityName() + resourceMapperXMLSuffix
                        return path + fileName
                    }
                }
                customConfigs.add(mapperXMLFileOutConfig)

                // 设置文件创建规则
                injectionConfig.setFileCreate(createFileFilter(customConfig))

                injectionConfig.setFileOutConfigList(customConfigs)

                autoGenerator.setCfg(injectionConfig)
                autoGenerator.execute()
            }

        }
    }

    /**
     * 文件创建过滤
     * @param customConfig 自定义配置
     * @return
     */
    private static IFileCreate createFileFilter(customConfig) {
        return new IFileCreate() {
            @Override
            boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                if (fileType == FileType.ENTITY &&
                        customConfig.isCreateEntity) {
                    println("create " + FileType.ENTITY.name())
                    return true
                }
                if (fileType == FileType.MAPPER &&
                        customConfig.isCreateMapper) {
                    println("create " + FileType.MAPPER.name())
                    return true
                }
                if (fileType == FileType.SERVICE &&
                        customConfig.isCreateService) {
                    println("create " + FileType.SERVICE.name())
                    return true
                }
                if (fileType == FileType.SERVICE_IMPL &&
                        customConfig.isCreateServiceImpl) {
                    println("create " + FileType.SERVICE_IMPL.name())
                    return true
                }
                if (fileType == FileType.CONTROLLER &&
                        customConfig.isCreateController) {
                    println("create " + FileType.CONTROLLER.name())
                    return true
                }
                if (fileType == FileType.XML &&
                        customConfig.isCreateXml) {
                    println("create " + FileType.XML.name())
                    return true
                }
                if (fileType == FileType.OTHER &&
                        customConfig.isCreateOther) {
                    println("create " + FileType.OTHER.name())
                    return true
                }
                return false
            }
        }
    }

}

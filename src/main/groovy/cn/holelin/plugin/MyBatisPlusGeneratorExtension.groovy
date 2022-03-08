package cn.holelin.plugin

import com.baomidou.mybatisplus.generator.InjectionConfig
import com.baomidou.mybatisplus.generator.config.DataSourceConfig
import com.baomidou.mybatisplus.generator.config.GlobalConfig
import com.baomidou.mybatisplus.generator.config.PackageConfig
import com.baomidou.mybatisplus.generator.config.StrategyConfig
import com.baomidou.mybatisplus.generator.config.TemplateConfig
import org.gradle.api.Action
import org.gradle.api.model.ObjectFactory

import javax.inject.Inject

/**
 * @Description: MyBatis Plus 代码生成器扩展配置类
 * @Author: HoleLin
 * @CreateDate: 2022/2/15 3:05 PM
 * @UpdateUser: HoleLin
 * @UpdateDate: 2022/2/15 3:05 PM
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */

class MyBatisPlusGeneratorExtension {

    /**
     * 启用开关 默认开启
     */
    boolean enabled = true

    /**
     * 数据库配置
     */
    DataSourceConfig dataSourceConfig

    /**
     * 全局配置
     */
    GlobalConfig globalConfig

    /**
     * 包配置
     */
    PackageConfig packageConfig

    /**
     * 模板配置
     */
    TemplateConfig templateConfig


    /**
     * 策略配置
     */
    StrategyConfig strategyConfig

    @Inject
    MyBatisPlusGeneratorExtension(ObjectFactory objectFactory) {
        dataSourceConfig = objectFactory.newInstance(DataSourceConfig)
        globalConfig = objectFactory.newInstance(GlobalConfig)
        packageConfig = objectFactory.newInstance(PackageConfig)
        templateConfig = objectFactory.newInstance(TemplateConfig)
        strategyConfig = objectFactory.newInstance(StrategyConfig)
    }

    void dataSourceConfig(Action<? super GlobalConfig> action) {
        action.execute(dataSourceConfig)
    }

    void globalConfig(Action<? super GlobalConfig> action) {
        action.execute(globalConfig)
    }

    void packageConfig(Action<? super GlobalConfig> action) {
        action.execute(packageConfig)
    }

    void templateConfig(Action<? super GlobalConfig> action) {
        action.execute(templateConfig)
    }

    void strategyConfig(Action<? super GlobalConfig> action) {
        action.execute(strategyConfig)
    }

}

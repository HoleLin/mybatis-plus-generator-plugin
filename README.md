### 参考文献

* [MyBatis-Plus文档](https://baomidou.com/)
* [mybatis-plus-gradle-generator](https://github.com/LiushuiXiaoxia/mybatis-plus-gradle-generator)

### MyBaitsPlus代码生成器Gradle插件

#### 本地使用

* 可参考[工具-Gradle插件开发](https://www.holelin.cn/2022/02/14/tools/%E5%B7%A5%E5%85%B7-Gradle%E6%8F%92%E4%BB%B6%E5%BC%80%E5%8F%91/ )中的"Gradle插件开发流程->使用插件(本地)"

#### 配置

```groovy
mp_generator {
    globalConfig {
        outputDir = projectDir.path + "/src/main/kotlin"
        author = "HoleLin"
        kotlin = true
        open = false
        baseResultMap = true
        fileOverride = true
    }

    dataSourceConfig {
        driverName = "com.mysql.cj.jdbc.Driver"
        url = "jdbc:mysql://localhost:3306/lack?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai"
        username = "root"
        password = "holelin.."
    }


    packageConfig {
        parent = "cn.holelin"

    }

    strategyConfig {
        include = ["pro_follow_up_schedule_point"]
        naming= NamingStrategy.underline_to_camel
    }

    customConfig {
        isCreateEntity = false
        isCreateService = false
        isCreateServiceImpl = false
        isCreateMapper = false
        isCreateXml = false
        isCreateController = false
        isCreateOther = true
        resourceMapperXMLPath="/src/main/resources/mapping/"
    }
}
```




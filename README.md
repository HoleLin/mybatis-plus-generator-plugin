### 参考文献

* [MyBatis-Plus文档](https://baomidou.com/)
* [mybatis-plus-gradle-generator](https://github.com/LiushuiXiaoxia/mybatis-plus-gradle-generator)

### MyBaitsPlus代码生成器Gradle插件

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




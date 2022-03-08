package cn.holelin.plugin.custom.config
/**
 * @Description: 自定义配置类
 * @Author: HoleLin
 * @CreateDate: 2022/3/8 4:17 PM
 * @UpdateUser: HoleLin
 * @UpdateDate: 2022/3/8 4:17 PM
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */

class CustomConfig {

    /**
     * 控制是否生成对应的文件
     */
    /**
     * 是否生成实体类
     */
    boolean isCreateEntity = true
    boolean isCreateService = true
    boolean isCreateServiceImpl = true
    boolean isCreateMapper = true
    boolean isCreateXml = true
    boolean isCreateController = true
    boolean isCreateOther = true


    /**
     * MapperXml文件输出路径以及名称
     */
    /**
     * 资源文件默认路径
     */
    String resourceMapperXMLPath = "/src/main/resources/mapper/"

    /**
     * XML文件的尾缀
     */
    String resourceMapperXMLSuffix = "Mapper.xml"

    /**
     * MapperXML模板文件路径
     */
    String mapperXMLTemplatePath = "/templates/mapper.xml.ftl"


}

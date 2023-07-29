package com.bruce.demo.common.generator;

import com.bruce.demo.common.entity.BasePo;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author bruce
 * @date 2023/7/29
 * @desc 代码生成器
 */
public class Codegen {

    /**
     * 根包名
     */
    public static final String BASE_PACKAGE = "com.bruce.demo";
    /**
     * 代码模块
     */
    public static final String CODE_MODULE = "test";
    /**
     * 去表前缀
     */
    public static final String TABLE_PREFIX = "tb_";
    /**
     * 表
     */
    protected static final String[] GENERATE_TABLES = {"tb_account"};

    public static void main(String[] args) {
        //创建配置内容，两种风格都可以。
        GlobalConfig globalConfig = createGlobalConfigUseStyle1();
        //GlobalConfig globalConfig = createGlobalConfigUseStyle2();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(getDataSource(), globalConfig);

        //生成代码
        generator.generate();
    }

    public static HikariDataSource getDataSource() {
        //配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF8&useSSL=true&serverTimezone=GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("root12345");
        return dataSource;
    }

    public static GlobalConfig createGlobalConfigUseStyle1() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包
        globalConfig.setBasePackage(BASE_PACKAGE + "." + CODE_MODULE);

        //设置表前缀和只生成哪些表
        globalConfig.setTablePrefix(TABLE_PREFIX);
        globalConfig.setGenerateTable(GENERATE_TABLES);
        globalConfig.setEntitySuperClass(BasePo.class);
        globalConfig.setEntityPackage(globalConfig.getEntityPackage() + ".po");
        globalConfig.setVersionColumn("version");
        globalConfig.setLogicDeleteColumn("is_delete");

        //设置生成 entity 并启用 Lombok
        globalConfig.setEntityGenerateEnable(true);
        globalConfig.setEntityWithLombok(true);
        globalConfig.setEntityWithSwagger(true);

        //设置生成 mapper
        globalConfig.setMapperGenerateEnable(true);
        globalConfig.setMapperXmlGenerateEnable(true);
        globalConfig.setMapperXmlPath("src/main/resources/mapper/" + CODE_MODULE);

        globalConfig.setServiceGenerateEnable(true);
        globalConfig.setServiceImplGenerateEnable(true);
        globalConfig.setControllerGenerateEnable(true);

        return globalConfig;
    }

    public static GlobalConfig createGlobalConfigUseStyle2() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包
        globalConfig.getPackageConfig()
                .setBasePackage("com.test");

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setGenerateSchema("schema")
                .setTablePrefix("t_")
                .setGenerateTable("account", "account_session");

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true);

        //设置生成 mapper
        globalConfig.enableMapper();

        //可以单独配置某个列
        ColumnConfig columnConfig = new ColumnConfig();
        columnConfig.setColumnName("tenant_id");
        columnConfig.setLarge(true);
        columnConfig.setVersion(true);
        globalConfig.getStrategyConfig()
                .setColumnConfig("account", columnConfig);

        return globalConfig;
    }
}

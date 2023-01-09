package com.sxit.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Generator {

    // 表前缀
    private final static String[] TABLEPREFIX = new String[] {
			"SPC"
    };
    // 需要生成的表
    private final static String[] INCLUDE     = new String[] {
			"CHANNEL_AUDIT_LOG"
    };
    // 排除生成的表
    private final static String[] EXCLUDE     = new String[] {};
	private final static String OUTPUTDIR = "E:\\a";
	// private final static String OUTPUTDIR = System.getProperty("user.dir") +
	// "/src/main/java";
    private final static String   AUTHOR      = "lipeng";

    public static void main(String[] args) throws Exception {
		AutoGenerator mpg = getAutoGenerator();
		if ("a".equals("b"))
			return;
		// 执行生成
		mpg.execute();
        // 打印注入设置【可无】
        // System.err.println(mpg.getCfg().getMap().get("abc"));

    }

    private static GlobalConfig getGlobalConfig() {
        // 全局配置
        return new GlobalConfig()
				.setOutputDir(OUTPUTDIR)// 生成文件的输出目录，默认D盘
				.setFileOverride(true)// 是否覆盖已有的相同文件
				.setEnableCache(false)// 是否在xml中添加二级缓存配置
				.setIdType(IdType.INPUT)// 指定生成的主键的ID类型
				.setAuthor(AUTHOR)// 作者
				.setKotlin(false)// 开启 Kotlin 模式
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
				.setBaseResultMap(true)
				.setBaseColumnList(true)
                .setControllerName("%sController");
    }

    private static DataSourceConfig getDataSourceConfig() {
        // 数据源配置
		return new DataSourceConfig()
				.setDbType(DbType.ORACLE)// 数据库类型
//				.setDbQuery(new OracleQuery() {// 查询 SQL 语句 定制化返回自己需要的内容
//					@Override
//					public String tablesSql() {
//						return "select 1 from dual;";
//					}
//				})
				.setTypeConvert(new OracleTypeConvert() {// 数据库 字段类型 转换为自己需要的 java 类型
					@Override
					public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
						String t = fieldType.toUpperCase();
						if (t.contains("DATE") || t.contains("TIMESTAMP"))
							return DbColumnType.TIMESTAMP;
						return super.processTypeConvert(globalConfig, fieldType);
					}
				})
				.setDriverName("oracle.jdbc.driver.OracleDriver")
				.setUsername("pgctmp")
				.setPassword("pgctmp")
				.setUrl("jdbc:oracle:thin:@211.137.43.239:1521:ora11");
    }

    private static StrategyConfig getStrategyConfig() throws Exception {
        if (INCLUDE.length == 0) { throw new Exception("要生成的表名不能为空"); }
        // 策略配置
        return new StrategyConfig()
				// .setVersionFieldName("VERSION")// 乐观锁属性名称
				// .setLogicDeleteFieldName("DELETED")// 逻辑删除属性名称
				.setTablePrefix(TABLEPREFIX)// 表前缀
				.setNaming(NamingStrategy.underline_to_camel)// 数据库表映射到实体的命名策略
				//.setColumnNaming(NamingStrategy.underline_to_camel)//数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
                .setInclude(INCLUDE)
                .setExclude(EXCLUDE)
				.setEntityLombokModel(true)// 是否为lombok模型
				.setEntityTableFieldAnnotationEnable(true)// 是否生成实体时，生成字段注解
                // 自定义实体父类
				// .setSuperEntityClass("com.baomidou.demo.TestEntity")
		// .setSuperEntityClass(com.baomidou.mybatisplus.extension.activerecord.Model<?>.class)
                // 自定义实体，公共字段
                // .setSuperEntityColumns(new String[] { "test_id", "age" })
                // 自定义 mapper 父类
                // .setSuperMapperClass("com.baomidou.demo.TestMapper")
                // 自定义 service 父类
                // .setSuperServiceClass("com.baomidou.demo.TestService")
                // 自定义 service 实现类父类
                // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
                // 自定义 controller 父类
		// .setSuperControllerClass(BaseController.class.getName())
        // 【实体】是否生成字段常量（默认 false），public static final String ID = "test_id";
        // .setEntityColumnConstant(true)
        // 【实体】是否为构建者模型（默认 false），public User setName(String name) {this.name = name; return this;}
        // .setEntityBuliderModel(true)
        ;
    }

    private static PackageConfig getPackageConfig() throws Exception {
        // 包配置
        String[] packageInfo = getPackageInfo();
		return new PackageConfig()
				.setParent(packageInfo[1]);
		// .setModuleName(packageInfo[2]);
    }

    /**
     * 生成包信息。如果包名为空，则将包名设置为模块名，模块名为空
     *
     * @author 傅国成 2018年7月9日 上午11:10:00
     * @return 当前包名，包名，模块名
     * @throws Exception
     */
    private static String[] getPackageInfo() throws Exception {
        if (Generator.class.getPackage() == null) { throw new Exception("包名获取失败！"); }
        String currPackageName = Generator.class.getPackage().getName();
        String[] currPackageNames = currPackageName.split("\\.");
        String moduleName = "";
        String packageName = "";
        if (currPackageNames.length > 1) {
            moduleName = currPackageNames[currPackageNames.length - 1];
            for (int i = 0; i < currPackageNames.length - 1; i++) {
                packageName += (i > 0 ? "." : "") + currPackageNames[i];
            }
        } else {
            packageName = currPackageNames[currPackageNames.length - 1];
        }
        return new String[] {
                currPackageName, packageName, moduleName
        };
    }

    @SuppressWarnings("unused")
    private static InjectionConfig getInjectionConfig() throws Exception {
        // 自定义 jsp 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/template/list.jsp.vm") {
            String[] p = getPackageInfo();

            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return OUTPUTDIR + "views/" + (p[2] == null || p[2].length() == 0 ? p[1] : p[2]) + "/list.jsp";
            }
        });
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        return new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        }.setFileOutConfigList(focList);
    }

    private static TemplateConfig getTemplateConfig() {
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
        // 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        return new TemplateConfig()
                // .setController("...")
				.setEntity("/templates/entity.java")
        // .setMapper("...")
        // .setXml("...")
        // .setService("...")
        // .setServiceImpl("...")
        ;
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
    }

    private static AutoGenerator getAutoGenerator() throws Exception {
        return new AutoGenerator()
                // 全局配置
                .setGlobalConfig(getGlobalConfig())
                // 数据源配置
                .setDataSource(getDataSourceConfig())
                // 策略配置
                .setStrategy(getStrategyConfig())
                // 包配置
                .setPackageInfo(getPackageConfig())
                // 注入自定义配置
                // .setCfg(getInjectionConfig())
                // 自定义模板配置
                .setTemplate(getTemplateConfig());
    }
}

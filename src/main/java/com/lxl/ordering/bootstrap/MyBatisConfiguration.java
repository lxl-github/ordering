package com.lxl.ordering.bootstrap;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * <p>功能描述信息</p>
 * <p/>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lixiaoliang
 * @version 1.0
 * @date 2017/8/15
 * @since 1.0
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.lxl.ordering.*.dao")
@PropertySource(value = {"classpath:config/${spring.profiles.active}/jdbc.properties"}, encoding = "utf-8")
public class MyBatisConfiguration implements TransactionManagementConfigurer {

    public static final Logger logger = LoggerFactory.getLogger(MyBatisConfiguration.class);

    @Autowired
    private DataSource dataSource;

    @Bean(destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "druid")
    public DruidDataSource dataSource() {
        return (DruidDataSource) DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties props = new Properties();
//        props.setProperty("reasonable", "true");
//        props.setProperty("supportMethodsArguments", "true");
//        props.setProperty("returnPageInfo", "check");
//        props.setProperty("params", "count=countSql");
//        props.setProperty("offsetAsPageNum", "true");
//        props.setProperty("rowBoundsWithCount", "true");
//        props.setProperty("dialect", "mysql");
//        pageHelper.setProperties(props);
//        //添加插件
//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "com/lxl/ordering/*/mapper/*Mapper.xml"));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}

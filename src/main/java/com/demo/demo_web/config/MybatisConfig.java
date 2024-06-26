package com.demo.demo_web.config;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class MybatisConfig {

    @Autowired
    @Qualifier("userDataSource")
    private DataSource userDataSource;
    @Bean
    @Primary
    public SqlSessionFactory userSqlSessionFactoryBean() throws Exception {
        return makeSessionFactory(userDataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate userSqlSession() throws Exception {
        return new SqlSessionTemplate(userSqlSessionFactoryBean());
    }


    private SqlSessionFactory makeSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("/mapper/**/*.xml");

        sqlSessionFactoryBean.setMapperLocations(resources);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.demo.common,com.demo.demo_web");

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();

        org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();

        configuration.setMapUnderscoreToCamelCase(true);

        return sqlSessionFactory;
    }
}
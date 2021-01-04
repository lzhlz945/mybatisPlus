package com.zhang.pm.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置文件
 *
 * 在上面的例子中，com.acme包首先会被扫到，然后再容器内查找被@Component 声明的类，找到后将这些类按照Sring bean定义进行注册。
 * 如果你要在你的web应用开发中选用上述的配置的方式的话，需要用AnnotationConfigWebApplicationContext 类来读取配置文件，
 * 可以用来配置Spring的Servlet监听器ContrextLoaderListener或者Spring MVC的DispatcherServlet。
 *
 * @author
 */
@Configuration
public class MybatisPlusConfig {


    /*
    * <bean id="dataSource"
              class="com.mchange.v2.c3p0.ComboPooledDataSource">
                <property name="driverClass" value="${driverClassName}"></property>
                <property name="jdbcUrl" value="${url}"></property>
                <property name="user" value="${user}"></property>
                <property name="password" value="${password}"></property>
        </bean>
    * */

   /* @Bean
    public ComboPooledDataSource dataSource(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("");
    }*/
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

    /*@Bean
    public MybatisSqlSessionFactoryBean factoryBean(MybatisPlusInterceptor mybatisPlusInterceptor) {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setPlugins(mybatisPlusInterceptor);
        return factoryBean;
    }*/



}

package com.zhang.pm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private ApplicationContext context=new ClassPathXmlApplicationContext("spring/applicationContext.xml");

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}

package com.imooc.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 * 1）获取Connection
 * 2) 关闭资源
 */
public class JDBCUtil {

    /**
     * 获取Connection
     * @return 所获取的JDBC的Connection
     */
    public static Connection getConnection() throws Exception {

        /**
         * 不建议将配置硬编码到代码中
         * 最佳实践：配置性的建议写到配置文件中
         */
        InputStream inputStream = JDBCUtil.class.getClassLoader()
                .getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        String url = properties.getProperty("db.url");
        String userName = properties.getProperty("db.userName");
        String passWord = properties.getProperty("db.passWord");
        String driverClass = properties.getProperty("db.driver");

        Class.forName(driverClass);
        return DriverManager.getConnection(url, userName, passWord);
    }

    /**
     * 将传入的resultSet、 statement、 connection关闭
     * 释放DB相关的资源
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void release(ResultSet resultSet, Statement statement, Connection connection){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null){
            try{
                statement.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        if(connection != null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}

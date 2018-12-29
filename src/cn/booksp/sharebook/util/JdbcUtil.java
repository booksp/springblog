package cn.booksp.sharebook.util;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    private static Connection conn;
    private static DruidDataSource dataSource;
    static{
        try{
            InputStream conf = JdbcUtil.class.getResourceAsStream("/resources/Jdbconfig.properties");
            Properties properties = new Properties();
            properties.load(conf);
            dataSource = new DruidDataSource();
            dataSource.setDriverClassName(properties.getProperty("db_driver"));
            dataSource.setUrl(properties.getProperty("db_url"));
            dataSource.setUsername(properties.getProperty("db_user"));
            dataSource.setPassword(properties.getProperty("db_pswd"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Connection getDBConn(){
        try{
            conn = dataSource.getConnection();
            return conn;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

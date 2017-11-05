package com.wl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具
 * Created by WL on 2017/9/6.
 */
public class DbUtils {
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    public  Connection getCurrentConnecton() {
        Connection connection=threadLocal.get();
        if (!isValid(connection)){
            connection=getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }
    public synchronized Connection getConnection(){
        Connection connection=null;
        String driver=PropertyUtil.getProperty("driverClasss");
        String jdbcUrl=PropertyUtil.getProperty("jdbcUrl");
        String username=PropertyUtil.getProperty("username");
        String password=PropertyUtil.getProperty("password");
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(jdbcUrl,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    // 判断连接是否可用
    private boolean isValid(Connection conn) {
        try {
            if (conn == null || conn.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}

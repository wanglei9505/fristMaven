package com.wl.quartz;

import com.wl.utils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by WL on 2017/9/6.
 */
public class SelectJob {
    DbUtils dbUtils=new DbUtils();
    public void execute(){
        String sql="select * from test";
        Connection connection= dbUtils.getCurrentConnecton();
        try {
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[][] a={{0},{1,2},{1,2,3}};
        int[][] b=new int[2][3];
        System.out.println();
    }
}

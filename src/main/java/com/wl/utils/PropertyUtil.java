package com.wl.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Desc:properties文件获取工具类
 * Created by WL on 2017/9/6.
 */
public class PropertyUtil {
    private static final Logger log= LoggerFactory.getLogger(PropertyUtil.class);
    private static Properties props;
    static {
        loadProps();
    }

    public static void main(String[] args) {
        System.out.println(PropertyUtil.getProperty("jdbcUrl"));
    }
    synchronized static private void loadProps(){
        log.info("开始加载properties文件内容.......");
        props=new Properties();
        InputStream in=null;
        try {
//        第一种，通过类加载器进行获取properties文件流
        in=PropertyUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
//        <!--第二种，通过类进行获取properties文件流-->
        //in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("出现IOException");
        }finally {
            if(null !=in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error("jdbc.properties文件流关闭出现异常");
                }
            }
        }
        log.info("加载properties文件内容完成...........");
        log.info("properties文件内容：" + props);
    }
    public static String getProperty(String key){
        if (null == null){
            loadProps();
        }
        return props.getProperty(key);
    }
    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}

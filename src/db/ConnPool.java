package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 获取数据库连接
 * User: JH
 * Date: 13-11-19
 * Time: 上午10:50
 */
public  class ConnPool {
    private Connection conn = null;
    private Properties prop = new Properties();
    InputStream fis = null;
    //GET
    public Connection getConn(){
        try {
            fis = ConnPool.class.getResourceAsStream("config.properties");
            prop.load(fis);
            Class.forName(prop.getProperty("dbdriver"));
            conn = DriverManager.getConnection(prop.getProperty("dburl"), prop.getProperty("dbuser"), prop.getProperty("dbpass"));
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("读取配置文件出错...");
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
            System.out.println("找不到类驱动，数据连接初始化失败...");
        }
        catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("数据库连接失败...");
        }
        finally {
            try{
                fis.close();
            }
            catch (IOException e){
                e.printStackTrace();
                System.out.println("关闭流失败...");
            }
        }
        return conn;
    }
}

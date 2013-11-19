package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ��ȡ���ݿ�����
 * User: JH
 * Date: 13-11-19
 * Time: ����10:50
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
            System.out.println("��ȡ�����ļ�����...");
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
            System.out.println("�Ҳ������������������ӳ�ʼ��ʧ��...");
        }
        catch (SQLException ex){
            ex.printStackTrace();
            System.out.println("���ݿ�����ʧ��...");
        }
        finally {
            try{
                fis.close();
            }
            catch (IOException e){
                e.printStackTrace();
                System.out.println("�ر���ʧ��...");
            }
        }
        return conn;
    }
}

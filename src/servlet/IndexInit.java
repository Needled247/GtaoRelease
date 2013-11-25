package servlet;

import db.ConnPool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 主页初始化。
 * User: JH
 * Date: 13-11-21
 * Time: 下午5:11
 */
public class IndexInit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=GBK");
        PrintWriter out = response.getWriter();
        String filmInitQuery = "SELECT ID,FILENAME FROM rl_film WHERE STATUS='999'";
        String softInitQuery = "SELECT ID,FILENAME FROM rl_software WHERE STATUS='999'";
        String gameInitQuery = "SELECT ID,FILENAME FROM rl_game WHERE STATUS='999'";
        //拼接JSON字符串
        String rtnJson = "{\"film\":"+this.getShareInfoJson(filmInitQuery)
                +"\"soft\":"+this.getShareInfoJson(softInitQuery)
                +"\"game\":"+this.getShareInfoJson(gameInitQuery);
        if(rtnJson.length()>0){
            rtnJson = rtnJson.substring(0,rtnJson.length()-1);
        }
        rtnJson += "}";
        //打印
        out.print(rtnJson);
        out.flush();
        out.close();
    }

    protected String getShareInfoJson(String sql){
        ConnPool cp = new ConnPool();
        ResultSet rs = null;
        StringBuilder info = new StringBuilder();
        info.append("[");
        PreparedStatement pstmt = null;
        try{
            pstmt = cp.getConn().prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                info.append("{\"id\":\""+rs.getInt(1)+"\",")
                    .append("\"name\":\""+rs.getString(2)+"\"},");
            }
            if(info.length()>2){
                info.deleteCharAt(info.lastIndexOf(","));
            }
            info.append("],");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(pstmt!=null){
                try{
                    pstmt.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return info.toString();
    }
}

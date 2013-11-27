package servlet;

import db.ConnPool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 电影显示页
 * User: JH
 * Date: 13-11-26
 * Time: 下午4:40
 */
public class FilmInit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        int mark = Integer.parseInt(request.getParameter("mark"));
        String initQuery = "SELECT * FROM rl_film LIMIT "+mark+",20";
        ConnPool cp = new ConnPool();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        StringBuilder sb = new StringBuilder();
        try{
            conn = new ConnPool().getConn();
            pstmt = conn.prepareStatement(initQuery);
            rs = pstmt.executeQuery();
            while (rs.next()){
                sb.append("<div class=\"col-sm-4 col-md-3\">")
                        .append("<div class=\"thumbnail\">")
                        .append("<img src=\""+rs.getString(10)+"\">")//TODO
                        .append("<div class=\"caption\">")
                        .append("<h3>"+rs.getString(2)+"</h3>")
                        .append("<p>简介："+rs.getString(11)+"</p>")//TODO
                        .append("</div>")
                        .append("<div style=\"text-align: center\">")
                        .append("<p><a href=\""+rs.getString(3)+"\" class=\"btn btn-success\" role=\"button\">下载</a> </p></div>")
                        .append("</div>")
                        .append("</div>");
            }
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
            if(conn!=null){
                try{
                    conn.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        out.print(sb);
        out.flush();
        out.close();
    }
}

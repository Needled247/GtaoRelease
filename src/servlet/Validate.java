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
 * µ«¬Ω–£—È
 * User: JH
 * Date: 13-11-29
 * Time: œ¬ŒÁ5:27
 */
public class Validate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        String userid = request.getParameter("userid");
        String userpass = request.getParameter("userpass");
        String query = "SELECT USERNAME,LEVEL FROM rl_admin WHERE USERID=? AND USERPASS=?";
        ConnPool cp = new ConnPool();
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String username = "",level = "";
        String rtnHtml = "";
        try{
            conn = cp.getConn();
            pstmt.setString(1,userid);
            pstmt.setString(2,userpass);
            rs = pstmt.executeQuery(query);
            if (rs.next()){
                username = rs.getString(1);
                level = rs.getString(2);
                rtnHtml = username+","+level;
            }
            else {
                rtnHtml = "’À∫≈/√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬ÃÓ–¥°£";
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(conn!=null){
                try{
                    conn.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(pstmt!=null){
                try{
                    pstmt.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(rs!=null){
                try{
                    rs.close();
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        out.print(rtnHtml);
        out.flush();
        out.close();
    }
}

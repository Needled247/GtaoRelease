package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ��ҳ��ʼ����
 * User: JH
 * Date: 13-11-21
 * Time: ����5:11
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
        //TODO:��ѯ������Դ��ÿ��5����ƴ�ӳ�json�ַ�����
    }
}

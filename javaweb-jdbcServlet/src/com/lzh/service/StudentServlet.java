package com.lzh.service;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet implements Servlet {

    //Git test
    public StudentServlet() {
        System.out.println("启动创建对象！！！成功");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init方法执行了！！！1");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html;charset=UTF-8");
        PrintWriter out = servletResponse.getWriter();


        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            System.out.println("Git");
            System.out.println("service方法执行了");
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","123456");

            String sql = "select sno,sname,sage from t_stu";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while(rs.next()){

                String sno = rs.getString("sno");
                String sname = rs.getString("sname");
                String sage = rs.getString("sage");
                System.out.println(sno + " " + sname + " " + sage);
                out.println(sno + " " + sname + " " + sage);

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法执行了");
    }
}

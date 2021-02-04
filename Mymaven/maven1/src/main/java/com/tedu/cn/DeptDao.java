package com.tedu.cn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * ClassName:DeptDao
 * Package:com.tedu.cn
 * Description:
 *数据库操作
 * @Data:2020/10/20 10:49
 * Author:崔建新
 */
public class DeptDao {
    public void findDept() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a", "root", "cjx990725");
        PreparedStatement ps = con.prepareStatement("select * from j");
        ResultSet rs = ps.executeQuery();
        rs.next();
        String num=rs.getString(2);
        System.out.println(num);
    }

    public static void main(String[] args) {
        System.out.println("aaaaa");
    }
}

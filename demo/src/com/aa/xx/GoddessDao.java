package com.aa.xx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoddessDao {
    public void addGoddess(Goddess g) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = "" +
                "insert into imooc_goddess " +
                "(user_name,sex,age,birthday,email,mobile, " +
                "create_user,create_date,update_user,update_date,isdel) " +
                "values( " +
                "?,?,?,?,?,?,?,current_date ,?,current_date,?) ";

        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1,g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new Date(g.getBirthday().getTime()));
        ptmt.setString(5,g.getEmail());
        ptmt.setString(6,g.getMobile());
        ptmt.setString(7,g.getCreate_user());
        ptmt.setString(8,g.getUpdate_user());
        ptmt.setInt(9,g.getIsdel());

        ptmt.execute();
    }

    public void updateGoddess(Goddess g) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = " " +0
                "update imooc_goddess " +
                "(user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, " +
                "update_user=?,update_date = current_date ,isdel=?) " +
                "where id=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1,g.getUser_name());
        ptmt.setInt(2,g.getSex());
        ptmt.setInt(3,g.getAge());
        ptmt.setDate(4,new Date(g.getBirthday().getTime()));
        ptmt.setString(5,g.getEmail());
        ptmt.setString(7,g.getUpdate_user());        ptmt.setString(6,g.getMobile());

        ptmt.setInt(8,g.getIsdel());
        ptmt.setInt(9,g.getId());
        ptmt.execute();
    }

    public void delGoddess(Integer id) throws SQLException {
        Connection conn = DBUtil.getConnection();
        String sql = " " +
                "delete from imooc_goddess " +
                "where id=? ";

        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1,id);
        ptmt.execute();
    }

    public List<Goddess> query() throws SQLException {
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select user_name,age from imooc_goddess");
        ArrayList<Goddess> gs = new ArrayList<>();
        Goddess g = null;
        while (rs.next()) {
            g = new Goddess();
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            gs.add(g);
        }
        return gs;
    }

    public Goddess get() {
        return null;
    }

}

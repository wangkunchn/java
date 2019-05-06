package com.aa.xx;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class GoddessAction {
    public static void main(String[] args) throws SQLException {
        GoddessDao dao = new GoddessDao();
/*        List<Goddess> gs = dao.query();
        for (Goddess g : gs) {
            System.out.println(g.getUser_name()+g.getAge());
        }*/
        Goddess g1 = new Goddess();
        g1.setUser_name("小霞");
        g1.setAge(22);
        g1.setSex(1);
        g1.setBirthday(new Date());
        g1.setEmail("xiaoxia@163.com");
        g1.setMobile("13899990000");
        g1.setCreate_user("ADMIN");
        g1.setUpdate_user("ADMIN");
        g1.setIsdel(1);
        dao.addGoddess(g1);
    }
}

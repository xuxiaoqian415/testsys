package se.zust.xxq160.service;

import se.zust.xxq160.model.Class;
import se.zust.xxq160.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassesService {
    public ClassesService() {

    }
    public List<Class> searchClasses_t(int tid) {
        List<Class> classes = new ArrayList<>();
        String sql = "SELECT * FROM classes WHERE Tid=" + tid;
        ResultSet rs = DBUtil.select(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("Cid");
                String name = rs.getString("Cname");
                int t_id = rs.getInt("Tid");
                String t_name = rs.getString("teacher_name");
                int stu_num = rs.getInt("stuNum");
                Class c = new Class(id, name, t_id, t_name, stu_num);
                classes.add(c);
            }
        }catch (SQLException e){

        }
        return classes;
    }
    public List<Class> searchClasses_s(int sid) {
        List<Class> classes = new ArrayList<Class>();
        String sql = "SELECT * FROM joinclass JOIN classes ON(joinclass.cid=classes.cid) WHERE Sid=" + sid;
        ResultSet rs = DBUtil.select(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("Cid");
                String name = rs.getString("Cname");
                int t_id = rs.getInt("Tid");
                String t_name = rs.getString("teacher_name");
                int stu_num = rs.getInt("stuNum");
                Class c = new Class(id, name, t_id, t_name, stu_num);
                classes.add(c);
            }
        }catch (SQLException e){

        }
        return classes;
    }
    public String addClass(List<Class> classes, Class cla) {
        String info;
        for (int i = 0; i < classes.size(); i++) {
            Class c = classes.get(i);
            if (c.getId() == cla.getId()) {
                cla.setId();
                i = 0;
            }
        }
        String sql = "INSERT INTO classes values(" + cla.getId() + ",'"
                + cla.getName() + "'," + cla.getT_id() + ",'" + cla.getT_name() + "',0)";
        Integer result = DBUtil.update(sql);
        if(result == null || result == 0) info = "创建失败！";
        else info = "创建成功！班级号是：" + cla.getId();
        return info;
    }
    public String joinClass(int sid, int cid) {
        String info;
        String sql1 = "UPDATE classes SET stuNum=stuNum+1 WHERE Cid=" + cid
                +" AND NOT EXISTS(SELECT * FROM joinclass WHERE Cid=" + cid + " AND Sid=" + sid + ")";
        Integer result1 = DBUtil.update(sql1);
        if(result1 == null || result1 == 0) info = "加入失败！";
        else {
            String sql2 = "INSERT INTO joinclass values(" + sid + "," + cid + ")";
            Integer result2 = DBUtil.update(sql2);
            if(result2 == null || result2 == 0) info = "加入失败！";
            else info = "加入成功！";
        }
        return info;
    }

}

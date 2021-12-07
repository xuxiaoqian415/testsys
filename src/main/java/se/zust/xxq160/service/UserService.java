package se.zust.xxq160.service;

import se.zust.xxq160.model.User;
import se.zust.xxq160.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public UserService(){
        String url="jdbc:mysql://localhost:3306/testsys?characterEncoding=utf-8";
        String userName="root";
        String pwd="12345678";
        DBUtil.openConnection(url,userName,pwd);
    }
    public List<User> allUsers() {
        String sql1 = "SELECT Sid,username FROM students";
        ResultSet rs1 = DBUtil.select(sql1);
        String sql2 = "SELECT Tid,username FROM teachers";
        ResultSet rs2 = DBUtil.select(sql2);
        List<User> users = new ArrayList<>();
        try {
            while (rs1.next()) {
                int id = rs1.getInt("Sid");
                String username = rs1.getString("username");
                User u = new User(username, id);
                users.add(u);
            }
            while (rs2.next()) {
                int id = rs2.getInt("Tid");
                String username = rs2.getString("username");
                User u = new User(username, id);
                users.add(u);
            }
        }catch (SQLException e){

        }
        return users;
    }
    public String checkRegister(List<User> userList, User user) {
        String info = " ";
        Boolean check = false;
        for (User u : userList) {
            if (u.getUsername().equals(user.getUsername()))
                check = true;
        }
        if (check) {
            info = "用户名重复，请重新输入！";
        } else {
            for (int i = 0; i < userList.size(); i++) {
                User u = userList.get(i);
                if (u.getId() == user.getId()) {
                    user.setId();
                    i = 0;
                }
            }
            info = register(user);
        }
        return info;
    }
    public String register(User user) {
        String info;
        int type = user.getUserType();
        String sql;
        if(type == 0) {
            sql = "INSERT INTO students values(" + user.getId() + ",'"
                    + user.getSchool() + "','" + user.getName() + "','" + user.getIdCard() + "','" + user.getUsername()
                    + "','" + user.getPassword() + "','" + user.getPhone() + "','" + user.getEmail() + "'," + user.getUserType() + ")";
        }
        else {
            sql = "INSERT INTO teachers values(" + user.getId() + ",'"
                    + user.getSchool() + "','" + user.getName() + "','" + user.getIdCard() + "','" + user.getUsername()
                    + "','" + user.getPassword() + "','" + user.getPhone() + "','" + user.getEmail() + "'," + user.getUserType() + ")";
        }
        Integer result = DBUtil.update(sql);
        if(result == null || result == 0) info = "注册失败！";
        else info = "注册成功！你的ID是：" + user.getId();
        return info;
    }
    public String login(String username, String psw, int type) {
        String info = " ";
        String sql1 = "SELECT * FROM students WHERE username='" + username + "'";
        ResultSet rs1 = DBUtil.select(sql1);
        String sql2 = "SELECT * FROM teachers WHERE username='" + username + "'";
        ResultSet rs2 = DBUtil.select(sql2);
        String password = "";
        int utype = -1;
        try {
            rs1.last();int row1 = rs1.getRow();rs1.beforeFirst();
            rs2.last();int row2 = rs2.getRow();rs2.beforeFirst();
            if(row1 == 0 && row2 == 0)  return info = "用户名不存在";
            else if(row1 != 0)
                while (rs1.next()) {
                    password = rs1.getString("password");
                    utype = rs1.getInt("type");
                }
            else
                while (rs2.next()) {
                    password = rs2.getString("password");
                    utype = rs2.getInt("type");
                }
        }catch (SQLException e){

        }
        if(psw.equals(password)) {
            if (type != utype) info = "类型不正确";
        }
        else {
            info = "密码不正确";
        }
        return info;
    }
    public List<User> searchUsers(String searchBy, String value, int type) {
        List<User> users = new ArrayList<>();
        String sql;
        if(type == 0)
            sql = "SELECT * FROM students WHERE " + searchBy + "='" + value + "'";
        else
            sql = "SELECT * FROM teachers WHERE " + searchBy + "='" + value + "'";
        ResultSet rs = DBUtil.select(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String school = rs.getString("school");
                String name = rs.getString("name");
                String idCard = rs.getString("idcard");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                int utype = rs.getInt("type");
                User u = new User(school, name, idCard, username, password, phone, email, utype, id);
                users.add(u);
            }
        }catch (SQLException e){

        }
        return users;
    }
    public String searchNameById(int sid) {
        String name = "";
        String sql = "SELECT name FROM students WHERE Sid=" + sid;
        ResultSet rs = DBUtil.select(sql);
        try {
            if(rs.next()) {
                name = rs.getString("name");
            }
        }catch (SQLException e){

        }
        return name;
    }
    public List<User> searchStu(int cid){
        List<User> users = new ArrayList<>();
        String sql="SELECT students.* FROM students,joinclass WHERE students.Sid=joinclass.Sid AND joinclass.Cid="+cid;
        ResultSet rs=DBUtil.select(sql);
        try {
            while (rs.next()){
                int id=rs.getInt("Sid");
                String name=rs.getString("name");
                String phone=rs.getString("phone");
                String email=rs.getString("email");
                User u=new User(name, phone, email, id);
                users.add(u);
            }
        }catch (SQLException e){

        }
        return users;
    }
}

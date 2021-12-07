package se.zust.xxq160.model;

public class Class {
    int id;
    String name;
    int t_id;
    String t_name;
    int stu_num;

    public Class() {
    }

    public Class(String name, int t_id, String t_name, int stu_num) {
        this.name = name;
        this.t_id = t_id;
        this.t_name = t_name;
        this.stu_num = stu_num;
    }

    public Class(int id, String name, int t_id, String t_name, int stu_num) {
        this.id = id;
        this.name = name;
        this.t_id = t_id;
        this.t_name = t_name;
        this.stu_num = stu_num;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        int id = (int)(Math.random() * 9000000 + 1000000);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public int getStu_num() {
        return stu_num;
    }

    public void setStu_num(int stu_num) {
        this.stu_num = stu_num;
    }
}

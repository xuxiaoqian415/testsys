package se.zust.xxq160.model;

public class Test {
    int id;
    String name;
    String start;
    String end;
    int time;
    int t_id;
    int pro_num;
    String t_name;
    String classesId;
    int sub;
    int suball;

    public Test() {
    }

    public Test(String name, String start, String end, int time, int t_id, int pro_num, String t_name, String classesId, int sub, int suball) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.time = time;
        this.t_id = t_id;
        this.pro_num = pro_num;
        this.t_name = t_name;
        this.classesId = classesId;
        this.sub = sub;
        this.suball = suball;
    }

    public Test(int id, String name, String start, String end, int time, int t_id, int pro_num, String t_name, String classesId, int sub, int suball) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
        this.time = time;
        this.t_id = t_id;
        this.pro_num = pro_num;
        this.t_name = t_name;
        this.classesId = classesId;
        this.sub = sub;
        this.suball = suball;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        int id = (int)(Math.random() * 900000000 + 100000000);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getPro_num() {
        return pro_num;
    }

    public void setPro_num(int pro_num) {
        this.pro_num = pro_num;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }

    public int getSub() {
        return sub;
    }

    public void setSub(int sub) {
        this.sub = sub;
    }

    public int getSuball() {
        return suball;
    }

    public void setSuball(int suball) {
        this.suball = suball;
    }
}

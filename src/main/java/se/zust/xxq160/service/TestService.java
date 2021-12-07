package se.zust.xxq160.service;

import se.zust.xxq160.model.Answer;
import se.zust.xxq160.model.Problem;
import se.zust.xxq160.model.Test;
import se.zust.xxq160.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestService {
    public TestService() {

    }
    public List<Test> searchTests_t(int tid) {
        List<Test> tests = new ArrayList<Test>();
        String sql = "SELECT * FROM tests WHERE Tid="+tid;
        ResultSet rs = DBUtil.select(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("Testid");
                String name = rs.getString("testname");
                String stime = rs.getString("start");
                String etime = rs.getString("end");
                int time = rs.getInt("time");
                int t_id = rs.getInt("Tid");
                int pro_num = rs.getInt("proNum");
                String t_name = rs.getString("teachName");
                String classesId = rs.getString("classesId");
                int sub = rs.getInt("sub");
                int suball = rs.getInt("suball");
                Test t = new Test(id, name, stime, etime, time, t_id, pro_num, t_name, classesId, sub, suball);
                tests.add(t);
            }
        }catch (SQLException e){

        }
        return tests;
    }
    public String addTest(List<Test> tests, Test test) {
        String info;
        for (int i = 0; i < tests.size(); i++) {
            Test t = tests.get(i);
            if (t.getId() == test.getId()) {
                t.setId();
                i = 0;
            }
        }
        String sql = "INSERT INTO tests values(" + test.getId() + ",'" + test.getName() + "','" + test.getStart() + "','"
                + test.getEnd() + "'," + test.getTime() + "," + test.getT_id() + ",0,'" + test.getT_name() + "','"
                + test.getClassesId() + "'," + test.getSub() + "," + test.getSuball() + ")";
        Integer result = DBUtil.update(sql);
        if(result == null || result == 0) info = "创建失败！";
        else info = "创建成功！试卷号是：" + test.getId();
        return info;
    }
    public int getSuball(String classesId) {
        int all = 0;
        String cids[] = classesId.split(";");
        String sql = "SELECT DISTINCT stuNum FROM classes WHERE Cid=";
        for(int i=0; i< cids.length; i++) {
            if(i == 0) sql += cids[i];
            else sql += " OR Cid=" + cids[i];
        }
        try {
            ResultSet rs = DBUtil.select(sql);
            if(rs.next()) {
                all += rs.getInt("stuNum");
            }
        }catch (SQLException e){

        }
        return all;
    }
    public void setSuball(int testid, int suball) {
        String sql = "UPDATE tests SET suball=" + suball + " WHERE testid=" + testid;
        DBUtil.update(sql);
    }
    public String addProblem(int order, Problem pro) {
        String info;
        String sql = "INSERT INTO problems values(" + pro.getTestid() + ",'" + pro.getPtype() + "','" + pro.getProblem() + "','"
                + pro.getOptions() + "'," + (order+1) + ",'" + pro.getAnswer() + "'," + pro.getScore() + ")";
        Integer result = DBUtil.update(sql);
        if(result == null || result == 0) info = "添加失败！";
        else {
            info = "添加成功！";
            String sql2 = "UPDATE tests SET proNum=proNum+1 WHERE Testid=" + pro.getTestid();
            Integer result2 = DBUtil.update(sql2);
            if(result2 == null || result2 == 0) info = "试卷题数更新失败！";
        }
        return info;
    }
    public List<Answer> searchAnswers_t(int testId) {
        List<Answer> answers = new ArrayList<Answer>();
        String sql = "SELECT * FROM stuanswer WHERE testid=" + testId;
        ResultSet rs = DBUtil.select(sql);
        try {
            while (rs.next()) {
                int stuid = rs.getInt("stuid");
                int testid = rs.getInt("testid");
                String options = rs.getString("options");
                String answer1 = rs.getString("answer1");
                String answer2 = rs.getString("answer2");
                Float sum1 = rs.getFloat("sum1");
                Float sum2 = rs.getFloat("sum2");
                Float sumall = rs.getFloat("sumall");
                Answer a = new Answer(stuid, testid, options, answer1, answer2, sum1, sum2, sumall);
                answers.add(a);
            }
        }catch (SQLException e){

        }
        return answers;
    }
    public Float getAllScore(int type, int testid) {
        Float score = new Float(0);
        String sql;
        if(type == 0) {//客观
            sql = "SELECT sum(score) as sum FROM problems WHERE Testid=" + testid
                    + " AND (Ptype=0 OR Ptype=1) GROUP BY Testid";
        }
        else {//主观
            sql = "SELECT sum(score) as sum FROM problems WHERE Testid=" + testid
                    + " AND Ptype=2 GROUP BY Testid";
        }
        ResultSet rs = DBUtil.select(sql);
        try {
            if(rs.next()) {
                score = rs.getFloat("sum");
            }
        }catch (SQLException e){

        }
        return score;
    }
    public List<Map<String,Object>> getSubAnswer(int stu_id, int test_id ){
        List<Map<String,Object>> answers = new ArrayList<Map<String,Object>>();
        String sql1 = "SELECT * FROM stuanswer WHERE stuid=" + stu_id + " AND testid="+test_id;
        String sql2 = "SELECT score FROM problems WHERE testid=" + test_id + " AND Ptype=2";
        ResultSet rs1 = DBUtil.select(sql1);
        ResultSet rs2 = DBUtil.select(sql2);
        String ans[] = new String[2];
        Float scores[] = new Float[2];
        try {
            if (rs1.next()) {
                for(int i=0; i<2; i++) {
                    ans[i] = rs1.getString("answer" + (i+1));
                }
            }
            int c=0;
            while(rs2.next()) {
                scores[c] = rs2.getFloat("score");
                c++;
            }
        }catch (SQLException e){

        }
        for(int i=0; i<2; i++) {
            Map<String,Object> subj = new HashMap<String,Object>();
            subj.put("content", ans[i]);
            subj.put("score", scores[i]);
            answers.add(i, subj);
        }
        return answers;
    }
    public String addGrade(int testid, int stuid, float sum2){
        String info = " ";
        String sql1 = "UPDATE stuanswer SET sum2=" + sum2 + " WHERE testid=" + testid + " AND stuid=" + stuid;
        Integer result1 = DBUtil.update(sql1);
        String sql2 = "UPDATE stuanswer SET sumall=sum1+sum2 WHERE testid=" + testid + " AND stuid=" + stuid;
        Integer result2 = DBUtil.update(sql2);
        if(result1 == null || result1 == 0 || result2 == null || result2 == 0) info = "提交失败！";
        else info = "提交成功！";
        return info;
    }
    public float getSumall(int testid, int stuid){
        String sql="SELECT sumall FROM stuanswer WHERE testid=" + testid + " AND stuid=" + stuid;
        ResultSet rs=DBUtil.select(sql);
        float sumall = 0;
        try {
            if (rs.next()) {
                sumall = rs.getFloat("sumall");
            }
        }catch (SQLException e){

        }
        return sumall;
    }
    public List<Test> searchByclassid(String classid){
        String sql="SELECT * FROM tests WHERE classesid like '%"+classid+"%'";
        ResultSet rs=DBUtil.select(sql);
        List<Test> test=new ArrayList<>();
        try {
            while (rs.next()) {
                int id=rs.getInt("Testid");
                String name=rs.getString("testname");
                String start=rs.getString("start");
                String end=rs.getString("end");
                int  time=rs.getInt("time");
                int Tid=rs.getInt("Tid");
                int proNum=rs.getInt("proNum");
                String teachName=rs.getString("teachName");
                int sub=rs.getInt("sub");
                int suball=rs.getInt("suball");
                Test t=new Test( id, name, start, end, time,Tid, proNum, teachName, classid,sub, suball);
                test.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return test;

    }
    public List<Problem> searchProblemBytid(int tid) {
        String sql = "SELECT * FROM problems where Testid="+tid;
        ResultSet rs = DBUtil.select(sql);
        List<Problem> problems = new ArrayList<Problem>();
        try {
            while (rs.next()) {
                Integer testid = rs.getInt("Testid");
                Integer ptype = rs.getInt("Ptype");
                String options = rs.getString("options");
                String problems1 = rs.getString("problem");
                Integer order = rs.getInt("order");
                String answer = rs.getString("answer");
                Float score = rs.getFloat("score");
                Problem p = new Problem(testid,ptype,options,problems1,order,answer,score);
                problems.add(p);
            }
        } catch (SQLException e) {

        }
        return problems;
    }
    public String setObjGrade(int testid, int stuid, float objGrade) {
        String info = " ";
        String sql = "UPDATE stuanswer SET sum1=" + objGrade + " WHERE testid=" + testid + " AND stuid=" + stuid;
        Integer result = DBUtil.update(sql);
        if(result == null || result == 0) info = "提交失败！";
        else info = "提交成功！";
        return info;
    }
    public int getNo(int testid, int stuid) {
        String sql="select stuid,sumall from stuanswer where testid="+testid+" order by testid,sumall desc";
        ResultSet rs=DBUtil.select(sql);
        int no=0;
        try {
            while (rs.next()){
                int sid=rs.getInt("stuid");
                if (sid==stuid){
                    no=rs.getRow();
                    break;
                }
            }
        } catch (SQLException e) {

        }
        return no;
    }
    public void updateNo(int testid, int stuid, int no){
        String sql="UPDATE stuanswer SET rank=" + no + " WHERE stuid=" + stuid + " AND testid=" + testid;
        DBUtil.update(sql);
    }
    public List<Answer> showNo(int sid) {
        String sql="SELECT tests.testname,rank,sumall FROM tests,stuanswer where tests.Testid=stuanswer.testid AND stuanswer.stuid="+sid;
        ResultSet rs=DBUtil.select(sql);
        List<Answer> answers=new ArrayList<>();
        try {
            while (rs.next()){
                String testname=rs.getString("tests.testname");
                int no=rs.getInt("rank");
                Float sumall=rs.getFloat("sumall");
                Answer answer=new Answer(testname,no,sumall);
                answers.add(answer);
            }
        } catch (SQLException e) {

        }
        return answers;
    }
    public String addStuAns(int testid, int stuid) {
        String info = "";
        String sql = "INSERT INTO stuanswer values(" + stuid + "," + testid + ",'','','',0,0,0,0)";
        Integer result = DBUtil.update(sql);
        if(result == null || result == 0) info = "学生数据插入失败！";
        else info = "提交成功！";
        return info;
    }
    public String updateOptions(int testid, int stuid, String objAnswers){
        String info = "";
        String sql="update stuanswer set options='" + objAnswers + "' where Testid='" + testid + "' and stuid=" + stuid;
        Integer result = DBUtil.update(sql);
        if(result == null || result == 0) info = "选择题提交失败！";
        else info = "提交成功！";
        return info;
    }
    public String updateSubjAns(int testid, int stuid, String[] subjAns) {
        String info = "";
        int l = subjAns.length;
        Integer result = 0;
        for(int i=0; i<l; i++) {
            String sql="update stuanswer set answer" + (i+1) + "='" + subjAns[i] + "' where Testid='" + testid + "' and stuid=" + stuid;
            result = DBUtil.update(sql);
        }
        if(result == null || result == 0) info = "主观题提交失败！";
        else info = "提交成功！";
        return info;
    }
    public int getTime(int testid) {
        int time = 0;
        String sql = "SELECT time FROM tests WHERE Testid=" + testid;
        ResultSet rs = DBUtil.select(sql);
        try {
            if(rs.next())
                time = rs.getInt("time");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return time;
    }
    public String getClassesId(int testid) {
        String classesId = "";
        String sql = "SELECT classesid FROM tests WHERE testid=" + testid;
        ResultSet rs = DBUtil.select(sql);
        try {
            if(rs.next())
                classesId = rs.getString("classesId");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classesId;
    }
    public Boolean ifCompleted(int stuid, int testid) {
        Boolean fl = false;
        String sql = "SELECT * FROM stuanswer WHERE testid=" + testid + " AND stuid=" + stuid;
        ResultSet rs = DBUtil.select(sql);
        try {
            if(rs.next()) fl = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return fl;
    }
    public void setSub(int testid) {
        String sql = "UPDATE tests SET sub=sub+1 WHERE testid=" + testid;
        DBUtil.update(sql);
    }
}

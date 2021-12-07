package se.zust.xxq160.model;

public class Answer {
    private int stuid;
    private int testid;
    private String options;
    private String[] ops;
    private String answer1;
    private String answer2;
    private Float sum1;
    private Float sum2;
    private Float sumall;
    private String stuname;
    private Float objAllScore;
    private Float subjAllScore;
    private String testname;
    private int no;

    public Answer(){
    }

    public Answer(String testname,int no,Float sumall){
        this.testname=testname;
        this.no=no;
        this.sumall=sumall;
    }

    public Answer(int stuid, int testid, String options, String answer1, String answer2, Float sum1, Float sum2, Float sumall) {
        this.stuid = stuid;
        this.testid = testid;
        this.options = options;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.sum1 = sum1;
        this.sum2 = sum2;
        this.sumall = sumall;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String[] getOps() {
        return ops;
    }

    public void setOps(String[] ops) {
        this.ops = ops;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public Float getSum1() {
        return sum1;
    }

    public void setSum1(Float sum1) {
        this.sum1 = sum1;
    }

    public Float getSum2() {
        return sum2;
    }

    public void setSum2(Float sum2) {
        this.sum2 = sum2;
    }

    public Float getSumall() {
        return sumall;
    }

    public void setSumall(Float sumall) {
        this.sumall = sumall;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Float getObjAllScore() {
        return objAllScore;
    }

    public void setObjAllScore(Float objAllScore) {
        this.objAllScore = objAllScore;
    }

    public Float getSubjAllScore() {
        return subjAllScore;
    }

    public void setSubjAllScore(Float subjAllScore) {
        this.subjAllScore = subjAllScore;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}

package se.zust.xxq160.model;

public class Problem {
    private Integer Testid;
    private int Ptype;
    private String options;
    private String[] ops;
    private String problem;
    private Integer order;
    private String answer;
    private Float score;
    public Problem() {

    }

    public Problem(Integer Testid, int Ptype, String options, String problem, Integer order, String answer, Float score) {
        this.Testid = Testid;
        this.Ptype = Ptype;
        this.options = options;
        this.problem = problem;
        this.order = order;
        this.answer = answer;
        this.score = score;
    }

    public Integer getTestid() {
        return Testid;
    }

    public void setTestid(Integer testid) {
        Testid = testid;
    }

    public int getPtype() {
        return Ptype;
    }

    public void setPtype(int ptype) {
        Ptype = ptype;
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

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}

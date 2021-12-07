package se.zust.xxq160.model;

public class User {
    private String school;
    private String name;
    private String idCard;
    private String username;
    private String password;
    private String phone;
    private String email;
    private int userType;
    private int id;
    private int number;//学号
    private String admClass;//行政班

    public User() {
    }

    public User(String username, int id) {
        this.username = username;
        this.id = id;
    }

    public User(String name, String phone, String email, int id) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.id = id;
    }

    public User(String school, String name, String idCard, String username, String password, String phone, String email, int userType) {
        this.school = school;
        this.name = name;
        this.idCard = idCard;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.userType = userType;
    }

    public User(String school, String name, String idCard, String username, String password, String phone, String email, int userType, int id) {
        this.school = school;
        this.name = name;
        this.idCard = idCard;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.userType = userType;
        this.id = id;
    }

    public void setId() {
        int id = (int)(Math.random() * 90000000 + 10000000);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAdmClass() {
        return admClass;
    }

    public void setAdmClass(String admClass) {
        this.admClass = admClass;
    }
}


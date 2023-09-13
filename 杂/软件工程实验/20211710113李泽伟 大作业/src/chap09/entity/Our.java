package chap09.entity;

public class Our {

    @Override
    public String toString() {
        return "Our{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", truename='" + truename + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", postalcode='" + postalcode + '\'' +
                '}';
    }



    public Our(int id, String username, String department, String truename, String email, String phone, String postalcode) {
        this.id = id;
        this.username = username;
        this.department = department;
        this.truename = truename;
        this.email = email;
        this.phone = phone;
        this.postalcode = postalcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    private int id;
    private String username;
    private String department;
    private String truename;
    private String email;
    private String phone;
    private String postalcode;




}

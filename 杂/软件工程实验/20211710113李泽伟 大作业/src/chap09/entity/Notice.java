package chap09.entity;

import java.util.Date;

public class Notice {
    public Notice(int noticeid, String noticetopic, Date noticetime, String noticecontent) {
        this.noticeid = noticeid;
        this.noticetopic= noticetopic;
        this.noticetime = noticetime;
        this.noticecontent = noticecontent;
    }

    public int getNoticeid() {
        return noticeid;
    }


    public void setNoticeid(int noticeid) {
        this.noticeid = noticeid;
    }

    public String getNoticetopic() {
        return noticetopic;
    }

    public void setNoticetopic(String noticetopic) {
        this.noticetopic = noticetopic;
    }

    public Date getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(Date noticetime) {
        this.noticetime = noticetime;
    }

    public String getNoticecontent() {
        return noticecontent;
    }

    public void setNoticecontent(String noticecontent) {
        this.noticecontent = noticecontent;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "notice=" + noticeid +
                ", noticetopic='" + noticetopic + '\'' +
                ", noticetime=" + noticetime +
                ", noticecontent='" + noticecontent + '\'' +
                '}';
    }

    private int noticeid;
    private String noticetopic;
    private Date noticetime;
    private String noticecontent;
}

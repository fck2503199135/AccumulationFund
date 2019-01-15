package com.bean;

public class Credit {
    private int cid;
    private String cdate;
    private String index;
    private String cname;
    private String cnum;
    private String reason;
    private String style;
    private String img;



    public String getImg() {
        return img;
    }

    public Credit(String cname, String cnum, String reason, String style, String img) {
        this.cname = cname;
        this.cnum = cnum;
        this.reason = reason;
        this.style = style;
        this.img = img;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "cid=" + cid +
                ", cdate='" + cdate + '\'' +
                ", index='" + index + '\'' +
                ", cname='" + cname + '\'' +
                ", cnum='" + cnum + '\'' +
                ", reason='" + reason + '\'' +
                ", style='" + style + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}

package com.bean;

public class Credit {
    private int cid;
    private String cdate;
    private String index;
    private String uname;
    private String cname;
    private String cnum;
    private String reason;
    private String style;
    private String img;
    private String deld;
    private String goby;
    private String wname;
    private String wnum;
    private String mymit;
    private String thmit;
    private String count;



    public Credit() {

    }

    public Credit(int cid, String deld, String goby) {
        this.cid = cid;
        this.deld = deld;
        this.goby = goby;
    }


    public Credit(String cdate, String index,String uname,String mymit, String cname, String cnum,String thmit,String wname, String wnum, String reason, String style, String img) {
        this.cdate = cdate;
        this.index = index;
        this.mymit = mymit;
        this.thmit = thmit;
        this.cname = cname;
        this.cnum = cnum;
        this.wname = wname;
        this.wnum = wnum;
        this.reason = reason;
        this.style = style;
        this.img = img;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getMymit() {
        return mymit;
    }

    public void setMymit(String mymit) {
        this.mymit = mymit;
    }

    public String getThmit() {
        return thmit;
    }

    public void setThmit(String thmit) {
        this.thmit = thmit;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWnum() {
        return wnum;
    }

    public void setWnum(String wnum) {
        this.wnum = wnum;
    }

    public String getDeld() {
        return deld;
    }

    public void setDeld(String deld) {
        this.deld = deld;
    }

    public String getGoby() {
        return goby;
    }

    public void setGoby(String goby) {
        this.goby = goby;
    }

    public String getImg() {
        return img;
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
                ", uname='" + uname + '\'' +
                ", cname='" + cname + '\'' +
                ", cnum='" + cnum + '\'' +
                ", reason='" + reason + '\'' +
                ", style='" + style + '\'' +
                ", img='" + img + '\'' +
                ", deld='" + deld + '\'' +
                ", goby='" + goby + '\'' +
                ", wname='" + wname + '\'' +
                ", wnum='" + wnum + '\'' +
                ", mymit='" + mymit + '\'' +
                ", thmit='" + thmit + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}

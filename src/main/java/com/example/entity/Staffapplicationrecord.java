package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工申请记录表
 * @TableName staffapplicationrecord
 */
@TableName(value ="staffapplicationrecord")
public class Staffapplicationrecord implements Serializable {
    /**
     * 员工申请表ID
     */
    @TableId(type = IdType.AUTO)
    private Long sarid;

    /**
     * 申请时间
     */
    private Date sartime;

    /**
     * 申请员工ID
     */
    private Long sarstaffid;

    /**
     * 是否通过
     */
    private String sarpass;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 员工申请表ID
     */
    public Long getSarid() {
        return sarid;
    }

    /**
     * 员工申请表ID
     */
    public void setSarid(Long sarid) {
        this.sarid = sarid;
    }

    /**
     * 申请时间
     */
    public Date getSartime() {
        return sartime;
    }

    /**
     * 申请时间
     */
    public void setSartime(Date sartime) {
        this.sartime = sartime;
    }

    /**
     * 申请员工ID
     */
    public Long getSarstaffid() {
        return sarstaffid;
    }

    /**
     * 申请员工ID
     */
    public void setSarstaffid(Long sarstaffid) {
        this.sarstaffid = sarstaffid;
    }

    /**
     * 是否通过
     */
    public String getSarpass() {
        return sarpass;
    }

    /**
     * 是否通过
     */
    public void setSarpass(String sarpass) {
        this.sarpass = sarpass;
    }

    /*
        构建器
     */
    public Staffapplicationrecord(long sarid, Date sartime, long sarstaffid, String sarpass) {
        this.sarid = sarid;
        this.sartime = sartime;
        this.sarstaffid = sarstaffid;
        this.sarpass = sarpass;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Staffapplicationrecord other = (Staffapplicationrecord) that;
        return (this.getSarid() == null ? other.getSarid() == null : this.getSarid().equals(other.getSarid()))
            && (this.getSartime() == null ? other.getSartime() == null : this.getSartime().equals(other.getSartime()))
            && (this.getSarstaffid() == null ? other.getSarstaffid() == null : this.getSarstaffid().equals(other.getSarstaffid()))
            && (this.getSarpass() == null ? other.getSarpass() == null : this.getSarpass().equals(other.getSarpass()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSarid() == null) ? 0 : getSarid().hashCode());
        result = prime * result + ((getSartime() == null) ? 0 : getSartime().hashCode());
        result = prime * result + ((getSarstaffid() == null) ? 0 : getSarstaffid().hashCode());
        result = prime * result + ((getSarpass() == null) ? 0 : getSarpass().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sarid=").append(sarid);
        sb.append(", sartime=").append(sartime);
        sb.append(", sarstaffid=").append(sarstaffid);
        sb.append(", sarpass=").append(sarpass);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
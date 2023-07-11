package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 银行账户
 * @TableName account
 */
@TableName(value ="account")
@Data
public class Account implements Serializable {
    /**
     * 账户ID
     */
    @TableId(type = IdType.AUTO)
    private Long aid;

    /**
     * 银行卡号
     */
    private String abankcard;

    /**
     * 余额
     */
    private BigDecimal abalance;

    /**
     * 最近更新时间
     */
    private Date alastupdate;
    public Account(){
    }

    public Account(long aid,String abankcard,BigDecimal abalance){
        this.aid=aid;
        this.abankcard=abankcard;
        this.abalance=abalance;
        this.alastupdate=new Date();
    }


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
        Account other = (Account) that;
        return (this.getAid() == null ? other.getAid() == null : this.getAid().equals(other.getAid()))
            && (this.getAbankcard() == null ? other.getAbankcard() == null : this.getAbankcard().equals(other.getAbankcard()))
            && (this.getAbalance() == null ? other.getAbalance() == null : this.getAbalance().equals(other.getAbalance()))
            && (this.getAlastupdate() == null ? other.getAlastupdate() == null : this.getAlastupdate().equals(other.getAlastupdate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAid() == null) ? 0 : getAid().hashCode());
        result = prime * result + ((getAbankcard() == null) ? 0 : getAbankcard().hashCode());
        result = prime * result + ((getAbalance() == null) ? 0 : getAbalance().hashCode());
        result = prime * result + ((getAlastupdate() == null) ? 0 : getAlastupdate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aid=").append(aid);
        sb.append(", abankcard=").append(abankcard);
        sb.append(", abalance=").append(abalance);
        sb.append(", alastupdate=").append(alastupdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
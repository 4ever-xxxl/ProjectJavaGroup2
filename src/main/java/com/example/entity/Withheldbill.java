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
 * 残保金代扣账目表
 * @TableName withheldbill
 */
@TableName(value ="withheldbill")
@Data
public class Withheldbill implements Serializable {
    /**
     * 代扣账单ID
     */
    @TableId(type = IdType.AUTO)
    private Long wbid;

    /**
     * 部门ID
     */
    private Long wbfinancialid;

    /**
     * 账户ID
     */
    private Long wbaccountid;

    /**
     * 代扣金额
     */
    private BigDecimal wbamount;

    /**
     * 代扣时间
     */
    private Date wbtime;

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
        Withheldbill other = (Withheldbill) that;
        return (this.getWbid() == null ? other.getWbid() == null : this.getWbid().equals(other.getWbid()))
            && (this.getWbfinancialid() == null ? other.getWbfinancialid() == null : this.getWbfinancialid().equals(other.getWbfinancialid()))
            && (this.getWbaccountid() == null ? other.getWbaccountid() == null : this.getWbaccountid().equals(other.getWbaccountid()))
            && (this.getWbamount() == null ? other.getWbamount() == null : this.getWbamount().equals(other.getWbamount()))
            && (this.getWbtime() == null ? other.getWbtime() == null : this.getWbtime().equals(other.getWbtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWbid() == null) ? 0 : getWbid().hashCode());
        result = prime * result + ((getWbfinancialid() == null) ? 0 : getWbfinancialid().hashCode());
        result = prime * result + ((getWbaccountid() == null) ? 0 : getWbaccountid().hashCode());
        result = prime * result + ((getWbamount() == null) ? 0 : getWbamount().hashCode());
        result = prime * result + ((getWbtime() == null) ? 0 : getWbtime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wbid=").append(wbid);
        sb.append(", wbfinancialid=").append(wbfinancialid);
        sb.append(", wbaccountid=").append(wbaccountid);
        sb.append(", wbamount=").append(wbamount);
        sb.append(", wbtime=").append(wbtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
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
 * 残保金代收账目表
 * @TableName collectbill
 */
@TableName(value ="collectbill")
@Data
public class CollectBill implements Serializable {
    /**
     * 代收单号ID
     */
    @TableId(type = IdType.AUTO)
    private Long cbid;

    /**
     * 账户ID
     */
    private Long cbaccountid;

    /**
     * 公司ID
     */
    private Long cbcompanyid;

    /**
     * 应缴金额
     */
    private BigDecimal cbdue;

    /**
     * 减免金额
     */
    private BigDecimal cbrelief;

    /**
     * 应缴日期
     */
    private Date cbduedate;

    /**
     * 缓缴日期
     */
    private Date cbdelaydate;

    /**
     * 是否结单
     */
    private String cbstatement;

    /**
     * 结单时间
     */

    private Date cbstatetime;

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
        CollectBill other = (CollectBill) that;
        return (this.getCbid() == null ? other.getCbid() == null : this.getCbid().equals(other.getCbid()))
            && (this.getCbaccountid() == null ? other.getCbaccountid() == null : this.getCbaccountid().equals(other.getCbaccountid()))
            && (this.getCbcompanyid() == null ? other.getCbcompanyid() == null : this.getCbcompanyid().equals(other.getCbcompanyid()))
            && (this.getCbdue() == null ? other.getCbdue() == null : this.getCbdue().equals(other.getCbdue()))
            && (this.getCbrelief() == null ? other.getCbrelief() == null : this.getCbrelief().equals(other.getCbrelief()))
            && (this.getCbduedate() == null ? other.getCbduedate() == null : this.getCbduedate().equals(other.getCbduedate()))
            && (this.getCbdelaydate() == null ? other.getCbdelaydate() == null : this.getCbdelaydate().equals(other.getCbdelaydate()))
            && (this.getCbstatement() == null ? other.getCbstatement() == null : this.getCbstatement().equals(other.getCbstatement()))
            && (this.getCbstatetime() == null ? other.getCbstatetime() == null : this.getCbstatetime().equals(other.getCbstatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCbid() == null) ? 0 : getCbid().hashCode());
        result = prime * result + ((getCbaccountid() == null) ? 0 : getCbaccountid().hashCode());
        result = prime * result + ((getCbcompanyid() == null) ? 0 : getCbcompanyid().hashCode());
        result = prime * result + ((getCbdue() == null) ? 0 : getCbdue().hashCode());
        result = prime * result + ((getCbrelief() == null) ? 0 : getCbrelief().hashCode());
        result = prime * result + ((getCbduedate() == null) ? 0 : getCbduedate().hashCode());
        result = prime * result + ((getCbdelaydate() == null) ? 0 : getCbdelaydate().hashCode());
        result = prime * result + ((getCbstatement() == null) ? 0 : getCbstatement().hashCode());
        result = prime * result + ((getCbstatetime() == null) ? 0 : getCbstatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cbid=").append(cbid);
        sb.append(", cbaccountid=").append(cbaccountid);
        sb.append(", cbcompanyid=").append(cbcompanyid);
        sb.append(", cbdue=").append(cbdue);
        sb.append(", cbrelief=").append(cbrelief);
        sb.append(", cbduedate=").append(cbduedate);
        sb.append(", cbdelaydate=").append(cbdelaydate);
        sb.append(", cbstatement=").append(cbstatement);
        sb.append(", cbstatetime=").append(cbstatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
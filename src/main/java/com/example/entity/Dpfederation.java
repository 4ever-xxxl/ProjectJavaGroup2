package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 残联
 * @TableName dpfederation
 */
@TableName(value ="dpfederation")
public class Dpfederation implements Serializable {
    /**
     * 残联ID
     */
    @TableId(type = IdType.AUTO)
    private Long dpfid;

    /**
     * 所属地区
     */
    private String dpfregion;

    /**
     * 上级残联ID
     */
    private Long dpfparentid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 残联ID
     */
    public Long getDpfid() {
        return dpfid;
    }

    /**
     * 残联ID
     */
    public void setDpfid(Long dpfid) {
        this.dpfid = dpfid;
    }

    /**
     * 所属地区
     */
    public String getDpfregion() {
        return dpfregion;
    }

    /**
     * 所属地区
     */
    public void setDpfregion(String dpfregion) {
        this.dpfregion = dpfregion;
    }

    /**
     * 上级残联ID
     */
    public Long getDpfparentid() {
        return dpfparentid;
    }

    /**
     * 上级残联ID
     */
    public void setDpfparentid(Long dpfparentid) {
        this.dpfparentid = dpfparentid;
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
        Dpfederation other = (Dpfederation) that;
        return (this.getDpfid() == null ? other.getDpfid() == null : this.getDpfid().equals(other.getDpfid()))
            && (this.getDpfregion() == null ? other.getDpfregion() == null : this.getDpfregion().equals(other.getDpfregion()))
            && (this.getDpfparentid() == null ? other.getDpfparentid() == null : this.getDpfparentid().equals(other.getDpfparentid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDpfid() == null) ? 0 : getDpfid().hashCode());
        result = prime * result + ((getDpfregion() == null) ? 0 : getDpfregion().hashCode());
        result = prime * result + ((getDpfparentid() == null) ? 0 : getDpfparentid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dpfid=").append(dpfid);
        sb.append(", dpfregion=").append(dpfregion);
        sb.append(", dpfparentid=").append(dpfparentid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
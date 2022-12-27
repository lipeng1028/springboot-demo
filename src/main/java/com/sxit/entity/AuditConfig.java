package com.sxit.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author lipeng
 * @since 2020-06-23
 */
@TableName("PGC_AUDIT_CONFIG")
@KeySequence(value = "SEQ_PGC_AUDIT_CONFIG", clazz = BigDecimal.class)
public class AuditConfig implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value = "ID", type = IdType.INPUT)
    private BigDecimal id;
    /**
     * 地市编码
     */
    @TableField("CITY_NO")
    private String cityNo;
    /**
     * 地市名称
     */
    @TableField("CITY_NAME")
    private String cityName;
    /**
     * 审核人姓名
     */
    @TableField("AUDIT_NAME")
    private String auditName;
    /**
     * 部门
     */
    @TableField("DEPARTMENT")
    private String department;
    /**
     * 职位
     */
    @TableField("POSITION")
    private String position;
    /**
     * 审核人手机号
     */
    @TableField("SERVICE_NUM")
    private String serviceNum;
    /**
     * 审核人等级 1：一级，2：二级(可修改一级信息）
     */
    @TableField("AUDIT_LEVEL")
    private String auditLevel;
    /**
     * 操作人
     */
    @TableField("SAVE_ID")
    private String saveId;
    /**
     * 操作时间
     */
    @TableField("SAVE_TIME")
	private Timestamp saveTime;
    /**
     * 审核范围 0：无，1：订单明细审核，2：退费审核，3：报表审核
     */
    @TableField("AUDIT_SCOPE")
    private String auditScope;
    /**
     * 修改人
     */
    @TableField("UPD_ID")
    private String updId;
    /**
     * 修改时间
     */
    @TableField("UPD_TIME")
    private Timestamp updTime;
    /**
     * 逻辑删除，空值不删除，1：逻辑删除
     */
    @TableField("LOGIC_DELETE")
    private String logicDelete;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getCityNo() {
		return cityNo;
	}

	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAuditName() {
		return auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getServiceNum() {
		return serviceNum;
	}

	public void setServiceNum(String serviceNum) {
		this.serviceNum = serviceNum;
	}

	public String getAuditLevel() {
		return auditLevel;
	}

	public void setAuditLevel(String auditLevel) {
		this.auditLevel = auditLevel;
	}

	public String getSaveId() {
		return saveId;
	}

	public void setSaveId(String saveId) {
		this.saveId = saveId;
	}

	public Timestamp getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(Timestamp saveTime) {
		this.saveTime = saveTime;
	}

	public String getAuditScope() {
		return auditScope;
	}

	public void setAuditScope(String auditScope) {
		this.auditScope = auditScope;
	}

	public String getUpdId() {
		return updId;
	}

	public void setUpdId(String updId) {
		this.updId = updId;
	}

	public Timestamp getUpdTime() {
		return updTime;
	}

	public void setUpdTime(Timestamp updTime) {
		this.updTime = updTime;
	}

	public String getLogicDelete() {
		return logicDelete;
	}

	public void setLogicDelete(String logicDelete) {
		this.logicDelete = logicDelete;
	}

	@Override
	public String toString() {
		return "AuditConfig [id=" + id + ", cityNo=" + cityNo + ", cityName=" + cityName + ", auditName=" + auditName
				+ ", department=" + department + ", position=" + position + ", serviceNum=" + serviceNum
				+ ", auditLevel=" + auditLevel + ", saveId=" + saveId + ", saveTime=" + saveTime + ", auditScope="
				+ auditScope + ", updId=" + updId + ", updTime=" + updTime + ", logicDelete=" + logicDelete + "]";
	}

}

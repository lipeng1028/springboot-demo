package com.sxit.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * <p>
 * 农村组合套餐表
 * </p>
 *
 * @author lipeng
 * @since 2020-06-23
 */
@TableName("T_NUMCARD_COUNTRY")
@KeySequence(value = "SEQ_T_NUMCARD_COUNTRY", clazz = Long.class)
public class TNumcardCountry extends Model<TNumcardCountry> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 乡村表
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private Long id;
    /**
     * 地市编码
     */
    @TableField("CITY_NO")
    private String cityNo;
    /**
     * 乡村编码
     */
    @TableField("COUNTRY_ID")
    private String countryId;
    /**
     * 乡村名称(网格名称)
     */
    @TableField("COUNTRY_NAME")
    private String countryName;
    /**
     * 创建人
     */
    @TableField("IMPORT_USER")
    private String importUser;
    @TableField("IMPORT_DATE")
    private Timestamp importDate;
    /**
     * 修改人
     */
    @TableField("UPD_USER")
    private String updUser;
    @TableField("UPD_DATE")
    private Timestamp updDate;
    /**
     * 地市名称
     */
    @TableField("CITY_NAME")
    private String cityName;
    /**
     * 县域流量分区编码
     */
    @TableField("FLOW_ZONE_CODE")
    private String flowZoneCode;
    /**
     * 县域流量分区名称
     */
    @TableField("FLOW_ZONE_NAME")
    private String flowZoneName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCityNo() {
		return cityNo;
	}

	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getImportUser() {
		return importUser;
	}

	public void setImportUser(String importUser) {
		this.importUser = importUser;
	}

	public Timestamp getImportDate() {
		return importDate;
	}

	public void setImportDate(Timestamp importDate) {
		this.importDate = importDate;
	}

	public String getUpdUser() {
		return updUser;
	}

	public void setUpdUser(String updUser) {
		this.updUser = updUser;
	}

	public Timestamp getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Timestamp updDate) {
		this.updDate = updDate;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getFlowZoneCode() {
		return flowZoneCode;
	}

	public void setFlowZoneCode(String flowZoneCode) {
		this.flowZoneCode = flowZoneCode;
	}

	public String getFlowZoneName() {
		return flowZoneName;
	}

	public void setFlowZoneName(String flowZoneName) {
		this.flowZoneName = flowZoneName;
	}

	@Override
	public String toString() {
		return "TNumcardCountry [id=" + id + ", cityNo=" + cityNo + ", countryId=" + countryId + ", countryName="
				+ countryName + ", importUser=" + importUser + ", importDate=" + importDate + ", updUser=" + updUser
				+ ", updDate=" + updDate + ", cityName=" + cityName + ", flowZoneCode=" + flowZoneCode
				+ ", flowZoneName=" + flowZoneName + "]";
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}

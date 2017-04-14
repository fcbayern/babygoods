package cn.babygoods.dao.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ctrip.platform.dal.dao.annotation.Database;
import com.ctrip.platform.dal.dao.annotation.Type;
import java.sql.Types;
import java.sql.Timestamp;

import com.ctrip.platform.dal.dao.DalPojo;

@Entity
@Database(name="babygoods")
@Table(name="user")
public class BabygoodsUser implements DalPojo {

	@Id
	@Column(name="user_id")
	@Type(value=Types.BIGINT)
	private Long userId;

	@Column(name="wechat_openid")
	@Type(value=Types.VARCHAR)
	private String wechatOpenid;

	@Column(name="user_mobile")
	@Type(value=Types.VARCHAR)
	private String userMobile;

	@Column(name="user_password")
	@Type(value=Types.VARCHAR)
	private String userPassword;

	@Column(name="user_nickname")
	@Type(value=Types.VARCHAR)
	private String userNickname;

	@Column(name="verify_status")
	@Type(value=Types.VARCHAR)
	private String verifyStatus;

	@Column(name="datacreate_lasttime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp datacreateLasttime;

	@Column(name="datachange_lasttime", insertable=false, updatable=false)
	@Type(value=Types.TIMESTAMP)
	private Timestamp datachangeLasttime;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getWechatOpenid() {
		return wechatOpenid;
	}

	public void setWechatOpenid(String wechatOpenid) {
		this.wechatOpenid = wechatOpenid;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getVerifyStatus() {
		return verifyStatus;
	}

	public void setVerifyStatus(String verifyStatus) {
		this.verifyStatus = verifyStatus;
	}

	public Timestamp getDatacreateLasttime() {
		return datacreateLasttime;
	}

	public void setDatacreateLasttime(Timestamp datacreateLasttime) {
		this.datacreateLasttime = datacreateLasttime;
	}

	public Timestamp getDatachangeLasttime() {
		return datachangeLasttime;
	}

	public void setDatachangeLasttime(Timestamp datachangeLasttime) {
		this.datachangeLasttime = datachangeLasttime;
	}

}
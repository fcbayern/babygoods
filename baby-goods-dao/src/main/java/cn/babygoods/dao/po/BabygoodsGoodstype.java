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
@Table(name="babygoods_goodstype")
public class BabygoodsGoodstype implements DalPojo {

	@Id
	@Column(name="goodstype_id")
	@Type(value=Types.INTEGER)
	private Integer goodstypeId;

	@Column(name="upper_goodstypeid")
	@Type(value=Types.INTEGER)
	private Integer upperGoodstypeid;

	@Column(name="goodstype_name")
	@Type(value=Types.VARCHAR)
	private String goodstypeName;

	@Column(name="goodstype_seq")
	@Type(value=Types.INTEGER)
	private Integer goodstypeSeq;

	@Column(name="datachange_lasttime", insertable=false, updatable=false)
	@Type(value=Types.TIMESTAMP)
	private Timestamp datachangeLasttime;

	public Integer getGoodstypeId() {
		return goodstypeId;
	}

	public void setGoodstypeId(Integer goodstypeId) {
		this.goodstypeId = goodstypeId;
	}

	public Integer getUpperGoodstypeid() {
		return upperGoodstypeid;
	}

	public void setUpperGoodstypeid(Integer upperGoodstypeid) {
		this.upperGoodstypeid = upperGoodstypeid;
	}

	public String getGoodstypeName() {
		return goodstypeName;
	}

	public void setGoodstypeName(String goodstypeName) {
		this.goodstypeName = goodstypeName;
	}

	public Integer getGoodstypeSeq() {
		return goodstypeSeq;
	}

	public void setGoodstypeSeq(Integer goodstypeSeq) {
		this.goodstypeSeq = goodstypeSeq;
	}

	public Timestamp getDatachangeLasttime() {
		return datachangeLasttime;
	}

	public void setDatachangeLasttime(Timestamp datachangeLasttime) {
		this.datachangeLasttime = datachangeLasttime;
	}

}
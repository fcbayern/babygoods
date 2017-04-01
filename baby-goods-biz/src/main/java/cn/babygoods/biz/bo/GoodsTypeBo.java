package cn.babygoods.biz.bo;

/**
 * Created by Vincent on 2017/3/30.
 */
public class GoodsTypeBo {
    private Integer goodstypeId;
    private Integer upperGoodstypeid;
    private String goodstypeName;
    private Integer goodstypeSeq;

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
}

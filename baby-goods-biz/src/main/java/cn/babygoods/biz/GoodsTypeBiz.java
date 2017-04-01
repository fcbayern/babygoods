package cn.babygoods.biz;

import cn.babygoods.biz.bo.GoodsTypeBo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Vincent on 2017/3/30.
 */
public interface GoodsTypeBiz {
    List<GoodsTypeBo> getGoodsType() throws SQLException;

    boolean saveGoodsType(GoodsTypeBo goodsTypeBo) throws SQLException;
}

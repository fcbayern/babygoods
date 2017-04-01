package cn.babygoods.biz;

import cn.babygoods.biz.bo.GoodsTypeBo;
import cn.babygoods.common.BeanUtil;
import cn.babygoods.dao.BabygoodsGoodstypeDao;
import cn.babygoods.dao.po.BabygoodsGoodstype;
import com.ctrip.platform.dal.dao.DalHints;
import com.ctrip.platform.dal.dao.KeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Vincent on 2017/3/30.
 */
@Service
public class GoodsTypeBizImpl implements GoodsTypeBiz {
    @Autowired
    BabygoodsGoodstypeDao babygoodsGoodstypeDao;

    @Override
    public List<GoodsTypeBo> getGoodsType() throws SQLException {
        List<BabygoodsGoodstype> babygoodsGoodstypeList = babygoodsGoodstypeDao.queryAll(new DalHints());
        return BeanUtil.copyProperties(babygoodsGoodstypeList, GoodsTypeBo.class);
    }

    @Override
    public boolean saveGoodsType(GoodsTypeBo goodsTypeBo) throws SQLException {
        BabygoodsGoodstype babygoodsGoodstype = BeanUtil.copyProperties(goodsTypeBo, BabygoodsGoodstype.class);
        if (goodsTypeBo.getGoodstypeId() > 0) {
            babygoodsGoodstype.setDatachangeLasttime(new Timestamp(new Date().getTime()));
            babygoodsGoodstypeDao.update(new DalHints(), babygoodsGoodstype);
            return true;
        } else {
            babygoodsGoodstype.setDatachangeLasttime(new Timestamp(new Date().getTime()));
            KeyHolder keyHolder = new KeyHolder();
            babygoodsGoodstypeDao.insert(new DalHints(), keyHolder, babygoodsGoodstype);
            return (Integer) keyHolder.getKey()>0;
        }
    }
}

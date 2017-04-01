package cn.babygoods.dao;

import cn.babygoods.dao.po.BabygoodsGoodstype;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by jj_zhu on 2017-03-15.
 */
@Repository
public class BabygoodsGoodstypeDaoImpl extends BaseDaoImpl<BabygoodsGoodstype> implements BabygoodsGoodstypeDao {
    public BabygoodsGoodstypeDaoImpl() throws SQLException {
        super(BabygoodsGoodstype.class);
    }
}

package cn.babygoods.dao;

import cn.babygoods.dao.po.BabygoodsUser;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

/**
 * Created by jj_zhu on 2017-03-15.
 */
@Repository
public class BabygoodsUserDaoImpl extends BaseDaoImpl<BabygoodsUser> implements BabygoodsUserDao {
    public BabygoodsUserDaoImpl() throws SQLException {
        super(BabygoodsUser.class);
    }
}

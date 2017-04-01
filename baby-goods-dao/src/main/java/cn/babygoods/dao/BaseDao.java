package cn.babygoods.dao;

import com.ctrip.platform.dal.dao.DalHints;
import com.ctrip.platform.dal.dao.KeyHolder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mzxiao on 2016/12/22.
 */
public interface BaseDao<T> {

    /**
     * Query HotelGen by the specified ID
     * The ID must be a number
     **/
    public T queryByPk(Number id, DalHints hints) throws SQLException;

    /**
     * Query HotelGen by HotelGen instance which the primary key is set
     **/
    public T queryByPk(T pk, DalHints hints) throws SQLException;

    /**
     * Query against sample pojo. All not null attributes of the passed in pojo
     * will be used as search criteria.
     **/
    public List<T> queryLike(T sample, DalHints hints)
            throws SQLException;

    /**
     * Get the all records count
     */
    public int count(DalHints hints)
            throws SQLException;

    /**
     * Query HotelGen with paging function
     * The pageSize and pageNo must be greater than zero.
     */
    public List<T> queryAllByPage(int pageNo, int pageSize, DalHints hints)
            throws SQLException;

    /**
     * Get all records from table
     */
    public List<T> queryAll(DalHints hints)
            throws SQLException;

    /**
     * Insert pojo and get the generated PK back in keyHolder. If the "set no count on" for MS
     * SqlServer is set(currently set in Ctrip), the operation may fail. Please don't pass keyholder
     * for MS SqlServer to avoid the failure.
     *
     * @param hints   Additional parameters that instruct how DAL Client perform database
     *                operation.
     * @param daoPojo pojo to be inserted
     * @return how many rows been affected
     */
    public int insert(DalHints hints, T daoPojo)
            throws SQLException;

    /**
     * Insert pojos one by one. If you want to inert them in the batch mode,
     * user batchInsert instead. You can also use the combinedInsert.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database
     *                 operation. DalHintEnum.continueOnError can be used to indicate that the
     *                 inserting can be go on if there is any failure.
     * @param daoPojos list of pojos to be inserted
     * @return how many rows been affected
     */
    public int[] insert(DalHints hints, List<T> daoPojos)
            throws SQLException;

    /**
     * Insert pojo and get the generated PK back in keyHolder. If the "set no count on" for MS
     * SqlServer is set(currently set in Ctrip), the operation may fail. Please don't pass keyholder
     * for MS SqlServer to avoid the failure.
     *
     * @param hints     Additional parameters that instruct how DAL Client perform database
     *                  operation.
     * @param keyHolder holder for generated primary keys
     * @param daoPojo   pojo to be inserted
     * @return how many rows been affected
     */
    public int insert(DalHints hints, KeyHolder keyHolder, T daoPojo)
            throws SQLException;

    /**
     * Insert pojos and get the generated PK back in keyHolder. If the "set no count on" for MS
     * SqlServer is set(currently set in Ctrip), the operation may fail. Please don't pass keyholder
     * for MS SqlServer to avoid the failure.
     *
     * @param hints     Additional parameters that instruct how DAL Client perform database
     *                  operation. DalHintEnum.continueOnError can be used to indicate that the
     *                  inserting can be go on if there is any failure.
     * @param keyHolder holder for generated primary keys
     * @param daoPojos  list of pojos to be inserted
     * @return how many rows been affected
     */
    public int[] insert(DalHints hints, KeyHolder keyHolder, List<T> daoPojos)
            throws SQLException;

    /**
     * Insert pojos in batch mode. The DalDetailResults will be set in hints to allow client know
     * how the operation performed in each of the shard.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database
     *                 operation.
     * @param daoPojos list of pojos to be inserted
     * @return how many rows been affected for inserting each of the pojo
     */
    public int[] batchInsert(DalHints hints, List<T> daoPojos)
            throws SQLException;

    /**
     * Insert multiple pojos in one INSERT SQL and get the generated PK back in keyHolder. If the
     * "set no count on" for MS SqlServer is set(currently set in Ctrip), the operation may fail.
     * Please don't pass keyholder for MS SqlServer to avoid the failure. The DalDetailResults will
     * be set in hints to allow client know how the operation performed in each of the shard.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database
     *                 operation.
     * @param daoPojos list of pojos to be inserted
     * @return how many rows been affected
     */
    public int combinedInsert(DalHints hints, List<T> daoPojos)
            throws SQLException;

    /**
     * Insert multiple pojos in one INSERT SQL and get the generated PK back in keyHolder. If the
     * "set no count on" for MS SqlServer is set(currently set in Ctrip), the operation may fail.
     * Please don't pass keyholder for MS SqlServer to avoid the failure. The DalDetailResults will
     * be set in hints to allow client know how the operation performed in each of the shard.
     *
     * @param hints     Additional parameters that instruct how DAL Client perform database
     *                  operation.
     * @param keyHolder holder for generated primary keys
     * @param daoPojos  list of pojos to be inserted
     * @return how many rows been affected
     */
    public int combinedInsert(DalHints hints, KeyHolder keyHolder, List<T> daoPojos)
            throws SQLException;

    /**
     * Delete the given pojo.
     *
     * @param hints   Additional parameters that instruct how DAL Client perform database
     *                operation.
     * @param daoPojo pojo to be deleted
     * @return how many rows been affected
     */
    public int delete(DalHints hints, T daoPojo)
            throws SQLException;

    /**
     * Delete the given pojos list one by one.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database
     *                 operation.
     * @param daoPojos list of pojos to be deleted
     * @return how many rows been affected
     */
    public int[] delete(DalHints hints, List<T> daoPojos)
            throws SQLException;

    /**
     * Delete the given pojo list in batch. The DalDetailResults will be set in hints to allow
     * client know how the operation performed in each of the shard.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database
     *                 operation.
     * @param daoPojos list of pojos to be deleted
     * @return how many rows been affected for deleting each of the pojo
     */
    public int[] batchDelete(DalHints hints, List<T> daoPojos)
            throws SQLException;

    /**
     * Update the given pojo . By default, if a field of pojo is null value,
     * that field will be ignored, so that it will not be updated. You can
     * overwrite this by set updateNullField in hints.
     *
     * @param hints   Additional parameters that instruct how DAL Client perform database operation.
     *                DalHintEnum.updateNullField can be used to indicate that the field of pojo is
     *                null value will be update.
     * @param daoPojo pojo to be updated
     * @return how many rows been affected
     */
    public int update(DalHints hints, T daoPojo)
            throws SQLException;

    /**
     * Update the given pojo list one by one. By default, if a field of pojo is null value,
     * that field will be ignored, so that it will not be updated. You can
     * overwrite this by set updateNullField in hints.
     *
     * @param hints    Additional parameters that instruct how DAL Client perform database
     *                 operation. DalHintEnum.updateNullField can be used to indicate that the field
     *                 of pojo is null value will be update.
     * @param daoPojos list of pojos to be updated
     * @return how many rows been affected
     */
    public int[] update(DalHints hints, List<T> daoPojos)
            throws SQLException;

    /**
     * Update the given pojo list in batch.
     *
     * @return how many rows been affected
     */
    public int[] batchUpdate(DalHints hints, List<T> daoPojos)
            throws SQLException;

}


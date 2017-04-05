package cn.babygoods.service.controller;

import cn.babygoods.biz.GoodsTypeBiz;
import cn.babygoods.biz.bo.GoodsTypeBo;
import cn.babygoods.common.BeanUtil;
import cn.babygoods.common.JsonUtil;
import cn.babygoods.common.ServiceName;
import cn.babygoods.service.vo.GetDataRequest;
import cn.babygoods.service.vo.GetDataResponse;
import cn.babygoods.service.vo.GoodsTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Vincent on 2017/3/22.
 */
@Controller
public class ServiceController {
    @Autowired
    GoodsTypeBiz goodsTypeBiz;

    @RequestMapping(value = "getdata", method = RequestMethod.POST)
    public GetDataResponse GetData(GetDataRequest request) {
        GetDataResponse response = new GetDataResponse();
        try {
            String functionName = request.getFunctionName();
            switch (functionName) {
                case ServiceName.GetGoodsType:
                    response.setData(GetGoodsType());
                    break;
                case ServiceName.SaveGoodsType:
                    break;
            }

            response.setResult("success");
        } catch (Exception ex) {
            response.setResult("fail");
            response.setMsg(ex.toString());
        }
        response.setTimeStamp(new Timestamp(new Date().getTime()).toString());
        return response;
    }

    private String GetGoodsType() throws SQLException {
        List<GoodsTypeBo> goodsTypeBoList = goodsTypeBiz.getGoodsType();
        List<GoodsTypeVo> goodsTypeVoList = BeanUtil.copyProperties(goodsTypeBoList, GoodsTypeVo.class);
        String result = JsonUtil.beanToJson(goodsTypeVoList);
        return result;
    }
}

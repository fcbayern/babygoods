package cn.babygoods.service.controller;

import cn.babygoods.biz.GoodsTypeBiz;
import cn.babygoods.service.vo.GetDataRequest;
import cn.babygoods.service.vo.GetDataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.Date;

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
            switch (functionName)
            {
                case "getGoodsType":
                    break;
                case "saveGoodsType":
                    break;
            }

            response.setResult("success");
        }
        catch (Exception ex)
        {
            response.setResult("fail");
            response.setMsg(ex.toString());
        }
        response.setTimeStamp(new Timestamp(new Date().getTime()).toString());
        return response;
    }
}

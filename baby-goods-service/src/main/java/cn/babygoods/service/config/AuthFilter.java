package cn.babygoods.service.config;

import cn.babygoods.common.AppConst;
import cn.babygoods.common.CryptUtil;
import cn.babygoods.common.JsonUtil;
import cn.babygoods.service.vo.GetDataRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Vincent on 2017/3/29.
 */
public class AuthFilter implements Filter {

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        GetDataRequest request = JsonUtil.jsonToBean(req.toString(), GetDataRequest.class);
        Map<String, String> bizMap = new HashMap<>();
        String[] bizDatas = request.getData().split("&");
        for (String bizData : bizDatas) {
            String[] items = bizData.split("=");
            bizMap.put(items[0], items[1]);
        }
        SortedMap sortedMap = new TreeMap(bizMap);
        StringBuffer sb = new StringBuffer();
        Set es = sortedMap.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        String str = sb.toString() + "key=" + AppConst.AuthKey;
        String authStr = CryptUtil.MD5Encode(str, null);
        if (authStr.equals(request.getSign())) {
            chain.doFilter(req, res);
        } else {
            response.setStatus(401);
        }
    }
}

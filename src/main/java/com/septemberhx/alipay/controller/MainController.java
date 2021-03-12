package com.septemberhx.alipay.controller;

import com.hitices.mclient.annotation.MLogFunction;
import com.septemberhx.alipay.utils.MBaseUtils;
import com.hitices.common.bean.MResponse;
import com.hitices.mclient.annotation.MFuncDescription;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SeptemberHX
 * @version 0.1
 * @date 2020/3/31
 */
@Controller
public class MainController {

    private Logger logger = LogManager.getLogger(this);

    @PostMapping(path = "/pay")
    @ResponseBody
    @MFuncDescription(value = "pay", level = 4)
    @MLogFunction
    public MResponse pay(@RequestBody MResponse params, HttpServletRequest request) {
        return MBaseUtils.generateResInKBSize(5);
    }

    @PostMapping(path = "/life")
    @ResponseBody
    @MFuncDescription(value = "life", level = 2)
    @MLogFunction
    public MResponse life(@RequestBody MResponse params, HttpServletRequest request) {

        boolean r = MBaseUtils.verDepRequest("weather", 20, request, logger);

        if (!r) {
            return MResponse.failResponse();
        }
        return MBaseUtils.generateResInKBSize(9);
    }
}

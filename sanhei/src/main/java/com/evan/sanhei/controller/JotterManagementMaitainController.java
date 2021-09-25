package com.evan.sanhei.controller;

import com.chinastock.communication.BaseResponse;
import com.chinastock.log.Biz;
import com.chinastock.log.Performance;
import com.evan.sanhei.common.constant.Constants;
import com.evan.sanhei.model.ro.QueryJotterArticleRO;
import com.evan.sanhei.model.vo.QueryJotterArticleVO;
import com.evan.sanhei.service.JotterManagementMaitainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @program: WJ-LUO
 * @description: 笔记本管理
 * @author: Jimu.Luo
 * @create: 2021-09-23 14:33
 **/

@Api(tags = "笔记本管理")
@RestController
@Validated
@RequestMapping(Constants.API_PREFIX + "/jotterManagementMaitain")
public class JotterManagementMaitainController {

    @Autowired
    private JotterManagementMaitainService jotterManagementMaitainService;

    @CrossOrigin //解决跨域问题
    @Biz
    @Performance
//    @WhiteAuth(required = true) 白名单，此处用不到
    @ApiOperation(value ="笔记本信息-查询")
    @RequestMapping(value = "/queryJotterArticleInfo", method = RequestMethod.POST)
    public BaseResponse<List<QueryJotterArticleRO>> queryJotterArticleInfo(/*@RequestHeader("Authorization") String token,*/ @RequestBody @Valid QueryJotterArticleVO queryJotterArticleVO) {
        return jotterManagementMaitainService.queryJotterArticleInfo(queryJotterArticleVO);
    }
}

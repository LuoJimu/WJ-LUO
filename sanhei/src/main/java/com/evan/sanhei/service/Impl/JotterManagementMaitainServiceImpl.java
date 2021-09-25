package com.evan.sanhei.service.Impl;

import com.chinastock.communication.BaseResponse;
import com.evan.sanhei.common.utils.ApiBaseResponse;
import com.evan.sanhei.dao.JotterManagementMaitainDAO;
import com.evan.sanhei.model.ro.QueryJotterArticleRO;
import com.evan.sanhei.model.vo.QueryJotterArticleVO;
import com.evan.sanhei.service.JotterManagementMaitainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @program: WJ-LUO
 * @description: 笔记本管理
 * @author: Jimu.Luo
 * @create: 2021-09-23 14:36
 **/

@Service
public class JotterManagementMaitainServiceImpl implements JotterManagementMaitainService {

    @Autowired
    private JotterManagementMaitainDAO jotterManagementMaitainDAO;

    //笔记本信息查询
    @Override
    public BaseResponse<List<QueryJotterArticleRO>> queryJotterArticleInfo(QueryJotterArticleVO queryJotterArticleVO) {
        ApiBaseResponse<List<QueryJotterArticleRO>> baseResponse = new ApiBaseResponse<>();
        //用来接收查询结果   （必有改变RO（还有变量名）
        List<QueryJotterArticleRO> result;

        if (queryJotterArticleVO.getPaging().equals("1")) {
            Integer pageNo = queryJotterArticleVO.getPageNo();
            Integer pageLength = queryJotterArticleVO.getPageLength();

            Assert.notNull(pageNo, "页码不能为空");
            Assert.notNull(pageLength, "每页条数不能为空");
            //result接收所有参数 --(改变ro直接抄（还有mapper）)
            result = jotterManagementMaitainDAO.queryJotterArticleInfo(queryJotterArticleVO);
        } else {
            result = jotterManagementMaitainDAO.queryJotterArticleInfo(queryJotterArticleVO);
        }
        baseResponse.setData(result);

        return baseResponse;
    }

}

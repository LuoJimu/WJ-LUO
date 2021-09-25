package com.evan.sanhei.service;

import com.chinastock.communication.BaseResponse;
import com.evan.sanhei.model.ro.QueryJotterArticleRO;
import com.evan.sanhei.model.vo.QueryJotterArticleVO;

import java.util.List;

public interface JotterManagementMaitainService {

    /**
     * 笔记本信息查询
     * @param queryJotterArticleVO
     * @return
     */
    BaseResponse<List<QueryJotterArticleRO>> queryJotterArticleInfo(QueryJotterArticleVO queryJotterArticleVO);
}

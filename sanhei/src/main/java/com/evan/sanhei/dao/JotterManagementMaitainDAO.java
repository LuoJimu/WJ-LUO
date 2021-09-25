package com.evan.sanhei.dao;

import com.evan.sanhei.model.ro.QueryJotterArticleRO;
import com.evan.sanhei.model.vo.QueryJotterArticleVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface JotterManagementMaitainDAO {

    //笔记本信息查询20210923
    List<QueryJotterArticleRO> queryJotterArticleInfo(QueryJotterArticleVO queryJotterArticleVO);

}

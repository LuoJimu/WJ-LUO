package com.evan.sanhei.service;

import com.chinastock.communication.BaseResponse;
import com.evan.sanhei.model.ro.CategoryRO;
import com.evan.sanhei.model.ro.QueryInfoBookRO;
import com.evan.sanhei.model.vo.*;

import java.util.List;

public interface LibraryManagementMaitainService {

    /**
     * 图书类型查询
     * @param categoryVO
     * @return
     */
    BaseResponse<List<CategoryRO>> queryCategoryInfo(CategoryVO categoryVO);

    /**
     * 图书信息查询
     * @param queryInfoBookVO
     * @return
     */
    BaseResponse<List<QueryInfoBookRO>> queryInfoBook(QueryInfoBookVO queryInfoBookVO);

    /**
     * 图书信息-新增
     *
     * @param insertBookInfoVO
     * @return
     */
    BaseResponse<Integer> insertBookInfo(InsertBookInfoVO insertBookInfoVO);

    /**
     * 图书信息-修改
     *
     * @param updateBookInfoVO
     * @return
     */
    BaseResponse<Integer> updateBookInfo(UpdateBookInfoVO updateBookInfoVO);

    /**
     * 图书信息-删除
     *
     * @param deleteBookInfoVO
     * @return
     */
    BaseResponse<Integer> deleteBookInfo(DeleteBookInfoVO deleteBookInfoVO);

}

package com.evan.sanhei.service.Impl;

import com.chinastock.communication.BaseResponse;
import com.evan.sanhei.common.utils.ApiBaseResponse;
import com.evan.sanhei.dao.LibraryManagementMaitainDAO;
import com.evan.sanhei.model.ro.CategoryRO;
import com.evan.sanhei.model.ro.QueryInfoBookRO;
import com.evan.sanhei.model.vo.*;
import com.evan.sanhei.service.LibraryManagementMaitainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: WJ-LUO
 * @description: 图书管理
 * @author: Jimu.Luo
 * @create: 2021-08-11 22:03
 **/

@Service
public class LibraryManagementMaitainServiceImpl implements LibraryManagementMaitainService {

    @Autowired
    private LibraryManagementMaitainDAO libraryManagementMaitainDAO;


    //图书类型查询
    @Override
    public BaseResponse<List<CategoryRO>> queryCategoryInfo(CategoryVO categoryVO) {
        ApiBaseResponse<List<CategoryRO>> baseResponse = new ApiBaseResponse<>();
        //用来接收查询结果   （必有改变RO（还有变量名）
        List<CategoryRO> result;

        if (categoryVO.getPaging().equals("1")) {
            Integer pageNo = categoryVO.getPageNo();
            Integer pageLength = categoryVO.getPageLength();

            Assert.notNull(pageNo, "页码不能为空");
            Assert.notNull(pageLength, "每页条数不能为空");
            //result接收所有参数 --(改变ro直接抄（还有mapper）)
            result = libraryManagementMaitainDAO.queryCategoryInfo(categoryVO);
        } else {
            result = libraryManagementMaitainDAO.queryCategoryInfo(categoryVO);
        }
        baseResponse.setData(result);

        return baseResponse;
    }

    //图书查询20210814
    @Override
    public BaseResponse<List<QueryInfoBookRO>> queryInfoBook(QueryInfoBookVO queryInfoBookVO) {
        ApiBaseResponse<List<QueryInfoBookRO>> baseResponse = new ApiBaseResponse<>();
        //用来接收查询结果   （必有改变RO（还有变量名）
        List<QueryInfoBookRO> result;
        //20210914给查询结果出参赋值
        List<QueryInfoBookRO> queryInfoBookROs = new ArrayList<>();
        queryInfoBookROs = libraryManagementMaitainDAO.queryInfoBook(queryInfoBookVO);

        if (queryInfoBookVO.getPaging().equals("1")) {
            Integer pageNo = queryInfoBookVO.getPageNo();
            Integer pageLength = queryInfoBookVO.getPageLength();

            Assert.notNull(pageNo, "页码不能为空");
            Assert.notNull(pageLength, "每页条数不能为空");

            // 修改出参20210912
            for(QueryInfoBookRO queryInfoBookRO:queryInfoBookROs){
                CategoryRO categoryRO = new CategoryRO();
                categoryRO.setTypeId(queryInfoBookRO.getCid());
                categoryRO.setTypeName(queryInfoBookRO.getTypeName());
                queryInfoBookRO.setCategory(categoryRO);
            }
            result = queryInfoBookROs;

            // result接收所有参数 --(改变ro直接抄（还有mapper）)
            // result = libraryManagementMaitainDAO.queryInfoBook(queryInfoBookVO);
        } else {
            // result = libraryManagementMaitainDAO.queryInfoBook(queryInfoBookVO);

            // 修改出参20210912
            for(QueryInfoBookRO queryInfoBookRO:queryInfoBookROs){
                CategoryRO categoryRO = new CategoryRO();
                categoryRO.setTypeId(queryInfoBookRO.getCid());
                categoryRO.setTypeName(queryInfoBookRO.getTypeName());
                queryInfoBookRO.setCategory(categoryRO);
            }
            result = queryInfoBookROs;

        }
        baseResponse.setData(result);

        return baseResponse;
    }

    //图书新增20210814
    @Override
    public BaseResponse<Integer> insertBookInfo(InsertBookInfoVO insertBookInfoVO) {
        Integer code = libraryManagementMaitainDAO.insertBookInfo(insertBookInfoVO);
        if (code < 0) {
            throw new RuntimeException("修改通知状态失败");
        }
        return new BaseResponse<>(true, "0000", "成功");
    }

    //图书修改20210814
    @Override
    public BaseResponse<Integer> updateBookInfo(UpdateBookInfoVO updateBookInfoVO) {
//        if(updateBookInfoVO.getBookId().equals(null)){
//        }

        Integer code = libraryManagementMaitainDAO.updateBookInfo(updateBookInfoVO);
        if (code < 0) {
            throw new RuntimeException("修改通知状态失败");
        }
        return new BaseResponse<>(true, "0000", "成功");
    }

    //图书删除20210814
    @Override
    public BaseResponse<Integer> deleteBookInfo(DeleteBookInfoVO deleteBookInfoVO) {
        Integer code = libraryManagementMaitainDAO.deleteBookInfo(deleteBookInfoVO);
        if (code < 0) {
            throw new RuntimeException("修改通知状态失败");
        }
        return new BaseResponse<>(true, "0000", "成功");
    }

}

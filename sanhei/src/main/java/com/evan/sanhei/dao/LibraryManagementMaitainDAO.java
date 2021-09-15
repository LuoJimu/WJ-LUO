package com.evan.sanhei.dao;

import com.evan.sanhei.model.ro.CategoryRO;
import com.evan.sanhei.model.ro.QueryInfoBookRO;
import com.evan.sanhei.model.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface LibraryManagementMaitainDAO {


//    String findColNamesByJkmc(@Param("jkmc") String jkmc, @Param("type") String type);

    //图书类型查询
    List<CategoryRO> queryCategoryInfo(CategoryVO categoryVO);

    //图书信息查询20210814
    List<QueryInfoBookRO> queryInfoBook(QueryInfoBookVO queryInfoBookVO);

    //图书信息新增20210814
    Integer insertBookInfo(InsertBookInfoVO insertBookInfoVO);

    //图书信息修改20210814
    Integer updateBookInfo(UpdateBookInfoVO updateBookInfoVO);

    //图书信息删除20210814
    Integer deleteBookInfo(DeleteBookInfoVO deleteBookInfoVO);


}

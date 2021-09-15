package com.evan.sanhei.controller;

import com.chinastock.communication.BaseResponse;
import com.chinastock.log.Biz;
import com.chinastock.log.Performance;
import com.evan.sanhei.common.constant.Constants;
import com.evan.sanhei.common.utils.StringUtils;
import com.evan.sanhei.model.ro.CategoryRO;
import com.evan.sanhei.model.ro.QueryInfoBookRO;
import com.evan.sanhei.model.vo.*;
import com.evan.sanhei.service.LibraryManagementMaitainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @program: WJ-LUO
 * @description: 图书管理
 * @author: Jimu.Luo
 * @create: 2021-08-11 22:12
 **/

@Api(tags = "图书管理")
@RestController
@Validated
@RequestMapping(Constants.API_PREFIX + "/libraryManagementMaitain")
public class LibraryManagementMaitainController {

    @Autowired
    private LibraryManagementMaitainService libraryManagementMaitainService;

    @CrossOrigin //解决跨域问题
    @Biz
    @Performance
//    @WhiteAuth(required = true) 白名单，此处用不到
    @ApiOperation(value ="图书类型-查询")
    @RequestMapping(value = "/queryCategoryInfo", method = RequestMethod.POST)
    public BaseResponse<List<CategoryRO>> queryCategoryInfo(/*@RequestHeader("Authorization") String token,*/ @RequestBody @Valid CategoryVO categoryVO) {
        return libraryManagementMaitainService.queryCategoryInfo(categoryVO);
    }

    @CrossOrigin //解决跨域问题
    @Biz
    @Performance
//    @WhiteAuth(required = true) 白名单，此处用不到
    @ApiOperation(value ="图书信息-查询")
//    @PostMapping("/queryInfoBook")
    @RequestMapping(value = "/queryInfoBook", method = RequestMethod.POST)
    public BaseResponse<List<QueryInfoBookRO>> queryInfoBook(/*@RequestHeader("Authorization") String token,*/ @RequestBody @Valid QueryInfoBookVO queryInfoBookVO) {
        return libraryManagementMaitainService.queryInfoBook(queryInfoBookVO);
    }

    @CrossOrigin //解决跨域问题
    @Biz
    @Performance
//    @WhiteAuth(required = true) 白名单，此处用不到
    @ApiOperation(value ="图书信息-新增")
    @RequestMapping(value = "/insertBookInfo", method = RequestMethod.POST)
    public BaseResponse<Integer>  insertBookInfo(/*@RequestHeader("Authorization") String token,*/ @RequestBody @Valid InsertBookInfoVO insertBookInfoVO) {
        return libraryManagementMaitainService.insertBookInfo(insertBookInfoVO);
    }

    @CrossOrigin //解决跨域问题
    @Biz
    @Performance
//    @WhiteAuth(required = true) 白名单，此处用不到
    @ApiOperation(value ="图书信息-修改")
    @RequestMapping(value = "/updateBookInfo", method = RequestMethod.POST)
    public BaseResponse<Integer>  updateBookInfo(/*@RequestHeader("Authorization") String token,*/ @RequestBody @Valid UpdateBookInfoVO updateBookInfoVO) {
        return libraryManagementMaitainService.updateBookInfo(updateBookInfoVO);
    }

    @CrossOrigin //解决跨域问题
    @Biz
    @Performance
//    @WhiteAuth(required = true) 白名单，此处用不到
    @ApiOperation(value ="图书信息-删除")
    @RequestMapping(value = "/deleteBookInfo", method = RequestMethod.POST)
    public BaseResponse<Integer>  deleteBookInfo(/*@RequestHeader("Authorization") String token,*/ @RequestBody @Valid DeleteBookInfoVO deleteBookInfoVO) {
        return libraryManagementMaitainService.deleteBookInfo(deleteBookInfoVO);
    }

    //对文件的操作，对接收到的文件重命名，但保留原始的格式,上传图书封面
    @CrossOrigin
//    @PostMapping("api/covers")
    @ApiOperation(value ="图书封面上传")
    @RequestMapping(value = "/uploadBookCovers", method = RequestMethod.POST)
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "F:/svndownloads/wj-luo/wj-vue/src/coverimg";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(13) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/WJ-LUO/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}

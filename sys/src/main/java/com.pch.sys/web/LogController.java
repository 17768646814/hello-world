package com.pch.sys.web;

import com.pch.common.po.PageResult;
import com.pch.common.po.Result;
import com.pch.sys.po.Log;
import com.pch.sys.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author uo712
 * @version 1.0
 * @since 2017/1/13
 */
@RestController
@RequestMapping("/log")
@Api(value = "日志", tags = "日志接口")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/findAll", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "查询所有", notes = "log.findAll")
    public Result<Log> findAll() {
        return logService.findAll();
    }

    @RequestMapping(value = "/findAllPage", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "查询所有（分页）", notes = "log.findAllPage")
    public PageResult<Log> findAllPage(@ApiParam(name = "page", value = "第n页", required = false, defaultValue = "1") @RequestParam(required = false, defaultValue = "1") int page,
                                       @ApiParam(name = "size", value = "每页n条", required = false, defaultValue = "10") @RequestParam(required = false, defaultValue = "10") int size,
                                       @ApiParam(name = "sort", value = "按照？排序", required = false, defaultValue = "cDate,cTime") @RequestParam(required = false, defaultValue = "cDate,cTime") String sort) {
        PageRequest pageRequest = new PageRequest(page, size, new Sort(Sort.Direction.DESC, /*sort.split(",")*/"cDate"));
        return logService.findAll(pageRequest);
    }
}

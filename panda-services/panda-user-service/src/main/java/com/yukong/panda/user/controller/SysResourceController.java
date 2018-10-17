package com.yukong.panda.user.controller;

import com.yukong.panda.common.util.ApiResult;
import com.yukong.panda.common.util.UserUtil;
import com.yukong.panda.user.dto.SysResourceTree;
import com.yukong.panda.user.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: yukong
 * @date: 2018/10/17 13:22
 * @description: 资源管理
 */
@RestController
@RequestMapping("/resource")
public class SysResourceController {

    @Autowired
    private SysResourceService sysResourceService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 获取当前用户的菜单树
     * @return
     */
    @GetMapping("/menu/tree")
    public ApiResult<List<SysResourceTree>> getMenuTree(){
        List<String> roleCodes = UserUtil.getRoles(request);
        return new ApiResult<>(sysResourceService.getMenuTreeByRoleCodes(roleCodes));
    }

    /**
     * 获取所有的资源树
     * @return
     */
    @GetMapping("/tree")
    public ApiResult<List<SysResourceTree>> getAllResourceTree(){
        return new ApiResult<>(sysResourceService.getAllResourceTree());
    }

}
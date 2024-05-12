package org.example.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.example.shortlink.admin.common.convention.result.Result;
import org.example.shortlink.admin.common.convention.result.Results;
import org.example.shortlink.admin.dto.req.ShortLinkGroupSaveReqDTO;
import org.example.shortlink.admin.dto.req.UserLoginReqDTO;
import org.example.shortlink.admin.dto.req.UserRegisterReqDTO;
import org.example.shortlink.admin.dto.req.UserUpdateReqDTO;
import org.example.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import org.example.shortlink.admin.dto.resp.UserActualRespDTO;
import org.example.shortlink.admin.dto.resp.UserLoginRespDTO;
import org.example.shortlink.admin.dto.resp.UserRespDTO;
import org.example.shortlink.admin.service.GroupService;
import org.example.shortlink.admin.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *短链接分组控制层
 */
@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;
    @PostMapping("/api/short-link/v1/group")
    public Result<Void> save(@RequestBody ShortLinkGroupSaveReqDTO requestParam){
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }



    @GetMapping("/api/short-link/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> listGroup(  ){

        return Results.success(groupService.listGroup());
    }
}

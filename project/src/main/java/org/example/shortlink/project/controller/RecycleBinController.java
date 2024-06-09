package org.example.shortlink.project.controller;

import lombok.RequiredArgsConstructor;
import org.example.shortlink.project.common.convention.result.Result;
import org.example.shortlink.project.common.convention.result.Results;
import org.example.shortlink.project.dto.req.RecycleBinReqDTO;
import org.example.shortlink.project.service.RecycleBinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回收站控制层
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {


    private final RecycleBinService recycleBinService;
    /**
     * 保存回收站
     * @param requestParam
     */
    @PostMapping("/api/short-link/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinReqDTO requestParam) {
        recycleBinService.saveRecycleBin(requestParam);


        return Results.success();
    }
}

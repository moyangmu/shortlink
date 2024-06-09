package org.example.shortlink.admin.controller;

import lombok.RequiredArgsConstructor;
import org.example.shortlink.admin.common.convention.result.Result;
import org.example.shortlink.admin.common.convention.result.Results;
import org.example.shortlink.admin.dto.req.RecycleBinReqDTO;
import org.example.shortlink.admin.remote.ShortLinkRemoteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回收站控制层
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {


    ShortLinkRemoteService shortLinkService = new ShortLinkRemoteService() {
    };
    @PostMapping("/api/short-link/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinReqDTO requestParam) {
        shortLinkService.saveRecycleBin(requestParam);


        return Results.success();
    }
}

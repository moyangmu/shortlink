package org.example.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.example.shortlink.admin.common.convention.result.Result;
import org.example.shortlink.admin.common.convention.result.Results;
import org.example.shortlink.admin.dto.req.RecycleBinReqDTO;
import org.example.shortlink.admin.remote.ShortLinkRemoteService;
import org.example.shortlink.admin.remote.dto.req.RecycleBinRecoverReqDTO;
import org.example.shortlink.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import org.example.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.example.shortlink.admin.service.RecycleBinService;
import org.springframework.web.bind.annotation.GetMapping;
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

    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };
    @PostMapping("/api/short-link/admin/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinReqDTO requestParam) {
        shortLinkRemoteService.saveRecycleBin(requestParam);


        return Results.success();
    }

    /**
     * 分页查询回收站短链接
     * @param requestParam
     * @return
     */
    @GetMapping("/api/short-link/admin/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {


        return recycleBinService.pageRecycleBinShortLink(requestParam);
    }


    /**
     * 恢复短链接
     */
    @PostMapping("/api/short-link/admin/v1/recycle-bin/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        shortLinkRemoteService.recoverRecycleBin(requestParam);
        return Results.success();

    }


    @PostMapping("/api/short-link/admin/v1/recycle-bin/remove")
    public Result<Void> removeRecycleBin(@RequestBody RecycleBinReqDTO requestParam) {
        shortLinkRemoteService.removeRecycleBin(requestParam);
        return Results.success();
    }
}

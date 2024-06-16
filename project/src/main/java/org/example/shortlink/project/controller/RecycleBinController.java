package org.example.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.example.shortlink.project.common.convention.result.Result;
import org.example.shortlink.project.common.convention.result.Results;
import org.example.shortlink.project.dto.req.RecycleBinRecoverReqDTO;
import org.example.shortlink.project.dto.req.RecycleBinReqDTO;
import org.example.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import org.example.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import org.example.shortlink.project.service.RecycleBinService;
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
    /**
     * 保存回收站
     * @param requestParam
     */
    @PostMapping("/api/short-link/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinReqDTO requestParam) {
        recycleBinService.saveRecycleBin(requestParam);


        return Results.success();
    }

    /**
     * 分页查询回收站短链接
     *
     * @param requestParam
     * @return
     */
    @GetMapping("/api/short-link/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {

        return Results.success(recycleBinService.pageShortLink(requestParam));
    }

    /**
     * 恢复短链接
     *
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/v1/recycle-bin/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        recycleBinService.recoverRecycleBin(requestParam);
        return Results.success();
    }

    @PostMapping("/api/short-link/v1/recycle-bin/remove")
    public Result<Void> removeRecycleBin(@RequestBody RecycleBinReqDTO requestParam) {
        recycleBinService.removeRecycleBin(requestParam);
        return Results.success();
    }


}

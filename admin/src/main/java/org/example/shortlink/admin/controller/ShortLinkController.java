package org.example.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.shortlink.admin.common.convention.result.Result;
import org.example.shortlink.admin.common.convention.result.Results;
import org.example.shortlink.admin.remote.ShortLinkRemoteService;
import org.example.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import org.example.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.example.shortlink.admin.remote.dto.req.ShortLinkUpdateReqDTO;
import org.example.shortlink.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import org.example.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortLinkController {

    ShortLinkRemoteService shortLinkService = new ShortLinkRemoteService() {
    };
    /**
     * 创建短链接
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {

        return shortLinkService.createShortLink(requestParam);
    }


    /**
     * 修改短链接
     */
    @PostMapping("/api/short-link/admin/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkService.updateShortLink(requestParam);
        return Results.success();
    }

    /**
     * 分页查询短链接
     * @param requestParam
     * @return
     */
    @GetMapping("/api/short-link/admin/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {

        return shortLinkService.pageShortLink(requestParam);
    }
}

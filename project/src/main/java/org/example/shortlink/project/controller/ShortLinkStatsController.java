package org.example.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.example.shortlink.project.common.convention.result.Result;
import org.example.shortlink.project.common.convention.result.Results;
import org.example.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import org.example.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import org.example.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import org.example.shortlink.project.dto.resp.ShortLinkStatsRespDTO;
import org.example.shortlink.project.service.ShortLinkStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短链接监控控制层
 * 公众号：马丁玩编程，回复：加群，添加马哥微信（备注：link）获取项目资料
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {

    private final ShortLinkStatsService shortLinkStatsService;

    /**
     * 访问单个短链接指定时间内监控数据
     */
    @GetMapping("/api/short-link/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.oneShortLinkStats(requestParam));
    }

//    /**
//     * 访问分组短链接指定时间内监控数据
//     */
//    @GetMapping("/api/short-link/v1/stats/group")
//    public Result<ShortLinkStatsRespDTO> groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam) {
//        return Results.success(shortLinkStatsService.groupShortLinkStats(requestParam));
//    }
//
    /**
     * 访问单个短链接指定时间内访问记录监控数据
     */
    @GetMapping("/api/short-link/v1/stats/access-record")
    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam) {
        return Results.success(shortLinkStatsService.shortLinkStatsAccessRecord(requestParam));
    }

//    /**
//     * 访问分组短链接指定时间内访问记录监控数据
//     */
//    @GetMapping("/api/short-link/v1/stats/access-record/group")
//    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> groupShortLinkStatsAccessRecord(ShortLinkGroupStatsAccessRecordReqDTO requestParam) {
//        return Results.success(shortLinkStatsService.groupShortLinkStatsAccessRecord(requestParam));
//    }
}
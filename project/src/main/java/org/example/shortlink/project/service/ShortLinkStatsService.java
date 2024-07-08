package org.example.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import org.example.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import org.example.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import org.example.shortlink.project.dto.resp.ShortLinkStatsRespDTO;

public interface ShortLinkStatsService {

    /**
     * 获取单个短链接监控数据
     *
     * @param requestParam 获取短链接监控数据入参
     * @return 短链接监控数据
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);

    /**
     * 获取单个短链接记录监控数据
     *
     * @param requestParam 获取短链接监控访问记录数据入参
     * @return 短链接监控数据
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);
}
package org.example.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.shortlink.project.dao.entity.ShortLinkDO;
import org.example.shortlink.project.dto.req.RecycleBinRecoverReqDTO;
import org.example.shortlink.project.dto.req.RecycleBinReqDTO;
import org.example.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import org.example.shortlink.project.dto.resp.ShortLinkPageRespDTO;

/**
 * 回收站管理接口层
 */

public interface RecycleBinService extends IService<ShortLinkDO> {
    /**
     * 保存回收站
     * @param requestParam
     */
    void  saveRecycleBin(RecycleBinReqDTO requestParam);

    /**
     * 分页查询短链接
     * @return
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam);
    /**
     * 恢复短链接
     * @return
     */
    void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam);
    /**
     * 移除短链接
     * @return
     */
    void removeRecycleBin(RecycleBinReqDTO requestParam);
}

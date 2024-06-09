package org.example.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.shortlink.project.dao.entity.ShortLinkDO;
import org.example.shortlink.project.dto.req.RecycleBinReqDTO;

/**
 * 回收站管理接口层
 */

public interface RecycleBinService extends IService<ShortLinkDO> {
    /**
     * 保存回收站
     * @param requestParam
     */
    void  saveRecycleBin(RecycleBinReqDTO requestParam);
}

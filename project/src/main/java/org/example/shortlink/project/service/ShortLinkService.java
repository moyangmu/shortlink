package org.example.shortlink.project.service;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.example.shortlink.project.dao.entity.ShortLinkDO;
import org.example.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import org.example.shortlink.project.dto.req.ShortLinkPageReqDTO;
import org.example.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import org.example.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import org.example.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.example.shortlink.project.dto.resp.ShortLinkPageRespDTO;

import java.util.List;

/**
 * 短链接接口层
 */
public interface ShortLinkService extends IService<ShortLinkDO> {

    /**
     * 创建短链接
     * @param requestParam 创建短链接请求参数
     * @return 短链接创建信息
     */
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);

    /**
     * 修改短链接
     * @return
     */
    void updateShortLink(ShortLinkUpdateReqDTO requestParam);


    /**
     * 分页查询短链接
     * @return
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);


    /**
     * 短连接分组个数
     * @return
     */
    List<ShortLinkGroupCountQueryRespDTO> ListGroupShortLinkCount(List<String> requestParam );

    /**
     * 短链接跳转
     * @param shortUri 短链接后缀
     * @param request 请求
     * @param response 响应
     */
    void restoreUrl(String shortUri, ServletRequest request, ServletResponse response);
}

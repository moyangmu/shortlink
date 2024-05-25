package org.example.shortlink.admin.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkCreateRespDTO {


    /**
     * 分组信息
     */
    private String gid;


    /**
     * 原始链接
     */
    private String originUrl;


    /**
     * 短链接
     */
    private String fullShortUrl;


}

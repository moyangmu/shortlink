package org.example.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.shortlink.admin.dao.entity.UserDO;
import org.example.shortlink.admin.dto.req.UserRegisterReqDTO;
import org.example.shortlink.admin.dto.resp.UserRespDTO;

/**
 * 用户接口层
 */
public interface UserService extends IService<UserDO> {
    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户返回实体
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 根据用户名查询用户是否存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    Boolean hasUsername(String username);


    void Register(UserRegisterReqDTO requestParam);

}

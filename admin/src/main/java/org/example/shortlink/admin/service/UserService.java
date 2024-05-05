package org.example.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.shortlink.admin.dao.entity.UserDO;
import org.example.shortlink.admin.dto.req.UserLoginReqDTO;
import org.example.shortlink.admin.dto.req.UserRegisterReqDTO;
import org.example.shortlink.admin.dto.req.UserUpdateReqDTO;
import org.example.shortlink.admin.dto.resp.UserLoginRespDTO;
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

    /**
     * 根据用户名修改用户信息
     *
     * @param requestParam 修改用户请求参数
     */
    void update(UserUpdateReqDTO requestParam);


    /**
     * 用户登录
     *
     * @param requestParam 用户登录请求参数
     * @return 用户登录返回实体 token
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    /**
     * 检查用户是否登录
     *
     * @param token 用户登录token
     * @param username 用户名
     * @return 用户是否登录标识
     */
    Boolean checkLogin(String token,String username);

    /**
     * 退出登录
     *
     * @param username 用户登录名
     * @param token    用户登录token
     * @return 用户是否登录标识
     */
    void logout(String username, String token);
}

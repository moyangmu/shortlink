package org.example.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import groovy.util.logging.Slf4j;
import org.example.shortlink.admin.dao.entity.GroupDO;
import org.example.shortlink.admin.dao.mapper.GroupMapper;
import org.example.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import org.example.shortlink.admin.service.GroupService;
import org.example.shortlink.admin.toolkit.RandomGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 短链接分组接口实现层
 */


@Slf4j
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {
    @Override
    public void saveGroup(String groupName) {
        String gid ;
        do {
            gid = RandomGenerator.generateRandom();
        }while (!hasGid(gid));


        GroupDO groupDO = GroupDO.builder()
                .gid(RandomGenerator.generateRandom())
                .sortOrder(0)
                .name(groupName)
                .build();
        baseMapper.insert(groupDO);

    }

    @Override
    public List<ShortLinkGroupRespDTO> listGroup() {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag,0)
                .eq(GroupDO::getUsername,"mading")
                .orderByDesc(GroupDO::getSortOrder,GroupDO::getUpdateTime);

        List<GroupDO> groupDOList = baseMapper.selectList(queryWrapper);
        return BeanUtil.copyToList(groupDOList,ShortLinkGroupRespDTO.class);
    }

    private boolean hasGid(String gid){
           LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class).eq(GroupDO::getGid,gid)
                .eq(GroupDO::getUsername,null);


        GroupDO  groupDO= baseMapper.selectOne(queryWrapper);
        return groupDO == null;
    }
}

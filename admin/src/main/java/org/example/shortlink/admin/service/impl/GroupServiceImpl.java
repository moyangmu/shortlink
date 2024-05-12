package org.example.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import groovy.util.logging.Slf4j;
import org.example.shortlink.admin.dao.entity.GroupDO;
import org.example.shortlink.admin.dao.mapper.GroupMapper;
import org.example.shortlink.admin.service.GroupService;
import org.example.shortlink.admin.toolkit.RandomGenerator;
import org.springframework.stereotype.Service;

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
                .name(groupName)
                .build();
        baseMapper.insert(groupDO);

    }
    private boolean hasGid(String gid){
           LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class).eq(GroupDO::getGid,gid)
                .eq(GroupDO::getUsername,null);


        GroupDO  groupDO= baseMapper.selectOne(queryWrapper);
        return groupDO == null;
    }
}

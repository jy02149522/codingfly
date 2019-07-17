package org.codingfly.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.codingfly.account.entity.SysMenuEntity;
import org.codingfly.account.mapper.SysMenuDao;
import org.codingfly.account.service.SysMenuService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysMenuEntity> page = this.page(
                new Query<SysMenuEntity>().getPage(params),
                new QueryWrapper<SysMenuEntity>()
        );

        return new PageUtils(page);
    }

}
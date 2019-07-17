package org.codingfly.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.codingfly.account.entity.SysUserTokenEntity;
import org.codingfly.account.mapper.SysUserTokenDao;
import org.codingfly.account.service.SysUserTokenService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysUserTokenEntity> page = this.page(
                new Query<SysUserTokenEntity>().getPage(params),
                new QueryWrapper<SysUserTokenEntity>()
        );

        return new PageUtils(page);
    }

}
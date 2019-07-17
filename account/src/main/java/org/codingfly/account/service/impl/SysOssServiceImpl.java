package org.codingfly.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.codingfly.account.entity.SysOssEntity;
import org.codingfly.account.mapper.SysOssDao;
import org.codingfly.account.service.SysOssService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysOssEntity> page = this.page(
                new Query<SysOssEntity>().getPage(params),
                new QueryWrapper<SysOssEntity>()
        );

        return new PageUtils(page);
    }

}
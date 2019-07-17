package org.codingfly.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.codingfly.account.entity.SysCaptchaEntity;
import org.codingfly.account.mapper.SysCaptchaDao;
import org.codingfly.account.service.SysCaptchaService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysCaptchaService")
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaDao, SysCaptchaEntity> implements SysCaptchaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysCaptchaEntity> page = this.page(
                new Query<SysCaptchaEntity>().getPage(params),
                new QueryWrapper<SysCaptchaEntity>()
        );

        return new PageUtils(page);
    }

}
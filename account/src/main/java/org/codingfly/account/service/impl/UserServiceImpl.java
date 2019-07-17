package org.codingfly.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.codingfly.account.entity.UserEntity;
import org.codingfly.account.mapper.UserDao;
import org.codingfly.account.service.UserService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

}
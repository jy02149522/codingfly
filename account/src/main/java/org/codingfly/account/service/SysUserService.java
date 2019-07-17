package org.codingfly.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.account.entity.SysUserEntity;

import java.util.Map;

/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:34
 */
public interface SysUserService extends IService<SysUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


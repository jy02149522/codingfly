package org.codingfly.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.account.entity.SysUserTokenEntity;

import java.util.Map;

/**
 * 系统用户Token
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:33
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


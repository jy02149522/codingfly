package org.codingfly.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.account.entity.SysRoleEntity;

import java.util.Map;

/**
 * 角色
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:33
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


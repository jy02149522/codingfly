package org.codingfly.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.account.entity.SysUserRoleEntity;

import java.util.Map;

/**
 * 用户与角色对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:34
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


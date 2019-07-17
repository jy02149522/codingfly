package org.codingfly.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.account.entity.SysRoleMenuEntity;

import java.util.Map;

/**
 * 角色与菜单对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:33
 */
public interface SysRoleMenuService extends IService<SysRoleMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


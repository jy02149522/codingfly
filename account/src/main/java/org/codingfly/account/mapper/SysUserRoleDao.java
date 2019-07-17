package org.codingfly.account.mapper;

import org.codingfly.account.entity.SysUserRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:34
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {
	
}

package org.codingfly.account.mapper;

import org.codingfly.account.entity.SysUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:34
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
	
}

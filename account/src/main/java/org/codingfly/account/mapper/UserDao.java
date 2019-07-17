package org.codingfly.account.mapper;

import org.codingfly.account.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:33
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}

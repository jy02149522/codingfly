package org.codingfly.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.account.entity.SysConfigEntity;

import java.util.Map;

/**
 * 系统配置信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:33
 */
public interface SysConfigService extends IService<SysConfigEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


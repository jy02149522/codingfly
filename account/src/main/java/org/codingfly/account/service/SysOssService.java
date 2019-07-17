package org.codingfly.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.account.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:32
 */
public interface SysOssService extends IService<SysOssEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


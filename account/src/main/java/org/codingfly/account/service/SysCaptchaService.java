package org.codingfly.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.codingfly.common.utils.PageUtils;
import org.codingfly.account.entity.SysCaptchaEntity;

import java.util.Map;

/**
 * 系统验证码
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:33
 */
public interface SysCaptchaService extends IService<SysCaptchaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


package org.codingfly.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统验证码
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:33
 */
@Data
@TableName("sys_captcha")
@ApiModel
public class SysCaptchaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * uuid
	 */
	@TableId(type = IdType.UUID)
	@ApiModelProperty("uuid")
	private String uuid;
	/**
	 * 验证码
	 */
	@ApiModelProperty("验证码")
	private String code;
	/**
	 * 过期时间
	 */
	@ApiModelProperty("过期时间")
	private Date expireTime;

}

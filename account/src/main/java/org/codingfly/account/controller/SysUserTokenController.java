package org.codingfly.account.controller;

import org.codingfly.account.entity.SysUserTokenEntity;
import org.codingfly.account.service.SysUserTokenService;
import org.codingfly.common.entity.R;
import org.codingfly.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 系统用户Token
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:33
 */
@RestController
@RequestMapping("generator/sysusertoken")
public class SysUserTokenController {
    @Autowired
    private SysUserTokenService sysUserTokenService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserTokenService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")

    public R info(@PathVariable("userId") Long userId){
		SysUserTokenEntity sysUserToken = sysUserTokenService.getById(userId);

        return R.ok().put("sysUserToken", sysUserToken);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")

    public R save(@RequestBody SysUserTokenEntity sysUserToken){
		sysUserTokenService.save(sysUserToken);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")

    public R update(@RequestBody SysUserTokenEntity sysUserToken){
		sysUserTokenService.updateById(sysUserToken);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")

    public R delete(@RequestBody Long[] userIds){
		sysUserTokenService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}

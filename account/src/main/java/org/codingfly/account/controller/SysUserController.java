package org.codingfly.account.controller;

import org.codingfly.account.entity.SysUserEntity;
import org.codingfly.account.service.SysUserService;
import org.codingfly.common.entity.R;
import org.codingfly.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 系统用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:34
 */
@RestController
@RequestMapping("generator/sysuser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")

    public R info(@PathVariable("userId") Long userId){
		SysUserEntity sysUser = sysUserService.getById(userId);

        return R.ok().put("sysUser", sysUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")

    public R save(@RequestBody SysUserEntity sysUser){
		sysUserService.save(sysUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")

    public R update(@RequestBody SysUserEntity sysUser){
		sysUserService.updateById(sysUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")

    public R delete(@RequestBody Long[] userIds){
		sysUserService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}

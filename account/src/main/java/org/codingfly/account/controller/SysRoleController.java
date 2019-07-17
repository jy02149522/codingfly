package org.codingfly.account.controller;

import org.codingfly.account.entity.SysRoleEntity;
import org.codingfly.account.service.SysRoleService;
import org.codingfly.common.entity.R;
import org.codingfly.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 角色
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:33
 */
@RestController
@RequestMapping("generator/sysrole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")

    public R info(@PathVariable("roleId") Long roleId){
		SysRoleEntity sysRole = sysRoleService.getById(roleId);

        return R.ok().put("sysRole", sysRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")

    public R save(@RequestBody SysRoleEntity sysRole){
		sysRoleService.save(sysRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")

    public R update(@RequestBody SysRoleEntity sysRole){
		sysRoleService.updateById(sysRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")

    public R delete(@RequestBody Long[] roleIds){
		sysRoleService.removeByIds(Arrays.asList(roleIds));

        return R.ok();
    }

}

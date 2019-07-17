package org.codingfly.account.controller;

import org.codingfly.account.entity.SysConfigEntity;
import org.codingfly.account.service.SysConfigService;
import org.codingfly.common.entity.R;
import org.codingfly.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 系统配置信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:33
 */
@RestController
@RequestMapping("generator/sysconfig")
public class SysConfigController {
    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 列表
     */
    @RequestMapping("/list")

    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysConfigService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")

    public R info(@PathVariable("id") Long id){
		SysConfigEntity sysConfig = sysConfigService.getById(id);

        return R.ok().put("sysConfig", sysConfig);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")

    public R save(@RequestBody SysConfigEntity sysConfig){
		sysConfigService.save(sysConfig);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")

    public R update(@RequestBody SysConfigEntity sysConfig){
		sysConfigService.updateById(sysConfig);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")

    public R delete(@RequestBody Long[] ids){
		sysConfigService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}

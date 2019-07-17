package org.codingfly.account.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.codingfly.account.entity.SysCaptchaEntity;
import org.codingfly.account.service.SysCaptchaService;
import org.codingfly.common.entity.R;
import org.codingfly.common.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;




/**
 * 系统验证码
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-07-03 16:07:33
 */
@RestController
@RequestMapping("generator/syscaptcha")
@Api(tags = {"系统验证码"})
public class SysCaptchaController {
    @Autowired
    private SysCaptchaService sysCaptchaService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @ApiOperation(value = "列表")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysCaptchaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{uuid}")
    @ApiOperation(value="信息")
    public R info(@PathVariable("uuid") String uuid){
		SysCaptchaEntity sysCaptcha = sysCaptchaService.getById(uuid);

        return R.ok().put("sysCaptcha", sysCaptcha);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @ApiOperation(value="保存")
    public R save(@RequestBody SysCaptchaEntity sysCaptcha){
		sysCaptchaService.save(sysCaptcha);

        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @ApiOperation(value="修改")
    public R update(@RequestBody SysCaptchaEntity sysCaptcha){
		sysCaptchaService.updateById(sysCaptcha);

        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @ApiOperation(value="删除")
    public R delete(@RequestBody String[] uuids){
		sysCaptchaService.removeByIds(Arrays.asList(uuids));

        return R.ok();
    }

}

package cc.mrbird.febs.pms.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.utils.FebsUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author pangyong
 * @Date 2019/12/21 8:40
 */
@Controller("projectView")
public class ViewController extends BaseController {

    /**
     * 展示项目列表
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "pms/project/list")
    @RequiresPermissions("project:list")
    public String projectIndex() {
        return FebsUtil.view("pms/project/project");
    }
}

package cc.mrbird.febs.pms.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.pms.entity.DictProjectStage;
import cc.mrbird.febs.pms.entity.DictProjectType;
import cc.mrbird.febs.pms.service.DictProjectStageService;
import cc.mrbird.febs.pms.service.DictProjectTypeService;
import cc.mrbird.febs.system.entity.User;
import cc.mrbird.febs.system.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author pangPython
 * @Date 2019/12/21 8:40
 */
@Controller("projectView")
public class ViewController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private DictProjectStageService projectStageService;
    @Autowired
    private DictProjectTypeService projectTypeService;

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

    /**
     * 显示项目添加页面
     *
     * @return
     */
    @GetMapping(FebsConstant.VIEW_PREFIX + "pms/projectAddView")
    @RequiresPermissions("project:add")
    public String projectCreateView(Model model) {
        //开发阶段
        List<DictProjectStage> projectStages = projectStageService.list();
        model.addAttribute("projectStages", projectStages);
        //项目类型
        List<DictProjectType> projectTypes = projectTypeService.list();
        model.addAttribute("projectTypes", projectTypes);
        //可选成员
        List<User> userList = userService.list();
        model.addAttribute("userList", userList);
        return FebsUtil.view("pms/project/projectAdd");
    }
}

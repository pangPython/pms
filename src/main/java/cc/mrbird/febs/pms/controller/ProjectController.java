package cc.mrbird.febs.pms.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.pms.entity.Project;
import cc.mrbird.febs.pms.service.ProjectService;
import cc.mrbird.febs.system.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author pangPython
 * @Date 2019/12/21 14:37
 */
@RequestMapping("/project")
@RestController
@Validated
@Slf4j
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    /**
     * 项目列表 带分页
     *
     * @param project
     * @param request
     * @return
     */
    @GetMapping("list")
    @RequiresPermissions("project:list")
    public FebsResponse projectList(Project project, QueryRequest request) {
        IPage<Project> projectDetail = projectService.listPage(project, request);
        Map<String, Object> dataTable = getDataTable(projectDetail);
        return new FebsResponse().success().data(dataTable);
    }

    /**
     * 创建项目
     *
     * @param project
     * @return
     */
    @ControllerEndpoint(operation = "新增Project", exceptionMessage = "新增Project失败")
    @PostMapping("add")
    @ResponseBody
    @RequiresPermissions("project:add")
    public FebsResponse addProject(@Valid Project project) {
        // 设置项目创建人
        User currentUser = getCurrentUser();
        project.setCreateUser(currentUser.getUserId());
        this.projectService.createProject(project);
        return new FebsResponse().success();
    }


}

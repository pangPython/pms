package cc.mrbird.febs.pms.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.pms.entity.Project;
import cc.mrbird.febs.pms.service.ProjectService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author pangyong
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


}

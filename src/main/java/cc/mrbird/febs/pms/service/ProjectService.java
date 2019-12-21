package cc.mrbird.febs.pms.service;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.pms.entity.Project;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author pangPython
 */
public interface ProjectService extends IService<Project> {
    /**
     * 分页
     *
     * @param project
     * @param request
     * @return
     */
    IPage<Project> listPage(Project project, QueryRequest request);

    /**
     * 新增
     *
     * @param project project
     */
    void createProject(Project project);
}

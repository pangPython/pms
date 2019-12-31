package cc.mrbird.febs.pms.mapper;

import cc.mrbird.febs.pms.entity.Project;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @author pangPython
 */
public interface ProjectMapper extends BaseMapper<Project> {
    /**
     * 分页
     *
     * @param page
     * @param project
     * @return
     */
    IPage<Project> listPage(Page<Project> page, Project project);
    /**
     * 关联查询
     *
     * @param projectId
     * @return
     */
    Project findProjectDetail(@Param("projectId") Long projectId);

}

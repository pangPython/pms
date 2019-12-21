package cc.mrbird.febs.pms.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.pms.entity.Project;
import cc.mrbird.febs.pms.mapper.ProjectMapper;
import cc.mrbird.febs.pms.service.ProjectService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pangyong
 * @Date 2019/12/21 14:52
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    /**
     * 分页
     *
     * @param project
     * @param request
     * @return
     */
    @Override
    public IPage<Project> listPage(Project project, QueryRequest request) {
        Page<Project> page = new Page<>(request.getPageNum(), request.getPageSize());
        return baseMapper.listPage(page, project);
    }
}

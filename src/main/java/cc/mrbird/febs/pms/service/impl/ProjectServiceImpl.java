package cc.mrbird.febs.pms.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.pms.entity.Project;
import cc.mrbird.febs.pms.entity.ProjectMember;
import cc.mrbird.febs.pms.mapper.ProjectMapper;
import cc.mrbird.febs.pms.service.ProjectMemberService;
import cc.mrbird.febs.pms.service.ProjectService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pangPython
 * @Date 2019/12/21 14:52
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Autowired
    private ProjectMemberService projectMemberService;

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

    @Override
    @Transactional
    public void createProject(Project project) {
        this.save(project);
        // 保存成员
        String memberId = project.getMemberId();
        if (StringUtils.isNotBlank(memberId)) {
            String[] memberIds = memberId.split(StringPool.COMMA);
            setProjectMembers(project, memberIds);
        }
    }

    private void setProjectMembers(Project project, String[] memberIds) {
        List<ProjectMember> projectMembers = new ArrayList<>();
        Arrays.stream(memberIds).forEach(memberId -> {
            ProjectMember projectMember = new ProjectMember();
            projectMember.setProjectId(project.getProjectId());
            projectMember.setUserId(Long.valueOf(memberId));
            projectMembers.add(projectMember);
        });
        projectMemberService.saveBatch(projectMembers);
    }
}

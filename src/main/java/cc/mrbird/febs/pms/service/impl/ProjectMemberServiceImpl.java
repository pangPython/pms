package cc.mrbird.febs.pms.service.impl;

import cc.mrbird.febs.pms.entity.ProjectMember;
import cc.mrbird.febs.pms.mapper.ProjectMemberMapper;
import cc.mrbird.febs.pms.service.ProjectMemberService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author pangPython
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ProjectMemberServiceImpl extends ServiceImpl<ProjectMemberMapper, ProjectMember> implements ProjectMemberService {
    @Override
    public List<ProjectMember> findByUserId(Long userId) {
        return baseMapper.selectList(new QueryWrapper<ProjectMember>().lambda().eq(ProjectMember::getUserId, userId));
    }

    /**
     * 根据项目编号获取项目成员
     *
     * @param projectId
     * @return
     */
    @Override
    public List<ProjectMember> findByProjectId(Long projectId) {
        return baseMapper.selectList(new QueryWrapper<ProjectMember>().lambda().eq(ProjectMember::getProjectId, projectId));
    }
}

package cc.mrbird.febs.pms.service;

import cc.mrbird.febs.pms.entity.ProjectMember;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author pangPython
 */
public interface ProjectMemberService extends IService<ProjectMember> {
    List<ProjectMember> findByUserId(Long userId);

    /**
     * 根据项目编号获取项目成员
     *
     * @param projectId
     * @return
     */
    List<ProjectMember> findByProjectId(Long projectId);
}

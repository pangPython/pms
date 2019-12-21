package cc.mrbird.febs.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 项目成员实体类
 * @author pangPython
 */
@Data
@TableName("project_member")
public class ProjectMember implements Serializable {

    private static final long serialVersionUID = 7477252506301604997L;
    @TableId("project_id")
    private Long projectId;

    @TableId("user_id")
    private Long userId;

}

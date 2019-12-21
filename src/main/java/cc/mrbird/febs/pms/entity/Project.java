package cc.mrbird.febs.pms.entity;

import cc.mrbird.febs.common.converter.TimeConverter;
import cc.mrbird.febs.system.entity.User;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author pangPython
 */
@Data
@TableName("project")
@Excel("项目信息表")
public class Project implements Serializable {

    private static final long serialVersionUID = -5233096315439312286L;

    /**
     * 项目ID
     */
    @TableId(value = "project_id", type = IdType.AUTO)
    private Long projectId;
    /**
     * 项目名称
     */
    @TableField(value = "project_name")
    @NotBlank(message = "{required}")
    @ExcelField(value = "项目名称")
    private String projectName;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @ExcelField(value = "创建时间", writeConverter = TimeConverter.class)
    private Date createTime;

    /**
     * 项目创建人
     */
    @TableField("create_user")
    private Long createUser;
    /**
     * 项目创建人姓名
     */
    @TableField(exist = false)
    private String createUsername;

    @TableField("modify_time")
    @ExcelField(value = "修改时间", writeConverter = TimeConverter.class)
    private Date modifyTime;
    /**
     * 备注
     */
    @TableField("remark")
    @ExcelField(value = "备注")
    private String remark;

    /**
     * 项目状态
     */
    @TableField("status")
    @ExcelField(value = "状态")
    private Integer status;
    /**
     * 项目是否暂停
     * 0 否 项目进行中
     * 1 是 项目已暂停
     */
    @TableField("is_suspended")
    private Integer isSuspended;

    /**
     * 成员
     */
    @TableField(exist = false)
    private String memberId;

    /**
     * 成员姓名
     */
    @TableField(exist = false)
    private List<User> members;

    /**
     * 负责人ID
     */
    @TableField("head_id")
    @ExcelField(value = "负责人ID")
    private Long headId;

    /**
     * 负责人姓名
     */
    @ExcelField(value = "负责人姓名")
    @TableField(exist = false)
    private String headName;

    @TableField("type")
    @ExcelField(value = "类型")
    private Integer type;

    /**
     * 项目类型名称
     */
    @TableField(exist = false)
    private String typeName;

    @TableField("alias")
    @ExcelField(value = "项目代号")
    private String alias;

    @TableField("parent_id")
    @ExcelField(value = "根项目")
    private Long parentId;

    @TableField("version")
    @ExcelField(value = "版本")
    private String version;

    @TableField("progress")
    @ExcelField(value = "进度")
    private Integer progress;

    @TableField("progress_phase")
    private Integer progressPhase;

    @TableField("planned_work_hour")
    @ExcelField(value = "计划总工时")
    private Double plannedWorkHour;

    @TableField("actual_work_hour")
    @ExcelField(value = "实际总工时")
    private Double actualWorkHour;

    /**
     * 立项时间
     */
    @TableField("project_approval_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date projectApprovalTime;
    /**
     * 计划开始时间
     */
    @TableField("planned_start_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date plannedStartTime;
    /**
     * 实际开始时间
     */
    @TableField("start_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    /**
     * 立项说明
     */
    @TableField("project_approval_text")
    private String projectApprovalText;

    /**
     * 描述
     */
    @TableField("description")
    private String description;

    /**
     * 启动时间
     */
    @TableField("begining_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginingTime;

    /**
     * 关闭时间
     */
    @TableField("close_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date closeTime;

    /**
     * 关闭原因
     */
    @TableField("close_reason")
    private String closeReason;

    /**
     * 计划结束时间
     */
    @TableField("planned_end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date plannedEndTime;

    /**
     * 实际结束时间
     */
    @TableField("actual_end_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date actualEndTime;

    /**
     * 开发阶段
     */
    @TableField("stage")
    private Integer stage;
    /**
     * 阶段名称
     */
    @TableField(exist = false)
    private String stageName;
    /**
     * KPI
     */
    @TableField("kpi")
    private Double kpi;
    /**
     * 质量评分
     */
    @TableField("quality_score")
    private Double qualityScore;
    /**
     * 难度系数
     */
    @TableField("degree_of_difficulty")
    private Double degreeOfDifficulty;

}

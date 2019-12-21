package cc.mrbird.febs.pms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author pangPython
 */
@Data
@TableName("dict_project_stage")
public class DictProjectStage implements Serializable {
    private static final long serialVersionUID = -7737588475541247361L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    private String name;

    @TableField("comment")
    private String comment;
}

package com.djz.auth.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 系统参数
 * </p>
 *
 * @author djz
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_param")
public class SysParam implements Serializable {

    /**
     * 主键;
     */
    @TableId
    private Long id;

    /**
     * 参数键;
     */
    private Integer parKey;

    /**
     * 参数值;
     */
    private String parValue;

    /**
     * 参数url;
     */
    private String menuUrl;

    /**
     * 参数类型;
     */
    private String type;


}

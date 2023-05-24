package com.ruoyi.system.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.*;

import java.util.Date;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 单词本业务对象 word_book
 *
 * @author ruoyi
 * @date 2023-05-24
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class WordBookBo extends BaseEntity {

    /**
     * 单词id
     */
    @NotNull(message = "单词id不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 单词
     */
    @NotBlank(message = "单词不能为空", groups = { AddGroup.class, EditGroup.class })
    private String word;

    /**
     * 类型
     */
    @NotNull(message = "类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer type;

    /**
     * 发音
     */
    @NotBlank(message = "发音不能为空", groups = { AddGroup.class, EditGroup.class })
    private String pronounce;

    /**
     * 汉译
     */
    @NotBlank(message = "汉译不能为空", groups = { AddGroup.class, EditGroup.class })
    private String chinese;

    /**
     * 例句
     */
    @NotBlank(message = "例句不能为空", groups = { AddGroup.class, EditGroup.class })
    private String example;

    /**
     * 收藏
     */
    @NotNull(message = "收藏不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer collection;

    /**
     * 等级
     */
    @NotNull(message = "等级不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long level;

    /**
     * 状态
     */
    @NotNull(message = "状态不能为空", groups = { AddGroup.class, EditGroup.class })
    private Integer status;

    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空", groups = { AddGroup.class, EditGroup.class })
    private String remark;


}

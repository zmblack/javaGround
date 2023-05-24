package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 单词本对象 word_book
 *
 * @author ruoyi
 * @date 2023-05-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("word_book")
public class WordBook extends BaseEntity {

    private static final long serialVersionUID=1L;

    /**
     * 单词id
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 单词
     */
    private String word;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 发音
     */
    private String pronounce;
    /**
     * 汉译
     */
    private String chinese;
    /**
     * 例句
     */
    private String example;
    /**
     * 收藏
     */
    private Integer collection;
    /**
     * 等级
     */
    private Long level;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}

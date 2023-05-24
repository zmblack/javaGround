package com.ruoyi.system.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ruoyi.common.annotation.ExcelDictFormat;
import com.ruoyi.common.convert.ExcelDictConvert;
import lombok.Data;
import java.util.Date;



/**
 * 单词本视图对象 word_book
 *
 * @author ruoyi
 * @date 2023-05-24
 */
@Data
@ExcelIgnoreUnannotated
public class WordBookVo {

    private static final long serialVersionUID = 1L;

    /**
     * 单词id
     */
    @ExcelProperty(value = "单词id")
    private Long id;

    /**
     * 单词
     */
    @ExcelProperty(value = "单词")
    private String word;

    /**
     * 类型
     */
    @ExcelProperty(value = "类型")
    private Integer type;

    /**
     * 发音
     */
    @ExcelProperty(value = "发音")
    private String pronounce;

    /**
     * 汉译
     */
    @ExcelProperty(value = "汉译")
    private String chinese;

    /**
     * 例句
     */
    @ExcelProperty(value = "例句")
    private String example;

    /**
     * 收藏
     */
    @ExcelProperty(value = "收藏")
    private Integer collection;

    /**
     * 等级
     */
    @ExcelProperty(value = "等级")
    private Long level;

    /**
     * 状态
     */
    @ExcelProperty(value = "状态")
    private Integer status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}

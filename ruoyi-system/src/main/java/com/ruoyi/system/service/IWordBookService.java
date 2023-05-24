package com.ruoyi.system.service;

import com.ruoyi.system.domain.WordBook;
import com.ruoyi.system.domain.vo.WordBookVo;
import com.ruoyi.system.domain.bo.WordBookBo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 单词本Service接口
 *
 * @author ruoyi
 * @date 2023-05-24
 */
public interface IWordBookService {

    /**
     * 查询单词本
     */
    WordBookVo queryById(Long id);

    /**
     * 查询单词本列表
     */
    TableDataInfo<WordBookVo> queryPageList(WordBookBo bo, PageQuery pageQuery);


    List<WordBookVo> read(Integer num);

    /**
     * 查询单词本列表
     */
    List<WordBookVo> queryList(WordBookBo bo);

    /**
     * 新增单词本
     */
    Boolean insertByBo(WordBookBo bo);

    /**
     * 修改单词本
     */
    Boolean updateByBo(WordBookBo bo);

    /**
     * 校验并批量删除单词本信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

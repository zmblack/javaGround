package com.ruoyi.system.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.bo.WordBookBo;
import com.ruoyi.system.domain.vo.WordBookVo;
import com.ruoyi.system.domain.WordBook;
import com.ruoyi.system.mapper.WordBookMapper;
import com.ruoyi.system.service.IWordBookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 单词本Service业务层处理
 *
 * @author ruoyi
 * @date 2023-05-24
 */
@RequiredArgsConstructor
@Service
public class WordBookServiceImpl implements IWordBookService {

    private final WordBookMapper baseMapper;

    /**
     * 查询单词本
     */
    @Override
    public WordBookVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询单词本列表
     */
    @Override
    public TableDataInfo<WordBookVo> queryPageList(WordBookBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<WordBook> lqw = buildQueryWrapper(bo);
        Page<WordBookVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    @Override
    public List<WordBookVo> read(Integer num) {

        // 创建 reader
        try (BufferedReader br = Files.newBufferedReader(Paths.get("englishbook.csv"))) {
            // CSV文件的分隔符
            String DELIMITER = ",";
            // 按行读取
            String line;
            while ((line = br.readLine()) != null) {
                // 分割
                String[] columns = line.split(DELIMITER);
                // 打印行
                System.out.println("User["+ String.join(", ", columns) +"]");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * 查询单词本列表
     */
    @Override
    public List<WordBookVo> queryList(WordBookBo bo) {
        LambdaQueryWrapper<WordBook> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<WordBook> buildQueryWrapper(WordBookBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<WordBook> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo.getWord()), WordBook::getWord, bo.getWord());
        lqw.eq(bo.getType() != null, WordBook::getType, bo.getType());
        lqw.eq(StringUtils.isNotBlank(bo.getPronounce()), WordBook::getPronounce, bo.getPronounce());
        lqw.eq(StringUtils.isNotBlank(bo.getChinese()), WordBook::getChinese, bo.getChinese());
        lqw.eq(StringUtils.isNotBlank(bo.getExample()), WordBook::getExample, bo.getExample());
        lqw.eq(bo.getCollection() != null, WordBook::getCollection, bo.getCollection());
        lqw.eq(bo.getLevel() != null, WordBook::getLevel, bo.getLevel());
        lqw.eq(bo.getStatus() != null, WordBook::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增单词本
     */
    @Override
    public Boolean insertByBo(WordBookBo bo) {
        WordBook add = BeanUtil.toBean(bo, WordBook.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改单词本
     */
    @Override
    public Boolean updateByBo(WordBookBo bo) {
        WordBook update = BeanUtil.toBean(bo, WordBook.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(WordBook entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除单词本
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

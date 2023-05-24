package com.ruoyi.web.controller.book;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.vo.WordBookVo;
import com.ruoyi.system.domain.bo.WordBookBo;
import com.ruoyi.system.service.IWordBookService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 单词本
 *
 * @author ruoyi
 * @date 2023-05-24
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/my/book")
public class WordBookController extends BaseController {

    private final IWordBookService iWordBookService;

    /**
     * 查询单词本列表
     */
    @SaCheckPermission("my:book:list")
    @GetMapping("/list")
    public TableDataInfo<WordBookVo> list(WordBookBo bo, PageQuery pageQuery) {
        return iWordBookService.queryPageList(bo, pageQuery);
    }


    @SaCheckPermission("my:book:list")
    @GetMapping("/read/{num}")
    public TableDataInfo<WordBookVo> read(@PathVariable Long num) {

//        return iWordBookService.queryPageList(bo, pageQuery);
    return null;
    }

    /**
     * 导出单词本列表
     */
    @SaCheckPermission("my:book:export")
    @Log(title = "单词本", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(WordBookBo bo, HttpServletResponse response) {
        List<WordBookVo> list = iWordBookService.queryList(bo);
        ExcelUtil.exportExcel(list, "单词本", WordBookVo.class, response);
    }

    /**
     * 获取单词本详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("my:book:query")
    @GetMapping("/{id}")
    public R<WordBookVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long id) {
        return R.ok(iWordBookService.queryById(id));
    }

    /**
     * 新增单词本
     */
    @SaCheckPermission("my:book:add")
    @Log(title = "单词本", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody WordBookBo bo) {
        return toAjax(iWordBookService.insertByBo(bo));
    }

    /**
     * 修改单词本
     */
    @SaCheckPermission("my:book:edit")
    @Log(title = "单词本", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody WordBookBo bo) {
        return toAjax(iWordBookService.updateByBo(bo));
    }

    /**
     * 删除单词本
     *
     * @param ids 主键串
     */
    @SaCheckPermission("my:book:remove")
    @Log(title = "单词本", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iWordBookService.deleteWithValidByIds(Arrays.asList(ids), true));
    }
}

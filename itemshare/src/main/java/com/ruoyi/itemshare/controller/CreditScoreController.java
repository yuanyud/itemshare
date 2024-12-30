package com.ruoyi.itemshare.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.itemshare.domain.CreditScore;
import com.ruoyi.itemshare.service.ICreditScoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 信用评分管理Controller
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
@RestController
@RequestMapping("/itemshare/score")
public class CreditScoreController extends BaseController
{
    @Autowired
    private ICreditScoreService creditScoreService;

    /**
     * 查询信用评分管理列表
     */
    @PreAuthorize("@ss.hasPermi('itemshare:score:list')")
    @GetMapping("/list")
    public TableDataInfo list(CreditScore creditScore)
    {
        startPage();
        List<CreditScore> list = creditScoreService.selectCreditScoreList(creditScore);
        return getDataTable(list);
    }

    /**
     * 导出信用评分管理列表
     */
    @PreAuthorize("@ss.hasPermi('itemshare:score:export')")
    @Log(title = "信用评分管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CreditScore creditScore)
    {
        List<CreditScore> list = creditScoreService.selectCreditScoreList(creditScore);
        ExcelUtil<CreditScore> util = new ExcelUtil<CreditScore>(CreditScore.class);
        util.exportExcel(response, list, "信用评分管理数据");
    }

    /**
     * 获取信用评分管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('itemshare:score:query')")
    @GetMapping(value = "/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") Long studentId)
    {
        return success(creditScoreService.selectCreditScoreByStudentId(studentId));
    }

    /**
     * 新增信用评分管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:score:add')")
    @Log(title = "信用评分管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CreditScore creditScore)
    {
        return toAjax(creditScoreService.insertCreditScore(creditScore));
    }

    /**
     * 修改信用评分管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:score:edit')")
    @Log(title = "信用评分管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CreditScore creditScore)
    {
        return toAjax(creditScoreService.updateCreditScore(creditScore));
    }

    /**
     * 删除信用评分管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:score:remove')")
    @Log(title = "信用评分管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable Long[] studentIds)
    {
        return toAjax(creditScoreService.deleteCreditScoreByStudentIds(studentIds));
    }
}

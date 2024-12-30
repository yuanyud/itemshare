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
import com.ruoyi.itemshare.domain.Review;
import com.ruoyi.itemshare.service.IReviewService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评价管理Controller
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
@RestController
@RequestMapping("/itemshare/review")
public class ReviewController extends BaseController
{
    @Autowired
    private IReviewService reviewService;

    /**
     * 查询评价管理列表
     */
    @PreAuthorize("@ss.hasPermi('itemshare:review:list')")
    @GetMapping("/list")
    public TableDataInfo list(Review review)
    {
        startPage();
        List<Review> list = reviewService.selectReviewList(review);
        return getDataTable(list);
    }

    /**
     * 导出评价管理列表
     */
    @PreAuthorize("@ss.hasPermi('itemshare:review:export')")
    @Log(title = "评价管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Review review)
    {
        List<Review> list = reviewService.selectReviewList(review);
        ExcelUtil<Review> util = new ExcelUtil<Review>(Review.class);
        util.exportExcel(response, list, "评价管理数据");
    }

    /**
     * 获取评价管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('itemshare:review:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(reviewService.selectReviewById(id));
    }

    /**
     * 新增评价管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:review:add')")
    @Log(title = "评价管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Review review)
    {
        return toAjax(reviewService.insertReview(review));
    }

    /**
     * 修改评价管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:review:edit')")
    @Log(title = "评价管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Review review)
    {
        return toAjax(reviewService.updateReview(review));
    }

    /**
     * 删除评价管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:review:remove')")
    @Log(title = "评价管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(reviewService.deleteReviewByIds(ids));
    }
}

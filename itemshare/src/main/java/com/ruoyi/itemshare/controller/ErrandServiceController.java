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
import com.ruoyi.itemshare.domain.ErrandService;
import com.ruoyi.itemshare.service.IErrandServiceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 跑腿服务管理Controller
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
@RestController
@RequestMapping("/itemshare/service")
public class ErrandServiceController extends BaseController
{
    @Autowired
    private IErrandServiceService errandServiceService;

    /**
     * 查询跑腿服务管理列表
     */
    @PreAuthorize("@ss.hasPermi('itemshare:service:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErrandService errandService)
    {
        startPage();
        List<ErrandService> list = errandServiceService.selectErrandServiceList(errandService);
        return getDataTable(list);
    }

    /**
     * 导出跑腿服务管理列表
     */
    @PreAuthorize("@ss.hasPermi('itemshare:service:export')")
    @Log(title = "跑腿服务管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ErrandService errandService)
    {
        List<ErrandService> list = errandServiceService.selectErrandServiceList(errandService);
        ExcelUtil<ErrandService> util = new ExcelUtil<ErrandService>(ErrandService.class);
        util.exportExcel(response, list, "跑腿服务管理数据");
    }

    /**
     * 获取跑腿服务管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('itemshare:service:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(errandServiceService.selectErrandServiceById(id));
    }

    /**
     * 新增跑腿服务管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:service:add')")
    @Log(title = "跑腿服务管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErrandService errandService)
    {
        return toAjax(errandServiceService.insertErrandService(errandService));
    }

    /**
     * 修改跑腿服务管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:service:edit')")
    @Log(title = "跑腿服务管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErrandService errandService)
    {
        return toAjax(errandServiceService.updateErrandService(errandService));
    }

    /**
     * 删除跑腿服务管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:service:remove')")
    @Log(title = "跑腿服务管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(errandServiceService.deleteErrandServiceByIds(ids));
    }
}

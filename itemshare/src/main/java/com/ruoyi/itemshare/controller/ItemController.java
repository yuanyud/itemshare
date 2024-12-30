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
import com.ruoyi.itemshare.domain.Item;
import com.ruoyi.itemshare.service.IItemService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物品管理Controller
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
@RestController
@RequestMapping("/itemshare/item")
public class ItemController extends BaseController
{
    @Autowired
    private IItemService itemService;

    /**
     * 查询物品管理列表
     */
    @PreAuthorize("@ss.hasPermi('itemshare:item:list')")
    @GetMapping("/list")
    public TableDataInfo list(Item item)
    {
        startPage();
        List<Item> list = itemService.selectItemList(item);
        return getDataTable(list);
    }

    /**
     * 导出物品管理列表
     */
    @PreAuthorize("@ss.hasPermi('itemshare:item:export')")
    @Log(title = "物品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Item item)
    {
        List<Item> list = itemService.selectItemList(item);
        ExcelUtil<Item> util = new ExcelUtil<Item>(Item.class);
        util.exportExcel(response, list, "物品管理数据");
    }

    /**
     * 获取物品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('itemshare:item:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(itemService.selectItemById(id));
    }

    /**
     * 新增物品管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:item:add')")
    @Log(title = "物品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Item item)
    {
        return toAjax(itemService.insertItem(item));
    }

    /**
     * 修改物品管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:item:edit')")
    @Log(title = "物品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Item item)
    {
        return toAjax(itemService.updateItem(item));
    }

    /**
     * 删除物品管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:item:remove')")
    @Log(title = "物品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(itemService.deleteItemByIds(ids));
    }
}

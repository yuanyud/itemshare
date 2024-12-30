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
import com.ruoyi.itemshare.domain.Transaction;
import com.ruoyi.itemshare.service.ITransactionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 交易管理Controller
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
@RestController
@RequestMapping("/itemshare/transaction")
public class TransactionController extends BaseController
{
    @Autowired
    private ITransactionService transactionService;

    /**
     * 查询交易管理列表
     */
    @PreAuthorize("@ss.hasPermi('itemshare:transaction:list')")
    @GetMapping("/list")
    public TableDataInfo list(Transaction transaction)
    {
        startPage();
        List<Transaction> list = transactionService.selectTransactionList(transaction);
        return getDataTable(list);
    }

    /**
     * 导出交易管理列表
     */
    @PreAuthorize("@ss.hasPermi('itemshare:transaction:export')")
    @Log(title = "交易管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Transaction transaction)
    {
        List<Transaction> list = transactionService.selectTransactionList(transaction);
        ExcelUtil<Transaction> util = new ExcelUtil<Transaction>(Transaction.class);
        util.exportExcel(response, list, "交易管理数据");
    }

    /**
     * 获取交易管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('itemshare:transaction:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(transactionService.selectTransactionById(id));
    }

    /**
     * 新增交易管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:transaction:add')")
    @Log(title = "交易管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Transaction transaction)
    {
        return toAjax(transactionService.insertTransaction(transaction));
    }

    /**
     * 修改交易管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:transaction:edit')")
    @Log(title = "交易管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Transaction transaction)
    {
        return toAjax(transactionService.updateTransaction(transaction));
    }

    /**
     * 删除交易管理
     */
    @PreAuthorize("@ss.hasPermi('itemshare:transaction:remove')")
    @Log(title = "交易管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(transactionService.deleteTransactionByIds(ids));
    }
}

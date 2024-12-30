package com.ruoyi.itemshare.service;

import java.util.List;
import com.ruoyi.itemshare.domain.Transaction;

/**
 * 交易管理Service接口
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
public interface ITransactionService 
{
    /**
     * 查询交易管理
     * 
     * @param id 交易管理主键
     * @return 交易管理
     */
    public Transaction selectTransactionById(Long id);

    /**
     * 查询交易管理列表
     * 
     * @param transaction 交易管理
     * @return 交易管理集合
     */
    public List<Transaction> selectTransactionList(Transaction transaction);

    /**
     * 新增交易管理
     * 
     * @param transaction 交易管理
     * @return 结果
     */
    public int insertTransaction(Transaction transaction);

    /**
     * 修改交易管理
     * 
     * @param transaction 交易管理
     * @return 结果
     */
    public int updateTransaction(Transaction transaction);

    /**
     * 批量删除交易管理
     * 
     * @param ids 需要删除的交易管理主键集合
     * @return 结果
     */
    public int deleteTransactionByIds(Long[] ids);

    /**
     * 删除交易管理信息
     * 
     * @param id 交易管理主键
     * @return 结果
     */
    public int deleteTransactionById(Long id);
}

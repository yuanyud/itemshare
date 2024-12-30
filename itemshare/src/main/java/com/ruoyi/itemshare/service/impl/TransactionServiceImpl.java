package com.ruoyi.itemshare.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.itemshare.mapper.TransactionMapper;
import com.ruoyi.itemshare.domain.Transaction;
import com.ruoyi.itemshare.service.ITransactionService;

/**
 * 交易管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
@Service
public class TransactionServiceImpl implements ITransactionService 
{
    @Autowired
    private TransactionMapper transactionMapper;

    /**
     * 查询交易管理
     * 
     * @param id 交易管理主键
     * @return 交易管理
     */
    @Override
    public Transaction selectTransactionById(Long id)
    {
        return transactionMapper.selectTransactionById(id);
    }

    /**
     * 查询交易管理列表
     * 
     * @param transaction 交易管理
     * @return 交易管理
     */
    @Override
    public List<Transaction> selectTransactionList(Transaction transaction)
    {
        return transactionMapper.selectTransactionList(transaction);
    }

    /**
     * 新增交易管理
     * 
     * @param transaction 交易管理
     * @return 结果
     */
    @Override
    public int insertTransaction(Transaction transaction)
    {
        transaction.setCreateTime(DateUtils.getNowDate());
        return transactionMapper.insertTransaction(transaction);
    }

    /**
     * 修改交易管理
     * 
     * @param transaction 交易管理
     * @return 结果
     */
    @Override
    public int updateTransaction(Transaction transaction)
    {
        transaction.setUpdateTime(DateUtils.getNowDate());
        return transactionMapper.updateTransaction(transaction);
    }

    /**
     * 批量删除交易管理
     * 
     * @param ids 需要删除的交易管理主键
     * @return 结果
     */
    @Override
    public int deleteTransactionByIds(Long[] ids)
    {
        return transactionMapper.deleteTransactionByIds(ids);
    }

    /**
     * 删除交易管理信息
     * 
     * @param id 交易管理主键
     * @return 结果
     */
    @Override
    public int deleteTransactionById(Long id)
    {
        return transactionMapper.deleteTransactionById(id);
    }
}

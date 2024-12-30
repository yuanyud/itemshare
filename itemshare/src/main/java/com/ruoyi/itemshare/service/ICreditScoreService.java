package com.ruoyi.itemshare.service;

import java.util.List;
import com.ruoyi.itemshare.domain.CreditScore;

/**
 * 信用评分管理Service接口
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
public interface ICreditScoreService 
{
    /**
     * 查询信用评分管理
     * 
     * @param studentId 信用评分管理主键
     * @return 信用评分管理
     */
    public CreditScore selectCreditScoreByStudentId(Long studentId);

    /**
     * 查询信用评分管理列表
     * 
     * @param creditScore 信用评分管理
     * @return 信用评分管理集合
     */
    public List<CreditScore> selectCreditScoreList(CreditScore creditScore);

    /**
     * 新增信用评分管理
     * 
     * @param creditScore 信用评分管理
     * @return 结果
     */
    public int insertCreditScore(CreditScore creditScore);

    /**
     * 修改信用评分管理
     * 
     * @param creditScore 信用评分管理
     * @return 结果
     */
    public int updateCreditScore(CreditScore creditScore);

    /**
     * 批量删除信用评分管理
     * 
     * @param studentIds 需要删除的信用评分管理主键集合
     * @return 结果
     */
    public int deleteCreditScoreByStudentIds(Long[] studentIds);

    /**
     * 删除信用评分管理信息
     * 
     * @param studentId 信用评分管理主键
     * @return 结果
     */
    public int deleteCreditScoreByStudentId(Long studentId);
}

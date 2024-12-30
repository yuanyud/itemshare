package com.ruoyi.itemshare.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.itemshare.mapper.CreditScoreMapper;
import com.ruoyi.itemshare.domain.CreditScore;
import com.ruoyi.itemshare.service.ICreditScoreService;

/**
 * 信用评分管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
@Service
public class CreditScoreServiceImpl implements ICreditScoreService 
{
    @Autowired
    private CreditScoreMapper creditScoreMapper;

    /**
     * 查询信用评分管理
     * 
     * @param studentId 信用评分管理主键
     * @return 信用评分管理
     */
    @Override
    public CreditScore selectCreditScoreByStudentId(Long studentId)
    {
        return creditScoreMapper.selectCreditScoreByStudentId(studentId);
    }

    /**
     * 查询信用评分管理列表
     * 
     * @param creditScore 信用评分管理
     * @return 信用评分管理
     */
    @Override
    public List<CreditScore> selectCreditScoreList(CreditScore creditScore)
    {
        return creditScoreMapper.selectCreditScoreList(creditScore);
    }

    /**
     * 新增信用评分管理
     * 
     * @param creditScore 信用评分管理
     * @return 结果
     */
    @Override
    public int insertCreditScore(CreditScore creditScore)
    {
        creditScore.setCreateTime(DateUtils.getNowDate());
        return creditScoreMapper.insertCreditScore(creditScore);
    }

    /**
     * 修改信用评分管理
     * 
     * @param creditScore 信用评分管理
     * @return 结果
     */
    @Override
    public int updateCreditScore(CreditScore creditScore)
    {
        creditScore.setUpdateTime(DateUtils.getNowDate());
        return creditScoreMapper.updateCreditScore(creditScore);
    }

    /**
     * 批量删除信用评分管理
     * 
     * @param studentIds 需要删除的信用评分管理主键
     * @return 结果
     */
    @Override
    public int deleteCreditScoreByStudentIds(Long[] studentIds)
    {
        return creditScoreMapper.deleteCreditScoreByStudentIds(studentIds);
    }

    /**
     * 删除信用评分管理信息
     * 
     * @param studentId 信用评分管理主键
     * @return 结果
     */
    @Override
    public int deleteCreditScoreByStudentId(Long studentId)
    {
        return creditScoreMapper.deleteCreditScoreByStudentId(studentId);
    }
}

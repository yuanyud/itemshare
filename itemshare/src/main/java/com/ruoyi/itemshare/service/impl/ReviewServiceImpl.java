package com.ruoyi.itemshare.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.itemshare.mapper.ReviewMapper;
import com.ruoyi.itemshare.domain.Review;
import com.ruoyi.itemshare.service.IReviewService;

/**
 * 评价管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
@Service
public class ReviewServiceImpl implements IReviewService 
{
    @Autowired
    private ReviewMapper reviewMapper;

    /**
     * 查询评价管理
     * 
     * @param id 评价管理主键
     * @return 评价管理
     */
    @Override
    public Review selectReviewById(Long id)
    {
        return reviewMapper.selectReviewById(id);
    }

    /**
     * 查询评价管理列表
     * 
     * @param review 评价管理
     * @return 评价管理
     */
    @Override
    public List<Review> selectReviewList(Review review)
    {
        return reviewMapper.selectReviewList(review);
    }

    /**
     * 新增评价管理
     * 
     * @param review 评价管理
     * @return 结果
     */
    @Override
    public int insertReview(Review review)
    {
        review.setCreateTime(DateUtils.getNowDate());
        return reviewMapper.insertReview(review);
    }

    /**
     * 修改评价管理
     * 
     * @param review 评价管理
     * @return 结果
     */
    @Override
    public int updateReview(Review review)
    {
        review.setUpdateTime(DateUtils.getNowDate());
        return reviewMapper.updateReview(review);
    }

    /**
     * 批量删除评价管理
     * 
     * @param ids 需要删除的评价管理主键
     * @return 结果
     */
    @Override
    public int deleteReviewByIds(Long[] ids)
    {
        return reviewMapper.deleteReviewByIds(ids);
    }

    /**
     * 删除评价管理信息
     * 
     * @param id 评价管理主键
     * @return 结果
     */
    @Override
    public int deleteReviewById(Long id)
    {
        return reviewMapper.deleteReviewById(id);
    }
}

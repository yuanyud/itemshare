package com.ruoyi.itemshare.mapper;

import java.util.List;
import com.ruoyi.itemshare.domain.Review;

/**
 * 评价管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
public interface ReviewMapper 
{
    /**
     * 查询评价管理
     * 
     * @param id 评价管理主键
     * @return 评价管理
     */
    public Review selectReviewById(Long id);

    /**
     * 查询评价管理列表
     * 
     * @param review 评价管理
     * @return 评价管理集合
     */
    public List<Review> selectReviewList(Review review);

    /**
     * 新增评价管理
     * 
     * @param review 评价管理
     * @return 结果
     */
    public int insertReview(Review review);

    /**
     * 修改评价管理
     * 
     * @param review 评价管理
     * @return 结果
     */
    public int updateReview(Review review);

    /**
     * 删除评价管理
     * 
     * @param id 评价管理主键
     * @return 结果
     */
    public int deleteReviewById(Long id);

    /**
     * 批量删除评价管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReviewByIds(Long[] ids);
}

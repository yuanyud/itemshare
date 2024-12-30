package com.ruoyi.itemshare.service;

import java.util.List;
import com.ruoyi.itemshare.domain.ErrandService;

/**
 * 跑腿服务管理Service接口
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
public interface IErrandServiceService 
{
    /**
     * 查询跑腿服务管理
     * 
     * @param id 跑腿服务管理主键
     * @return 跑腿服务管理
     */
    public ErrandService selectErrandServiceById(Long id);

    /**
     * 查询跑腿服务管理列表
     * 
     * @param errandService 跑腿服务管理
     * @return 跑腿服务管理集合
     */
    public List<ErrandService> selectErrandServiceList(ErrandService errandService);

    /**
     * 新增跑腿服务管理
     * 
     * @param errandService 跑腿服务管理
     * @return 结果
     */
    public int insertErrandService(ErrandService errandService);

    /**
     * 修改跑腿服务管理
     * 
     * @param errandService 跑腿服务管理
     * @return 结果
     */
    public int updateErrandService(ErrandService errandService);

    /**
     * 批量删除跑腿服务管理
     * 
     * @param ids 需要删除的跑腿服务管理主键集合
     * @return 结果
     */
    public int deleteErrandServiceByIds(Long[] ids);

    /**
     * 删除跑腿服务管理信息
     * 
     * @param id 跑腿服务管理主键
     * @return 结果
     */
    public int deleteErrandServiceById(Long id);
}

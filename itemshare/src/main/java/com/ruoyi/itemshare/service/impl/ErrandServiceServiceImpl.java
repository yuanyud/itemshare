package com.ruoyi.itemshare.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.itemshare.mapper.ErrandServiceMapper;
import com.ruoyi.itemshare.domain.ErrandService;
import com.ruoyi.itemshare.service.IErrandServiceService;

/**
 * 跑腿服务管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
@Service
public class ErrandServiceServiceImpl implements IErrandServiceService 
{
    @Autowired
    private ErrandServiceMapper errandServiceMapper;

    /**
     * 查询跑腿服务管理
     * 
     * @param id 跑腿服务管理主键
     * @return 跑腿服务管理
     */
    @Override
    public ErrandService selectErrandServiceById(Long id)
    {
        return errandServiceMapper.selectErrandServiceById(id);
    }

    /**
     * 查询跑腿服务管理列表
     * 
     * @param errandService 跑腿服务管理
     * @return 跑腿服务管理
     */
    @Override
    public List<ErrandService> selectErrandServiceList(ErrandService errandService)
    {
        return errandServiceMapper.selectErrandServiceList(errandService);
    }

    /**
     * 新增跑腿服务管理
     * 
     * @param errandService 跑腿服务管理
     * @return 结果
     */
    @Override
    public int insertErrandService(ErrandService errandService)
    {
        errandService.setCreateTime(DateUtils.getNowDate());
        return errandServiceMapper.insertErrandService(errandService);
    }

    /**
     * 修改跑腿服务管理
     * 
     * @param errandService 跑腿服务管理
     * @return 结果
     */
    @Override
    public int updateErrandService(ErrandService errandService)
    {
        errandService.setUpdateTime(DateUtils.getNowDate());
        return errandServiceMapper.updateErrandService(errandService);
    }

    /**
     * 批量删除跑腿服务管理
     * 
     * @param ids 需要删除的跑腿服务管理主键
     * @return 结果
     */
    @Override
    public int deleteErrandServiceByIds(Long[] ids)
    {
        return errandServiceMapper.deleteErrandServiceByIds(ids);
    }

    /**
     * 删除跑腿服务管理信息
     * 
     * @param id 跑腿服务管理主键
     * @return 结果
     */
    @Override
    public int deleteErrandServiceById(Long id)
    {
        return errandServiceMapper.deleteErrandServiceById(id);
    }
}

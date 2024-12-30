package com.ruoyi.itemshare.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.itemshare.mapper.ItemMapper;
import com.ruoyi.itemshare.domain.Item;
import com.ruoyi.itemshare.service.IItemService;

/**
 * 物品管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
@Service
public class ItemServiceImpl implements IItemService 
{
    @Autowired
    private ItemMapper itemMapper;

    /**
     * 查询物品管理
     * 
     * @param id 物品管理主键
     * @return 物品管理
     */
    @Override
    public Item selectItemById(Long id)
    {
        return itemMapper.selectItemById(id);
    }

    /**
     * 查询物品管理列表
     * 
     * @param item 物品管理
     * @return 物品管理
     */
    @Override
    public List<Item> selectItemList(Item item)
    {
        return itemMapper.selectItemList(item);
    }

    /**
     * 新增物品管理
     * 
     * @param item 物品管理
     * @return 结果
     */
    @Override
    public int insertItem(Item item)
    {
        item.setCreateTime(DateUtils.getNowDate());
        return itemMapper.insertItem(item);
    }

    /**
     * 修改物品管理
     * 
     * @param item 物品管理
     * @return 结果
     */
    @Override
    public int updateItem(Item item)
    {
        item.setUpdateTime(DateUtils.getNowDate());
        return itemMapper.updateItem(item);
    }

    /**
     * 批量删除物品管理
     * 
     * @param ids 需要删除的物品管理主键
     * @return 结果
     */
    @Override
    public int deleteItemByIds(Long[] ids)
    {
        return itemMapper.deleteItemByIds(ids);
    }

    /**
     * 删除物品管理信息
     * 
     * @param id 物品管理主键
     * @return 结果
     */
    @Override
    public int deleteItemById(Long id)
    {
        return itemMapper.deleteItemById(id);
    }
}

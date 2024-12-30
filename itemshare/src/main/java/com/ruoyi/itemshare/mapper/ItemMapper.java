package com.ruoyi.itemshare.mapper;

import java.util.List;
import com.ruoyi.itemshare.domain.Item;

/**
 * 物品管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-30
 */
public interface ItemMapper 
{
    /**
     * 查询物品管理
     * 
     * @param id 物品管理主键
     * @return 物品管理
     */
    public Item selectItemById(Long id);

    /**
     * 查询物品管理列表
     * 
     * @param item 物品管理
     * @return 物品管理集合
     */
    public List<Item> selectItemList(Item item);

    /**
     * 新增物品管理
     * 
     * @param item 物品管理
     * @return 结果
     */
    public int insertItem(Item item);

    /**
     * 修改物品管理
     * 
     * @param item 物品管理
     * @return 结果
     */
    public int updateItem(Item item);

    /**
     * 删除物品管理
     * 
     * @param id 物品管理主键
     * @return 结果
     */
    public int deleteItemById(Long id);

    /**
     * 批量删除物品管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteItemByIds(Long[] ids);
}

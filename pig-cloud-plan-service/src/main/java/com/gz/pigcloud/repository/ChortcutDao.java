package com.gz.pigcloud.repository;
import com.gz.pigcloud.domain.Chortcut;
import java.util.List;
import com.gz.pigcloud.common.Assist;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ChortcutDao{
	
	/**
	 * 
	* @Description: 自定义 根据uid获取系统自带Chortcut(已经在用户列表中不获取)
	* @param  参数说明
	* @return List<Chortcut>    返回类型
	* @author gaozhen
	 */
	List<Chortcut> selectSystemChortcutByUid(int uid);
	
	/**
	 * 
	* @Description: 自定义 根据uid获取Chortcut
	* @param  参数说明
	* @return List<Chortcut>    返回类型
	* @author gaozhen
	 */
	List<Chortcut> selectChortcutByUid(int uid);
	
	/**
	 * 获得Chortcut数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getChortcutRowCount(Assist assist);
	/**
	 * 获得Chortcut数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<Chortcut> selectChortcut(Assist assist);
	/**
	 * 获得一个Chortcut对象,以参数Chortcut对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Chortcut selectChortcutByObj(Chortcut obj);
	/**
	 * 通过Chortcut的id获得Chortcut对象
	 * @param id
	 * @return
	 */
    Chortcut selectChortcutById(Integer id);
	/**
	 * 插入Chortcut到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertChortcut(Chortcut value);
	/**
	 * 插入Chortcut中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyChortcut(Chortcut value);
	/**
	 * 批量插入Chortcut到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertChortcutByBatch(List<Chortcut> value);
	/**
	 * 通过Chortcut的id删除Chortcut
	 * @param id
	 * @return
	 */
    int deleteChortcutById(Integer id);
	/**
	 * 通过辅助工具Assist的条件删除Chortcut
	 * @param assist
	 * @return
	 */
    int deleteChortcut(Assist assist);
	/**
	 * 通过Chortcut的id更新Chortcut中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateChortcutById(Chortcut enti);
 	/**
	 * 通过辅助工具Assist的条件更新Chortcut中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateChortcut(@Param("enti") Chortcut value, @Param("assist") Assist assist);
	/**
	 * 通过Chortcut的id更新Chortcut中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyChortcutById(Chortcut enti);
 	/**
	 * 通过辅助工具Assist的条件更新Chortcut中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyChortcut(@Param("enti") Chortcut value, @Param("assist") Assist assist);
}
package com.gz.pigcloud.repository;
import com.gz.pigcloud.domain.Readlater;
import java.util.List;
import com.gz.pigcloud.common.Assist;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ReadlaterDao{
	/**
	 * 获得Readlater数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getReadlaterRowCount(Assist assist);
	/**
	 * 获得Readlater数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<Readlater> selectReadlater(Assist assist);
	/**
	 * 获得一个Readlater对象,以参数Readlater对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Readlater selectReadlaterByObj(Readlater obj);
	/**
	 * 通过Readlater的id获得Readlater对象
	 * @param id
	 * @return
	 */
    Readlater selectReadlaterById(Integer id);
	/**
	 * 插入Readlater到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertReadlater(Readlater value);
	/**
	 * 插入Readlater中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyReadlater(Readlater value);
	/**
	 * 批量插入Readlater到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertReadlaterByBatch(List<Readlater> value);
	/**
	 * 通过Readlater的id删除Readlater
	 * @param id
	 * @return
	 */
    int deleteReadlaterById(Integer id);
	/**
	 * 通过辅助工具Assist的条件删除Readlater
	 * @param assist
	 * @return
	 */
    int deleteReadlater(Assist assist);
	/**
	 * 通过Readlater的id更新Readlater中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateReadlaterById(Readlater enti);
 	/**
	 * 通过辅助工具Assist的条件更新Readlater中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateReadlater(@Param("enti") Readlater value, @Param("assist") Assist assist);
	/**
	 * 通过Readlater的id更新Readlater中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyReadlaterById(Readlater enti);
 	/**
	 * 通过辅助工具Assist的条件更新Readlater中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyReadlater(@Param("enti") Readlater value, @Param("assist") Assist assist);
}
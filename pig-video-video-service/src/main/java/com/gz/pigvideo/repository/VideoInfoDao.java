package com.gz.pigvideo.repository;

import com.gz.pigvideo.common.Assist;
import com.gz.pigvideo.domain.VideoInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface VideoInfoDao {
	
	/**
	 * 
	* @Description: 获取大于date的video的数量
	* @param  参数说明
	* @return Map<String,Integer>    返回类型
	* @author gaozhen
	 */
	List<Integer> selectCountGreaterDate(@Param("date")String date);
	
	/**
	 * 获得VideoInfo数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	long getVideoInfoRowCount(Assist assist);

	/**
	 * 获得VideoInfo数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * 
	 * @param assist
	 * @return
	 */
	List<VideoInfo> selectVideoInfo(Assist assist);

	/**
	 * 获得一个VideoInfo对象,以参数VideoInfo对象中不为空的属性作为条件进行查询
	 * 
	 * @param obj
	 * @return
	 */
	VideoInfo selectVideoInfoByObj(VideoInfo obj);

	/**
	 * 通过VideoInfo的id获得VideoInfo对象
	 * 
	 * @param id
	 * @return
	 */
	VideoInfo selectVideoInfoById(Long id);

	/**
	 * 插入VideoInfo到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertVideoInfo(VideoInfo value);

	/**
	 * 插入VideoInfo中属性值不为null的数据到数据库
	 * 
	 * @param value
	 * @return
	 */
	int insertNonEmptyVideoInfo(VideoInfo value);

	/**
	 * 批量插入VideoInfo到数据库,包括null值
	 * 
	 * @param value
	 * @return
	 */
	int insertVideoInfoByBatch(List<VideoInfo> value);

	/**
	 * 通过VideoInfo的id删除VideoInfo
	 * 
	 * @param id
	 * @return
	 */
	int deleteVideoInfoById(Long id);

	/**
	 * 通过辅助工具Assist的条件删除VideoInfo
	 * 
	 * @param assist
	 * @return
	 */
	int deleteVideoInfo(Assist assist);

	/**
	 * 通过VideoInfo的id更新VideoInfo中的数据,包括null值
	 * 
	 * @param enti
	 * @return
	 */
	int updateVideoInfoById(VideoInfo enti);

	/**
	 * 通过辅助工具Assist的条件更新VideoInfo中的数据,包括null值
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateVideoInfo(@Param("enti") VideoInfo value, @Param("assist") Assist assist);

	/**
	 * 通过VideoInfo的id更新VideoInfo中属性不为null的数据
	 * 
	 * @param enti
	 * @return
	 */
	int updateNonEmptyVideoInfoById(VideoInfo enti);

	/**
	 * 通过辅助工具Assist的条件更新VideoInfo中属性不为null的数据
	 * 
	 * @param value
	 * @param assist
	 * @return
	 */
	int updateNonEmptyVideoInfo(@Param("enti") VideoInfo value, @Param("assist") Assist assist);
}
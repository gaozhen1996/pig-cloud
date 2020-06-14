package com.gz.pigvideo.repository;
import com.gz.pigvideo.domain.UserActivity;
import java.util.List;
import com.gz.pigvideo.common.Assist;
import org.apache.ibatis.annotations.Param;
public interface UserActivityDao{
	/**
	 * 获得UserActivity数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getUserActivityRowCount(Assist assist);
	/**
	 * 获得UserActivity数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<UserActivity> selectUserActivity(Assist assist);
	/**
	 * 获得一个UserActivity对象,以参数UserActivity对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    UserActivity selectUserActivityByObj(UserActivity obj);
	/**
	 * 通过UserActivity的id获得UserActivity对象
	 * @param id
	 * @return
	 */
    UserActivity selectUserActivityById(Long id);
	/**
	 * 插入UserActivity到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertUserActivity(UserActivity value);
	/**
	 * 插入UserActivity中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyUserActivity(UserActivity value);
	/**
	 * 批量插入UserActivity到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertUserActivityByBatch(List<UserActivity> value);
	/**
	 * 通过UserActivity的id删除UserActivity
	 * @param id
	 * @return
	 */
    int deleteUserActivityById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除UserActivity
	 * @param assist
	 * @return
	 */
    int deleteUserActivity(Assist assist);
	/**
	 * 通过UserActivity的id更新UserActivity中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateUserActivityById(UserActivity enti);
 	/**
	 * 通过辅助工具Assist的条件更新UserActivity中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateUserActivity(@Param("enti") UserActivity value, @Param("assist") Assist assist);
	/**
	 * 通过UserActivity的id更新UserActivity中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyUserActivityById(UserActivity enti);
 	/**
	 * 通过辅助工具Assist的条件更新UserActivity中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyUserActivity(@Param("enti") UserActivity value, @Param("assist") Assist assist);
}
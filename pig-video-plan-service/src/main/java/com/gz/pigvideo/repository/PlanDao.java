package com.gz.pigvideo.repository;
import com.gz.pigvideo.domain.Plan;
import java.util.List;
import com.gz.pigvideo.common.Assist;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PlanDao{
	/**
	 * 获得Plan数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getPlanRowCount(Assist assist);
	/**
	 * 获得Plan数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<Plan> selectPlan(Assist assist);
	/**
	 * 获得一个Plan对象,以参数Plan对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Plan selectPlanByObj(Plan obj);
	/**
	 * 通过Plan的id获得Plan对象
	 * @param id
	 * @return
	 */
    Plan selectPlanById(Integer id);
	/**
	 * 插入Plan到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertPlan(Plan value);
	/**
	 * 插入Plan中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyPlan(Plan value);
	/**
	 * 批量插入Plan到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertPlanByBatch(List<Plan> value);
	/**
	 * 通过辅助工具Assist的条件删除Plan
	 * @param assist
	 * @return
	 */
    int deletePlan(Assist assist);
	/**
	 * 通过Plan的id更新Plan中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updatePlanById(Plan enti);
 	/**
	 * 通过辅助工具Assist的条件更新Plan中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updatePlan(@Param("enti") Plan value, @Param("assist") Assist assist);
	/**
	 * 通过Plan的id更新Plan中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyPlanById(Plan enti);
 	/**
	 * 通过辅助工具Assist的条件更新Plan中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyPlan(@Param("enti") Plan value, @Param("assist") Assist assist);
 
    /**************************************
     *  自定义 替换了deletePlanById方法      *
     **************************************/
    
	/**
	 * 
	* @Description: 修改plan的type
	* @param  参数说明
	* @return void    返回类型
	* @author gaozhen
	 */
	void updatePlanType(@Param("new") Plan newPlan, @Param("old") Plan oldPlan);
	
	/**
	 * 通过Plan的id删除Plan
	 * @param id
	 * @return
	 */
    int deletePlanById(Plan value);
}
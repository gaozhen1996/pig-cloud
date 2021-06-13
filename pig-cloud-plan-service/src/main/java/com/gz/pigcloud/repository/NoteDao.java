package com.gz.pigcloud.repository;
import com.gz.pigcloud.domain.Note;
import java.util.List;
import com.gz.pigcloud.common.Assist;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface NoteDao{
	/**
	 * 获得Note数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getNoteRowCount(Assist assist);
	/**
	 * 获得Note数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<Note> selectNote(Assist assist);
	/**
	 * 获得一个Note对象,以参数Note对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Note selectNoteByObj(Note obj);
	/**
	 * 通过Note的id获得Note对象
	 * @param id
	 * @return
	 */
    Note selectNoteById(Integer id);
	/**
	 * 插入Note到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertNote(Note value);
	/**
	 * 插入Note中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyNote(Note value);
	/**
	 * 批量插入Note到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertNoteByBatch(List<Note> value);
	/**
	 * 通过Note的id删除Note
	 * @param id
	 * @return
	 */
    int deleteNoteById(Integer id);
	/**
	 * 通过辅助工具Assist的条件删除Note
	 * @param assist
	 * @return
	 */
    int deleteNote(Assist assist);
	/**
	 * 通过Note的id更新Note中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateNoteById(Note enti);
 	/**
	 * 通过辅助工具Assist的条件更新Note中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNote(@Param("enti") Note value, @Param("assist") Assist assist);
	/**
	 * 通过Note的id更新Note中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyNoteById(Note enti);
 	/**
	 * 通过辅助工具Assist的条件更新Note中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyNote(@Param("enti") Note value, @Param("assist") Assist assist);
}
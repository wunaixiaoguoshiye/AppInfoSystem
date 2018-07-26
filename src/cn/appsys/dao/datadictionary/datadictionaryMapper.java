package cn.appsys.dao.datadictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DataDictionary;

/**
 * 数据字典接口
 * @author Administrator
 *
 */
public interface datadictionaryMapper {
	/**
	 * 根据类型编号查询数据字典表
	 * @param typeCode
	 * @return
	 */
	public List<DataDictionary> getDataDictionaryList(@Param("typeCode")String typeCode);
}

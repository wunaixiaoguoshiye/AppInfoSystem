package cn.appsys.service.datadictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DataDictionary;

public interface DataDictionaryService {
	/**
	 * 根据类型编号查询数据字典表
	 * @param typeCode
	 * @return
	 */
	public List<DataDictionary> getDataDictionaryList(String typeCode);
}

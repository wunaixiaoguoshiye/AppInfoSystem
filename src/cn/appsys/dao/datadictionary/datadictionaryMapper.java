package cn.appsys.dao.datadictionary;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.DataDictionary;

/**
 * �����ֵ�ӿ�
 * @author Administrator
 *
 */
public interface datadictionaryMapper {
	/**
	 * �������ͱ�Ų�ѯ�����ֵ��
	 * @param typeCode
	 * @return
	 */
	public List<DataDictionary> getDataDictionaryList(@Param("typeCode")String typeCode);
}

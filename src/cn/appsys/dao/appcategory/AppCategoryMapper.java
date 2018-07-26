package cn.appsys.dao.appcategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;

/**
 * ���༶��ӿ�
 * @author Administrator
 *
 */
public interface AppCategoryMapper {
	/**
	 * ������һ���ļ�����࣬��ѯ��һ���ļ������
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId")Integer parentId) throws Exception;
}

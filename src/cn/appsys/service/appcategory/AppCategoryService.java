package cn.appsys.service.appcategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;

/**
 * ���༶��ӿ�
 * @author Administrator
 *
 */
public interface AppCategoryService {
	/**
	 * ������һ���ļ�����࣬��ѯ��һ���ļ������
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId) throws Exception;
}

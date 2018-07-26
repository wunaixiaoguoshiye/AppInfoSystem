package cn.appsys.service.appcategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;

/**
 * 分类级别接口
 * @author Administrator
 *
 */
public interface AppCategoryService {
	/**
	 * 根据上一级的级别分类，查询下一级的级别分类
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId) throws Exception;
}

package cn.appsys.dao.appcategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.AppCategory;

/**
 * 分类级别接口
 * @author Administrator
 *
 */
public interface AppCategoryMapper {
	/**
	 * 根据上一级的级别分类，查询下一级的级别分类
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId")Integer parentId) throws Exception;
}

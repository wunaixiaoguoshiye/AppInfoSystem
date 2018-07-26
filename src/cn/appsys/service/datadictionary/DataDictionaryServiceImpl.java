package cn.appsys.service.datadictionary;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.datadictionary.datadictionaryMapper;
import cn.appsys.pojo.DataDictionary;


@Service
public class DataDictionaryServiceImpl implements DataDictionaryService{
	@Resource
	private datadictionaryMapper datadictionaryMapper;

	@Override
	public List<DataDictionary> getDataDictionaryList(String typeCode) {
		// TODO Auto-generated method stub
		return datadictionaryMapper.getDataDictionaryList(typeCode);
	}
	
	
}

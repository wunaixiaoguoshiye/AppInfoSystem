package cn.appsys.pojo;

import java.util.Date;

/**
 * app��Ϣʵ����
 * @author Administrator
 *
 */
public class AppInfo {
	private int id;						//����id
	private String softwareName;		//�������
	private String APKName;				//APK���ƣ�Ψһ��
	private String supportROM;			//֧��ROM
	private String interfaceLanguage;	//��������
	private double softwareSize;		//�����С����λ��M��
	private Date updateDate;			//��������
	private int devId;					//������id����Դ�ڣ�dev_user��Ŀ�����id��
	private String appInfo;				//Ӧ�ü��
	private int status;					//״̬����Դ�ڣ�data_dictionary��1 ����� 2 ���ͨ�� 3 ��˲�ͨ�� 4 ���ϼ� 5 ���¼ܣ�
	private Date onSaleDate;			//�ϼ�ʱ��
	private Date offSaleDate;			//�¼�ʱ��
	private int flatformId;				//����ƽ̨����Դ�ڣ�data_dictionary��1 �ֻ� 2 ƽ�� 3 ͨ�ã�
	private int categoryLevel3;			//�����������ࣨ��Դ�ڣ�data_dictionary��
	private int downloads;				//����������λ���Σ�
	private int createdBy;				//�����ߣ���Դ��dev_user��������Ϣ����û�id��
	private Date creationDate;			//����ʱ��
	private int modifyBy;				//�����ߣ���Դ��dev_user��������Ϣ����û�id��
	private Date modifyDate;			//���¸���ʱ��
	private int categoryLevel1;			//����һ�����ࣨ��Դ�ڣ�data_dictionary��
	private int categoryLevel2;			//�����������ࣨ��Դ�ڣ�data_dictionary��
	private String logoPicPath;			//LOGOͼƬurl·��
	private String logoLocPath;			//LOGOͼƬ�ķ������洢·��
	private int versionId;				//���µİ汾id
	
	private String statusName;//app״̬����
	private String flatformName;//app����ƽ̨����
	private String categoryLevel3Name;//����������������
	private String devName;//����������
	private String categoryLevel1Name;//����һ����������
	private String categoryLevel2Name;//����������������
	private String versionNo;//���µİ汾��
	
	

	
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getFlatformName() {
		return flatformName;
	}
	public void setFlatformName(String flatformName) {
		this.flatformName = flatformName;
	}
	public String getCategoryLevel3Name() {
		return categoryLevel3Name;
	}
	public void setCategoryLevel3Name(String categoryLevel3Name) {
		this.categoryLevel3Name = categoryLevel3Name;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getCategoryLevel1Name() {
		return categoryLevel1Name;
	}
	public void setCategoryLevel1Name(String categoryLevel1Name) {
		this.categoryLevel1Name = categoryLevel1Name;
	}
	public String getCategoryLevel2Name() {
		return categoryLevel2Name;
	}
	public void setCategoryLevel2Name(String categoryLevel2Name) {
		this.categoryLevel2Name = categoryLevel2Name;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	public Date getOnSaleDate() {
		return onSaleDate;
	}
	public void setOnSaleDate(Date onSaleDate) {
		this.onSaleDate = onSaleDate;
	}
	public Date getOffSaleDate() {
		return offSaleDate;
	}
	public void setOffSaleDate(Date offSaleDate) {
		this.offSaleDate = offSaleDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSoftwareName() {
		return softwareName;
	}
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	public String getAPKName() {
		return APKName;
	}
	public void setAPKName(String aPKName) {
		APKName = aPKName;
	}
	public String getSupportROM() {
		return supportROM;
	}
	public void setSupportROM(String supportROM) {
		this.supportROM = supportROM;
	}
	public String getInterfaceLanguage() {
		return interfaceLanguage;
	}
	public void setInterfaceLanguage(String interfaceLanguage) {
		this.interfaceLanguage = interfaceLanguage;
	}
	public double getSoftwareSize() {
		return softwareSize;
	}
	public void setSoftwareSize(double softwareSize) {
		this.softwareSize = softwareSize;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	public String getAppInfo() {
		return appInfo;
	}
	public void setAppInfo(String appInfo) {
		this.appInfo = appInfo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getFlatformId() {
		return flatformId;
	}
	public void setFlatformId(int flatformId) {
		this.flatformId = flatformId;
	}
	public int getCategoryLevel3() {
		return categoryLevel3;
	}
	public void setCategoryLevel3(int categoryLevel3) {
		this.categoryLevel3 = categoryLevel3;
	}
	public int getDownloads() {
		return downloads;
	}
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getCategoryLevel1() {
		return categoryLevel1;
	}
	public void setCategoryLevel1(int categoryLevel1) {
		this.categoryLevel1 = categoryLevel1;
	}
	public int getCategoryLevel2() {
		return categoryLevel2;
	}
	public void setCategoryLevel2(int categoryLevel2) {
		this.categoryLevel2 = categoryLevel2;
	}
	public String getLogoPicPath() {
		return logoPicPath;
	}
	public void setLogoPicPath(String logoPicPath) {
		this.logoPicPath = logoPicPath;
	}
	public String getLogoLocPath() {
		return logoLocPath;
	}
	public void setLogoLocPath(String logoLocPath) {
		this.logoLocPath = logoLocPath;
	}
	public int getVersionId() {
		return versionId;
	}
	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}
	
	
	
}
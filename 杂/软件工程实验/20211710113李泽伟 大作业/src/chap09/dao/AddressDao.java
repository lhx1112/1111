package chap09.dao;


import chap09.entity.Area;
import chap09.entity.City;
import chap09.entity.Province;

import java.util.List;

public interface AddressDao {
	
	public List<Province> getProvinces();
	public List<City> getCitesByProvince(String provinceCode);
	public List<Area> getAreasByCity(String cityCode);
	
}

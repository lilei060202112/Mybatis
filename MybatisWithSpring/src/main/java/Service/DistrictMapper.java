package Service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import common.District;

public interface DistrictMapper {
	
	public List<District> getDistrict(@Param(value="code") long code);
	public void insertDistrict(District district);
	
}

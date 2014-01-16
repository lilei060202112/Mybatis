package Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Util.MybatisUtil;
import common.City;
import common.District;

public class InsertService {
	private static SelectService selectService;
	private final static SqlSessionFactory factory;
	private final static  InsertService is = new InsertService();
	static {
		selectService = SelectService.getInstance();
		factory = MybatisUtil.getSqlSessionFactory("postgres");
	}
	
	public static InsertService getInstance() {
		return is;
	}
	
	public void insertOperation() {
		SqlSession session = null;
		try {
			session = factory.openSession();
			List<City> citys = selectService.getCity();
			CityMapper cityMapper = session.getMapper(CityMapper.class);
			for(City city: citys) {
				cityMapper.insertCity(city);
				session.commit();//手动提交
				insertDistrict(city);
				
			}
			
		} finally {
			session.close();
		}
		
	}
	
	private void insertDistrict(City city) {
		SqlSession session = null;
		try {
			session = factory.openSession();  
			long code = city.getCode();
			String string = String.valueOf(code);
			String pattern = "\\d{3}[1-9]00";
			String pattern2 = "\\d{2}[1-9]000";
			String newstr = null;
			
			if (string.matches(pattern)) {			
				newstr = string.substring(0, 4);
				
			} else if (string.matches(pattern2)) {
				newstr = string.substring(0, 3);
				
			} else {
				newstr = string.substring(0, 2);
				
			}
			long newcode = Long.parseLong(newstr);
			List<District> districts = selectService.getDistrict(newcode);
			DistrictMapper districtMapper = session.getMapper(DistrictMapper.class);
			for(District district: districts) {
				district.setCity(city);
				districtMapper.insertDistrict(district);
				
			}
			session.commit();
		} finally {
			session.close();
		}
		
	}
	
}

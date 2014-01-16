package Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import Util.MybatisUtil;
import common.City;
import common.District;

public class SelectService {

	private final static SelectService ss = new SelectService();
	private final static SqlSessionFactory factory;
	static {
		factory = MybatisUtil.getSqlSessionFactory("palmap");
	}
	//静态工厂方法--一般为了确保限定数量，ss都是final修饰的
	public static SelectService getInstance() {
		return ss;
	}
	
	public List<City> getCity() {
		SqlSession session = null;
		List<City> citys = null;
		try {
			session = factory.openSession();
			CityMapper cityMapper = session.getMapper(CityMapper.class);
			citys = cityMapper.getCity();
		} finally {
			session.close();
		}	
		return citys;		
	}
	
	public List<District> getDistrict(long id) {
		SqlSession session = null;
		List<District> districts = null;
		try {
			session = factory.openSession();
			DistrictMapper districtMapper = session.getMapper(DistrictMapper.class);
			districts = districtMapper.getDistrict(id);
		
		} finally {
			session.close();
		}
		
		return districts;
	}
	
	
}

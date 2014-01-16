package common;

import java.util.List;

import javax.annotation.Resource;

import mapper.FloorMapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

//这里直接将FloorMapper看做DAO接口
public class FloorDAOImpl implements FloorMapper {
	
	
	private SqlSession sqlSession;//在DAO的实现类中使用SqlSeesionTemplate
	/*private FloorMapper floorMapper;在DAO实现类中使用映射器，代替手工使用 SqlSessionDaoSupport 
	 * 或 SqlSessionTemplate 编写数据访问对象 (DAO)的代码*/
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<FloorEntity> selectFloor() {
		FloorMapper floorMapper = sqlSession.getMapper(FloorMapper.class);
		List<FloorEntity> floorlists = floorMapper.selectFloor();
		return floorlists;
	}

	/*public FloorMapper getFloorMapper() {
		return floorMapper;
	}

	public void setFloorMapper(FloorMapper floorMapper) {
		this.floorMapper = floorMapper;
	}
*/
}

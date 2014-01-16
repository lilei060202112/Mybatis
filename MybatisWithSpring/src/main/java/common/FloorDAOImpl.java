package common;

import java.util.List;

import javax.annotation.Resource;

import mapper.FloorMapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

//����ֱ�ӽ�FloorMapper����DAO�ӿ�
public class FloorDAOImpl implements FloorMapper {
	
	
	private SqlSession sqlSession;//��DAO��ʵ������ʹ��SqlSeesionTemplate
	/*private FloorMapper floorMapper;��DAOʵ������ʹ��ӳ�����������ֹ�ʹ�� SqlSessionDaoSupport 
	 * �� SqlSessionTemplate ��д���ݷ��ʶ��� (DAO)�Ĵ���*/
	
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

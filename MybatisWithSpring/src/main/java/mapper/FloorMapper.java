
package mapper;

import java.util.List;

import common.FloorEntity;

//这里直接将FloorMapper看做DAO接口
public interface FloorMapper {
	
	public List<FloorEntity> selectFloor();
	
}

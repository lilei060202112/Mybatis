import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.FloorDAOImpl;
import common.FloorEntity;

//
public class Test {
	
	public static void main(String[] args) throws IOException {
		/*InsertService is = InsertService.getInstance();
		is.insertOperation();
		System.out.println("Íê³É");*/
		/*Properties properties = new Properties();
		FileInputStream in = new FileInputStream("postgresql.properties");
		properties.load(in);
		properties.setProperty(key, value)*/
		
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		FloorDAOImpl floorDAOImpl = (FloorDAOImpl)context.getBean("floorDAO");
		List<FloorEntity> lists = floorDAOImpl.selectFloor();
		for(FloorEntity floor: lists) {
			System.out.println(floor.getName());
		}
		
		
}
	
}

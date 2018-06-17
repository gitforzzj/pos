package testDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.z4group.pos.dao.impl.DishDaoImpl;
import com.z4group.pos.domain.Dish;

public class TestBaseDaoImpl {

	
	
	@Test
	public void addDish() throws Exception {
		ApplicationContext ap = new FileSystemXmlApplicationContext("C:\\Users\\zheng\\git\\pos\\pos-parent\\pos-web\\src\\main\\resources\\applicationContext.xml");
		DishDaoImpl dishDao= (DishDaoImpl ) ap.getBean("dishDaoImpl");  
		Dish dish = new Dish("a1111","鸡腿", "份", 6.0);
		
		dishDao.save(dish);
	}
	
	@Test
	public void editDish() throws Exception {
		
	}
	@Test
	public void delDish() throws Exception {
		
	}
	@Test
	public void findDish() throws Exception {
		
	}
	
}

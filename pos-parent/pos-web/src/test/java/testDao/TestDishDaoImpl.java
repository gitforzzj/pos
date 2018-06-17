package testDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.z4group.pos.dao.IDishDao;
import com.z4group.pos.domain.Dish;

  
   
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations ="classpath:applicationContext.xml")  
public class TestDishDaoImpl {
	    @Autowired  
	    private IDishDao dishDao;  
		@Test
		public void addDish() throws Exception {
			Dish dish = new Dish("a1111","鸡腿", "份", 6.0);
			dishDao.save(dish);
		}
		@Test
		public void editDish() throws Exception {
			Dish dish = dishDao.findById("a1111");
			dish.setDishname("烧鸡");
			dishDao.update(dish);
		}
		@Test
		public void delDish() throws Exception {
			 dishDao.deleteById("a1111");
		}
		@Test
		public void findDish() throws Exception {
			 Dish dish = dishDao.findById("a1111");
			 System.out.println(dish.getDishname()+","+dish.getPrice());
		}
	
	      
	  
	
}

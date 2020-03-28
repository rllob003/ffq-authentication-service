package edu.fiu.ffqr.dataloader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fiu.ffqr.controller.SysUserController;
import edu.fiu.ffqr.controller.UserController;
import edu.fiu.ffqr.models.SysUser;
import edu.fiu.ffqr.models.User;
import edu.fiu.ffqr.repositories.SysUsersRepository;
import edu.fiu.ffqr.repositories.UsersRepository;

@Component
public class DataLoader {

	private SysUsersRepository sysUsersRepository;  //Added to test for user system
	private UserController userController;   //Added to test for User
	private UsersRepository userRepository;
	private SysUserController sysUserController;   //Added to test for User

	
	
	
	public DataLoader(SysUsersRepository sysUsersRepository, SysUserController sysUserController,
			UserController userController, UsersRepository userRepository) { //Added extra parameter (SysUsersRepository sysUsersRepository)
		this.sysUsersRepository = sysUsersRepository;  //Added for users test
		this.sysUserController = sysUserController;    //Added for users test
		this.userController = userController;      	   //Added for users test
		this.userRepository = userRepository;
	}
	
	
	//Added whole function to load users into db (test)
	public void loadSysUsersService() {
		System.out.println("<------- Loading System Users... ------->");
			
		this.sysUsersRepository.deleteAll();
		
		try {
		
			String resourceName = "SysUserPayload.json";		
		
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream(resourceName);
			JSONParser jsonParser = new JSONParser();		
			JSONArray jsonArray = (JSONArray) jsonParser
				.parse(new InputStreamReader(inputStream));
			ObjectMapper mapper = new ObjectMapper();
			List<SysUser> sysUserList = new ArrayList<>();
		
			for (Object object : jsonArray) {
				JSONObject jsonObject = (JSONObject) object;
				SysUser item = mapper.readValue(jsonObject.toString(), SysUser.class);
				sysUserList.add(item);
			}
			
			for(SysUser item : sysUserList) {
				System.out.println(item.getSysUsername() + "---- Loaded!");
				this.sysUserController.createSysUsers(item);
			}
		} catch (Exception e) {
			System.err.println("An error occurred while loading System Food Items Recommendations: ");
			e.printStackTrace();
		}		

	}

	public void load() {
		System.out.println("<------- Loading Users... ------->");
			
		this.userRepository.deleteAll();
		
		try {
		
			String resourceName = "UserPayload.json";		
		
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream(resourceName);
			JSONParser jsonParser = new JSONParser();		
			JSONArray jsonArray = (JSONArray) jsonParser
				.parse(new InputStreamReader(inputStream));
			ObjectMapper mapper = new ObjectMapper();
			List<User> userList = new ArrayList<>();
		
			for (Object object : jsonArray) {
				JSONObject jsonObject = (JSONObject) object;
				User item = mapper.readValue(jsonObject.toString(), User.class);
				userList.add(item);
			}
			
			for(User item : userList) {
				System.out.println(item.getUsername() + "---- Loaded!");
				this.userController.create(item);
			}
		} catch (Exception e) {
			System.err.println("An error occurred while loading System Food Items Recommendations: ");
			e.printStackTrace();
		}		

	}
	
	/*public void load() {
		System.out.println("Loading fooditems...");
		try {
			String resourceName = "FoodItemPayload.json";
			
			this.foodRepository.deleteAll();
			this.nutrientRepository.deleteAll();
			ExcelDataLoad loader = new ExcelDataLoad(this.nutrientService);
			loader.dataLoad();
			
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream(resourceName);
			JSONParser jsonParser = new JSONParser();		
			JSONArray jsonArray = (JSONArray) jsonParser
					.parse(new InputStreamReader(inputStream));
			ObjectMapper mapper = new ObjectMapper();
			List<FoodItem> foodList = new ArrayList<>();
			
			for (Object object : jsonArray) {
				JSONObject jsonObject = (JSONObject) object;
				FoodItem item = mapper.readValue(jsonObject.toString(), FoodItem.class);
				foodList.add(item);
			}
			for(FoodItem item : foodList) {
				this.foodItemController.create(item);
			}			
			System.out.println("A total of " + foodList.size() + " food items were added to food_items collection");
			
		} catch (Exception e) {
			System.err.println("An error occurred while loading food items: ");
			e.printStackTrace();
		}
			
		System.out.println("...Loading complete!");	
	}
*/
	
	
}

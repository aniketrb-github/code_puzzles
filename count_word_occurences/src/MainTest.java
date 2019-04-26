import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.dataModel.Task;

public class MainTest {

	public static void main(String[] args) {
		List<Task> list = new ArrayList<Task>();
		
		for (int i = 0; i < 10; i++) {
			list.add(new Task(i, "Test_"+i, "Test_"+i, Task.Status.ASSIGNED, 10));
		}
		
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Type type = new TypeToken< List<Task> > () {}.getType();
		
		// converts the 'list' JavaObject toJson String Object 'json'
		String jsonString = gson.toJson(list, type);
		
		System.out.println("JSON STRING : "+jsonString+"\n\n");
		
		//converts from JSON to JAVA
		List<Task> fromJson = gson.fromJson(jsonString, type);

		for (Task task : fromJson) {
			System.out.println(task);
		}
	}

}

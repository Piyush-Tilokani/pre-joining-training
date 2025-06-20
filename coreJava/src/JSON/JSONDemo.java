package JSON;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class JSONDemo {
    public static void main(String[] args) {
        // 1. Create JSON Object
        JSONObject employee = new JSONObject();
        employee.put("id", 101);
        employee.put("name", "Piyush");
        employee.put("department", "Engineering");
        employee.put("isPermanent", true);

        // 2. Add Array to JSON
        JSONArray skills = new JSONArray();
        skills.put("Java");
        skills.put("Python");
        skills.put("SQL");
        employee.put("skills", skills);

        // 3. Add Nested JSON Object
        JSONObject address = new JSONObject();
        address.put("city", "Pune");
        address.put("state", "Maharashtra");
        address.put("zip", "411001");

        employee.put("address", address);

        // 4. Print the JSON (pretty format)
        System.out.println("Original JSON:\n" + employee.toString(4));

        // 5. Access values
        System.out.println("\nAccessed values:");
        System.out.println("Name: " + employee.getString("name"));
        System.out.println("City: " + employee.getJSONObject("address").getString("city"));
        System.out.println("First Skill: " + employee.getJSONArray("skills").getString(0));

        // 6. Update existing field
        employee.put("department", "Product Engineering");
        System.out.println("\nAfter updating department:\n" + employee.toString(4));

        // 7. Add a new field
        employee.put("experienceYears", 4);
        System.out.println("\nAfter adding experienceYears:\n" + employee.toString(4));

        // 8. Remove a field
        employee.remove("isPermanent");
        System.out.println("\nAfter removing isPermanent:\n" + employee.toString(4));

        // 9. Iterate over keys
        System.out.println("\nIterating over keys:");
        for (String key : employee.keySet()) {
            System.out.println(key + " : " + employee.get(key));
        }

        // 10. Check if a key exists
        if (employee.has("experienceYears")) {
            System.out.println("\nExperience found: " + employee.getInt("experienceYears"));
        }

        // 11. Error handling using try-catch
        try {
            String email = employee.getString("email"); // This key doesn't exist
        } catch (JSONException e) {
            System.out.println("\nCaught JSONException: " + e.getMessage());
        }
    }
}
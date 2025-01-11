
package json;

import com.google.gson.Gson;
import models.DataModel;
import models.UserModel;


public class JSONConverters {
  protected static  final Gson gson = new Gson();
  
   public static String userModelToJson(UserModel userModel) {
        return gson.toJson(userModel);
    }
   
    public static UserModel jsonToUserModel(String json) {
        return gson.fromJson(json, UserModel.class);
    }
       public static DataModel jsonToDataModel(String json) {
        return gson.fromJson(json, DataModel.class);
    }
       public static String DataModelToJson(DataModel userModel) {
        return gson.toJson(userModel);
    }
   
  }
  


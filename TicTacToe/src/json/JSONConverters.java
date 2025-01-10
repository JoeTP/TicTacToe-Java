/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.google.gson.Gson;
import models.UserModel;


public class JSONConverters {
  protected static  final Gson gson = new Gson();
  
   public static String userModelToJson(UserModel userModel) {
        return gson.toJson(userModel);
    }

    public static UserModel jsonToUserModel(String json) {
        return gson.fromJson(json, UserModel.class);
    }
  }
  


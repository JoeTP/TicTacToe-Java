/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

/**
 *
 * @author Youssif
 */
public interface AppStrings {
    
    String START = "Start";
    String STOP = "Stop";
    String ONLINE = "Online";
    String OFFLINE = "Offline";
    
    
    /**
     * USER Columns Name
     */
    String USER_ID = "USER_ID";
    String USER_NAME = "USER_NAME";
    String USER_EMAIL = "USER_EMAIL";
    String USER_PASSWORD = "USER_PASSWORD";
    String USER_SCORE = "USER_SCORE";
    String USER_IMG = "USER_IMG";
    String NO_OF_GAMES = "NO_OF_GAMES";
    String NO_OF_WINS = "NO_OF_WINS";
    String NO_OF_LOSSES = "NO_OF_LOSSES";
    String IS_ONLINE = "IS_ONLINE";
    String IS_INGAME = "IS_INGAME";
    
    
    /**
     * GAME Columns Name
     */
    String GAME_ID = "GAME_ID";
    String USER_ONE_ID = "USER_ONE_ID";
    String USER_TWO_ID = "USER_TWO_ID";
    String WINNER_ID = "WINNER_ID";
    String PLAY_DATE_TIME = "PLAY_DATE_TIME";
    
    final String SIGNIN_DONE = "SIGNIN_DONE";
    final String SIGNIN_FAILED = "SIGNIN_FAILED";
    final String SIGNIN_ALREADY_FOUND = "SIGNIN_ALREADY_FOUND";
    final String SIGNUP_DONE = "SIGNUP_DONE";
    final String SIGNUP_FAILED = "SIGNUP_FAILED";
}

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
public interface AppString {

    /**
     * add your string here
     */
    String ONLINE = "Online";
    String OFFLINE = "Offline";
    String CONGRATS = "🎉Congratulations!";
    String BAD_LUCK = "Oops!";
    String WIN_LABLE = "    You Win!";
    String LOSE_LABLE = "   You Lose!";
    String APP_TITLE = "TicTacToe";

    String LOGO = "/assets/icons/icon.png";
    String GAME_BOARD_STYLE_FILE_PATH = "/tictactoe/offlinegameboard/fxmlofflinegameboard.css";
    String ONLINE_GAME_BOARD_STYLE_FILE_PATH = "/tictactoe/onlinegmaeboard/style.css";

    String GENERAL_STYLE_FILE_PATH = "/styling/generalStyle.css";

    String[] ICON_PATHS = {
        "/assets/icons/cat.png",
        "/assets/icons/robot.png",
        "/assets/icons/panda-bear.png",
        "/assets/icons/dinosaur.png",
        "/assets/icons/jaguar.png",
        "/assets/icons/turtle.png"
    };
    String SERVER_HOST = "127.0.0.1";
    final String SIGNIN_DONE = "SIGNIN_DONE";
    final String SIGNIN_FAILED = "SIGNIN_FAILED";
    final String SIGNIN_ALREADY_FOUND = "SIGNIN_ALREADY_FOUND";
    final String SIGNUP_DONE = "SIGNUP_DONE";
    final String SIGNUP_FAILED = "SIGNUP_FAILED";

    String WIN_VIDEO_URL = "/media/winVideo.mp4";
    String LOSE_VIDEO_URL = "/media/loseVideo.mp4";
    String DRAW_VIDEO_URL = "/media/drawVideo.mp4";
    
    String TOOLTIP = "write IP address of the device running server (leave it empty if you are running the server)";
    /**
     * add your paths here
     */
//    String HOME_SCREEN_PATH = 
}

<h1>ROCK PAPER SCISSORS GAME API</h1>
  
 This is the implementation of an api for the game Rock-Paper-Scissors.
 It provides two services:
 PLAY:
 The client sends player's name and player's play and the
 api responds if the player has won, lost or tied.
 LEADERBOARD:
 The api sends back the list of users who have played so far and their score
 
 The api has two endpoints that can be reached at:
 PLAY:<br/>
 [http://localhost:8080/rsp-game/gameapi/shoot](http://localhost:8080/rsp-game/gameapi/shoot)?player_name=<PLAYER_NAME>&play=<PLAY><br/>
 <br/>
  **<PLAYER_NAME>** should be replaced by the player's name
              This is case Sensitive. Also, the api will
             eliminate trailing spaces<br/>
             
  **<PLAY>** can be either "rock", "paper" or "scissors"
        This is case Insensitive. Also, the api will
        eliminate trailing spaces<br/>
  
 LEADERBOARD:
 [http://localhost:8080/rsp-game/gameapi/leaderboard](http://localhost:8080/rsp-game/gameapi/leaderboard)
  
  Note: a Postman collection for the previous request can be found at:
  `https://www.getpostman.com/collections/bf6eee0d4f79c523d0e3`
  
  
  RUNNING THE APPLICATION CODE TEST SUITE:
  
  For this, Maven should be installed first.
  Then, run in the terminal or command line:
  `mvn clean test`
  
  RUNNING THE APPLICATION
  
  This also requires Maven.
  In the terminal or command line run:
  `mvn tomcat7:run`
  
  Another option is to run
  `mvn clean package`
  which will, not only run the test suite, 
  but also create a file called `rsp-game.war`
  the target folder of the app, which can
  be used to run somewhere else. For instance,
  locating it in the webapps folder of tomcat server
  and running it.
  
  
  
 
 

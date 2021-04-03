//=============================================================================
// APIConnector.js
//=============================================================================

/*:
 * @plugindesc Provides connection to the RPGmakerMVMultiplayerAPI (https://github.com/rossfcowie/RPGmakerMVMultiplayerAPI)
 * @author Ross Cowie
 *
 * @help This plugin does not provide plugin commands.
 *
 * @param ServerUrl
 * @desc The server to connect to
 * @default http://localhost:8088
 *
 * 
 *
 * 
 */

var parameters = PluginManager.parameters('APIConnector');
var ServerUrl = parameters['ServerUrl'].toLowerCase();
var players = [{},{}];
var player = {
  "username":"usernamer",
  "x":5,
  "y":5,
  "mapID":1
}

async function postMyself(name) {
  player.username = name;
    const response = await fetch(ServerUrl+"/playerLocations", { 
      method: "Post",
      headers: {
          "Content-type": "application/json"
      },
      body: JSON.stringify(player)
      }).then((res)=>{
          if (res.status !== 200) {
            console.log(
              `Looks like there was a problem.Status Code: ${res.status}`
            );
            return;
          }
          res.json().then(data =>{player = data; console.log(player); });
        })
        .catch((err) =>{ console.log(err); return});
        
  };

async function getPlayers() {
  fetch(ServerUrl+"/playerLocations").then((res)=>{
    if (res.status !== 200) {
      console.log(
        `Looks like there was a problem.Status Code: ${res.status}`
      );
      return;
    }
    res.json()
    .then(data => {players = data;})
  }).catch((err) => console.log(err));
};

async function getAllPlayers(){
  getPlayers();
  Galv.SPAWN.clear($gameMap._mapId);
  console.log(players);
  console.log($gameMap._mapId);
  for (playera of players) {
    if($gameMap._mapId == playera.mapID)
    console.log(playera);
    if(playera.id ==player.id){

    }else{
    Galv.SPAWN.event(1,playera.x,playera.y);
    console.log(playera.id)
    $gameMap._events[$gameMap._lastSpawnEventId].mid =playera.id;
    console.log($gameMap._lastSpawnEventId)
    console.log($gameMap._events[$gameMap._lastSpawnEventId])
  }
  }
}

async function updateMyself(mapID,x,y) {
player.x = x;
player.y = y;
player.mapID = mapID;

  const response = await fetch(ServerUrl+"/playerLocations", { 
    method: "Put",
    headers: {
        "Content-type": "application/json"
    },
    body: JSON.stringify(player)
    }).then((res)=>{
        if (res.status !== 200) {
          console.log(
            `Looks like there was a problem.Status Code: ${res.status}`
          );
          return;
        }else{
          console.log(player.username);
        }
        res.json().then()
      })
      .catch((err) =>{ console.log(err); return});
};





function getMyX(id){
  for (playera of players) {
    if(playera.id == id){
      return playera.x;
    }
  }
}
function getMyY(id){
  for (playera of players) {
    if(playera.id == id){
      return playera.y;
    }
  }
}
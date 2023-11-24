/*
 
* You can use the following import statements
 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 
 */

package com.example.player;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.player.Player;
import com.example.player.PlayerRepository;

import java.util.*;

// Don't modify the below code

public class PlayerService implements PlayerRepository {

    private static HashMap<Integer, Player> team = new HashMap<>();

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }

    // Don't modify the above code

    // Write your code here
    int uniquePlayerId = 12;

    @Override
    public ArrayList<Player> getPlayers() {
        Collection<Player> playerCollection = team.values();
        ArrayList<Player> players = new ArrayList<>(playerCollection);
        return players;

    }

    @Override
    public Player getPlayerById(int playerId) {
        Player player = team.get(playerId);
        if(player==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return player;
    }

    @Override
    public Player addPlayer(Player player) {
        player.setId(uniquePlayerId);
        team.put(uniquePlayerId, player);
        uniquePlayerId += 1;

        return player;

    }

    @Override
    public Player updatePlayer(int id, Player player) {
        Player existingPlayer = team.get(id);
        if (existingPlayer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (player.getName() != null) {
            existingPlayer.setName(player.getName());
        }
        if (player.getJerseyNum() != 0) {
            existingPlayer.setJerseyNum(player.getJerseyNum());
        }
        if (player.getPlayerRole() != null) {
            existingPlayer.setPlayerRole(player.getPlayerRole());
        }
        return existingPlayer;

    }

    @Override
    public void deletePlayer(int playerId) {
        Player player = team.get(playerId);
        if (player == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            team.remove(playerId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

}

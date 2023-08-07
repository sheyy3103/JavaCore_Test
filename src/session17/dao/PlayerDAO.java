package session17.dao;

import session17.enity.Player;

import java.util.List;

public interface PlayerDAO {
    public boolean addPlayer(Player player);

    public List<Player> getPlayers();

    public Player getPlayerById(Integer id);

    public boolean updatePlayer(Integer id, Player player);

    public boolean removePlayer(Integer id);

    public List<Player> getPlayersByClub(String clubName);
}

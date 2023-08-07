package session17.dao;

import session17.db.DBUtility;
import session17.enity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO {
    @Override
    public boolean addPlayer(Player player) {
        boolean bool = false;
        Connection conn;
        PreparedStatement ps;

        conn = DBUtility.openConnection();
        try {
            ps = conn.prepareStatement("insert into tbl_players values (?,?,?,?,?,?,?)");
            ps.setString(1, player.getPlayerName());
            ps.setBoolean(2, player.getGender());
            ps.setDate(3, new Date(player.getDateOfBirth().getTime()));
            ps.setString(4, player.getNationality());
            ps.setString(5, player.getClubName());
            ps.setString(6, player.getPositionPlay());
            ps.setFloat(7, player.getTransferCost());
            int i = ps.executeUpdate();

            if (i > 0)
                bool = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeConnection(conn);
        }

        return bool;
    }

    @Override
    public List<Player> getPlayers() {
        List<Player> listPlayer = new ArrayList<>();
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;

        conn = DBUtility.openConnection();
        try {
            ps = conn.prepareStatement("select * from tbl_players");
            rs = ps.executeQuery();
            while (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getInt("playerId"));
                player.setPlayerName(rs.getString("playerName"));
                player.setGender(rs.getBoolean("gender"));
                player.setDateOfBirth(rs.getDate("dateOfBirth"));
                player.setNationality(rs.getString("nationality"));
                player.setClubName(rs.getString("clubName"));
                player.setPositionPlay(rs.getString("positionPlay"));
                player.setTransferCost(rs.getFloat("transferCost"));
                listPlayer.add(player);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeConnection(conn);
        }

        return listPlayer;
    }

    @Override
    public Player getPlayerById(Integer id) {
        Player player = new Player();
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;

        conn = DBUtility.openConnection();
        try {
            ps = conn.prepareStatement("select * from tbl_players where playerId = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                player.setPlayerId(rs.getInt("playerId"));
                player.setPlayerName(rs.getString("playerName"));
                player.setGender(rs.getBoolean("gender"));
                player.setDateOfBirth(rs.getDate("dateOfBirth"));
                player.setNationality(rs.getString("nationality"));
                player.setClubName(rs.getString("clubName"));
                player.setPositionPlay(rs.getString("positionPlay"));
                player.setTransferCost(rs.getFloat("transferCost"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeConnection(conn);
        }
        return player;
    }

    @Override
    public boolean updatePlayer(Integer id, Player player) {
        boolean bool = false;
        Connection conn;
        PreparedStatement ps;

        conn = DBUtility.openConnection();
        try {
            ps = conn.prepareStatement("update tbl_players set playerName = ?, gender = ?, dateOfBirth = ?, nationality = ?, clubName = ?, positionPlay = ?, transferCost = ? where playerId = ?");
            ps.setString(1, player.getPlayerName());
            ps.setBoolean(2, player.getGender());
            ps.setDate(3, new Date(player.getDateOfBirth().getTime()));
            ps.setString(4, player.getNationality());
            ps.setString(5, player.getClubName());
            ps.setString(6, player.getPositionPlay());
            ps.setFloat(7, player.getTransferCost());
            ps.setInt(8, id);
            int i = ps.executeUpdate();

            if (i > 0)
                bool = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeConnection(conn);
        }
        return bool;
    }

    @Override
    public boolean removePlayer(Integer id) {
        boolean bool = false;
        Connection conn;
        PreparedStatement ps;

        conn = DBUtility.openConnection();
        try {
            ps = conn.prepareStatement("delete from tbl_players where playerId = ?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();

            if (i > 0)
                bool = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeConnection(conn);
        }
        return bool;
    }

    @Override
    public List<Player> getPlayersByClub(String clubName) {
        List<Player> listPlayer = new ArrayList<>();
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;

        conn = DBUtility.openConnection();
        try {
            ps = conn.prepareStatement("select * from tbl_players where clubName = ?");
            ps.setString(1, clubName);
            rs = ps.executeQuery();
            while (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getInt("playerId"));
                player.setPlayerName(rs.getString("playerName"));
                player.setGender(rs.getBoolean("gender"));
                player.setDateOfBirth(rs.getDate("dateOfBirth"));
                player.setNationality(rs.getString("nationality"));
                player.setClubName(rs.getString("clubName"));
                player.setPositionPlay(rs.getString("positionPlay"));
                player.setTransferCost(rs.getFloat("transferCost"));
                listPlayer.add(player);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeConnection(conn);
        }
        return listPlayer;
    }

    @Override
    public List<Player> getPlayersByName(String playerName) {
        List<Player> listPlayer = new ArrayList<>();
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;

        conn = DBUtility.openConnection();
        try {
            ps = conn.prepareStatement("select * from tbl_players where playerName like ?");
            ps.setString(1, "%" + playerName + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Player player = new Player();
                player.setPlayerId(rs.getInt("playerId"));
                player.setPlayerName(rs.getString("playerName"));
                player.setGender(rs.getBoolean("gender"));
                player.setDateOfBirth(rs.getDate("dateOfBirth"));
                player.setNationality(rs.getString("nationality"));
                player.setClubName(rs.getString("clubName"));
                player.setPositionPlay(rs.getString("positionPlay"));
                player.setTransferCost(rs.getFloat("transferCost"));
                listPlayer.add(player);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeConnection(conn);
        }
        return listPlayer;
    }
}

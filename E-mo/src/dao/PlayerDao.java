package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PlayerDao extends JdbcDaoSupport {
	
    private static final String SELECT_ALL 
      =   "SELECT ID, NAME, POSITION, BATTING FROM Player";  
    private class PlayerRowMapper implements RowMapper{
         public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        	 Player player = new Player();
        	 player.setPlayerId(new Integer(rs.getInt(1)));
        	 player.setPlayerName(rs.getString(2));
        	 player.setPlayerPosition(rs.getString(4));
        	 player.setPlayerBatting(rs.getDouble(5));
        	 return player;
        }
    }
    public List<Player> getPlayerList() {
        return getJdbcTemplate().query(PlayerDao.SELECT_ALL, new PlayerRowMapper());        
    }
}

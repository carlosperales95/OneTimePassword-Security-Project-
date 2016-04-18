package seguridad.server.DAO;

import seguridad.server.data.Member;

public interface IServerDAO {
	/**
	 * 
	 * @param username
	 */
	public Member getUser(String username);

	/**
	 * 
	 * @param username
	 * @param name
	 * @param email
	 */
	public Member[] searchUser(String name, String email);

}

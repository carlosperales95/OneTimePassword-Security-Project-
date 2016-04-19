package seguridad.server.DAO;

import seguridad.server.data.Member;

public interface IServerDAO {
	/**
	 * 
	 * @param username
	 */
	public Member getMember(String username);

	/**
	 * 
	 * @param username
	 * @param name
	 * @param email
	 */
	public Member[] getallMembers();

}

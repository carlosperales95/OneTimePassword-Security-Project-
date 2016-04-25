package seguridad.server.DAO;

import java.util.List;

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
	public List<Member> getallMembers();
	
	public void registerMember(Member member);

}

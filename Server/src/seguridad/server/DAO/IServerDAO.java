package seguridad.server.DAO;

import java.util.List;

import seguridad.server.data.Member;

public interface IServerDAO {

	public Member getMember(String username);

	public List<Member> getallMembers(String admin);
	
	public void registerMember(Member member);

}

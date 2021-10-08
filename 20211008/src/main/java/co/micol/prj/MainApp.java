package co.micol.prj;

//import java.util.ArrayList;
import java.util.List;

import co.micol.prj.dao.DataSource;
import co.micol.prj.exe.MainMenu;
import co.micol.prj.service.MemberService;
import co.micol.prj.service.MemberVO;
import co.micol.prj.serviceImpl.MemberServiceImpl;

public class MainApp {
	
	public static void main(String[] args) {
//		DataSource dao = DataSource.getInstance(); //싱글턴 클래스의 인스턴스를 가져오는것
//		dao.getConnection();	//연결객체 호출.
		
//		MemberService memberService = new MemberServiceImpl();
//		List<MemberVO> members = new ArrayList<MemberVO>();
//		members = memberService.selectMemberList(); // 처음에 값을 넣으면 들어가 있는데 밑으로 넣어줘야 되는거였다. 그런데 이미 했기때문에 여기 넣어줬다.
		//(인터페이스 개념)
		
//		MemberVO vo = new MemberVO();
//		vo.setId("proxypp");
//		vo = memberService.selectMember(vo);
//		vo.toString();
//		
//		System.out.println("=================");
//		
//		
//		vo = new MemberVO();
//		vo.setId("kim");
//		vo.setPassword("4567");
//		vo.setName("김치국");
//		vo.setTel(null);
//		vo.setAddress(null);
//		vo.setAuthor("USER");
//
//		int n = memberService.insertMember(vo); // kim을 집어넣기 위한값이다. 한번 집어넣고 다시 집어넣으려고하면 오류가 발생한다.
//		
//		if (n!= 0) {
//			System.out.println("잘 입력되었습니다.");
//		}else {
//			System.out.println("입력이 실패했습니다.");
//		}
//		
//		for (MemberVO member : members) {
//			member.toString();
//		}
		
		
		MainMenu mainMenu = new MainMenu();
		mainMenu.run();
		
		
		
		
	}
}

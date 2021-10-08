package co.micol.prj.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.dao.DataSource;
import co.micol.prj.service.MemberService;
import co.micol.prj.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt; // sql문 전달, 실행, 결과받기
	private ResultSet rs; // select 구문의 결과를 받음.

	@Override
	public List<MemberVO> selectMemberList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "select * from member";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // sql문 실행후 결과를 받음.
			while (rs.next()) {
				// 여기서 값을 읽고 담아서 전달해 준다
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getString("address"));
				vo.setAuthor(rs.getString("author"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list; // 받는 곳에도 List<MemberVO> 타입 있어야 한다.

	}

	@Override
	public MemberVO selectMember(MemberVO vo) { // 한명 조회하기
		String sql = "select * from member where id = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId()); // 전달인자를 sql문에 넘겨주는 것.
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setTel(rs.getNString("tel"));
				vo.setAddress(rs.getString("address"));
				vo.setAuthor(rs.getString("author"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertMember(MemberVO vo) {
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		int n =0;
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPassword());
			psmt.setString(4, vo.getTel());
			psmt.setString(5, vo.getAddress());
			psmt.setString(6, vo.getAhthor());
			n = psmt.executeUpdate(); // 성공하면 1 실패하면 0
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
				
				
				return n;
		
		
	}

	@Override
	public int updateMember(MemberVO vo) {
		int n = 0;
		String sql = "update member set name = ?, password = ?,tel =  ?,address= ?, author = ? "
				+ "where id = ? ";
			try {
				conn= dao.getConnection();
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getName());
				psmt.setString(2, vo.getPassword());
				psmt.setString(3, vo.getTel());
				psmt.setString(4, vo.getAddress());
				psmt.setString(5, vo.getAhthor());
				psmt.setString(6, vo.getId());
				n = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return n;
	}

	@Override
	public int deleteMember(MemberVO vo) {
        int n = 0;
		String sql = "delete from member where id = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	private void close() { // 사용한 객체를 반환한다.
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void show() {

	}
}

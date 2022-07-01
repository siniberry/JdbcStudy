/*
실행 예)

이름 전화번호 입력(2) : 오이삭 010-2222-2222
>> 회원 정보 입력 완료~!!!
이름 전화번호 입력(3) : 임소민 010-3333-3333
>> 회원 정보 입력 완료~!!!
이름 전화번호 입력(4) : .

----------------------------------
전체 회원 수 : 3명
----------------------------------
번호	이름	전화번호
1	   이호석	010-1111-1111
2	   오이삭   010-2222-2222
3	   임소민 	010-3333-3333
----------------------------------
 */

package com.test;

import java.util.Scanner;

import com.util.DBConn;

public class MMain_0323
{
	// 메인
	public static void main(String[] args)
	{
		//스캐너
		Scanner sc = new Scanner(System.in);
		
		try
		{
			// DAO 객체 구성
			MDAO_0323 dao = new MDAO_0323();
			
			// count 담기
			int count = dao.count();
			
			do
			{
				// 입력받기
				System.out.printf("이름 전화번호 입력(%d) : ", ++count);
				
				// 이름 저장
				String name = sc.next();
				
				// 반복의 조건을 무너뜨리는 코드 구성
				if (name.equals("."))
					break;
				
				// 전화번호 저장
				String tel = sc.next();
				
				// 여기까지의 과정을 통해 이름과 전화번호를 사용자로부터 입력받은 이유는
				// 입력받은 데이터를 데이터베이스에 입력하기 위함
				// 데이터 입력을 위해서는 dao 의 add() 메소드 호출 필요
				// add() 메소드 호출하기 위해서는 DTO 값을 넘겨주는 과정이 필요
				// DTO 값을 넘겨주기 위해서는 객체의 속성 값 구성 필요
				
				// DTO 객체 생성
				MDTO_0323 dto = new MDTO_0323();
				
				// 속성 값 구성
				dto.setName(name);
				dto.setTel(tel);
				
				//데이터베이스에 데이터 입력하는 메소드 호출 → add()
				int result = dao.add(dto);
				if(result >0)
					System.out.println(">> 회원 정보 입력 완료~!!!");								
				
			} while (true);
			
			// 메뉴 출력
			System.out.println();
			System.out.println("----------------------------------");
			System.out.printf("전체 회원 수 : %d명\n", dao.count());
			System.out.println("----------------------------------");
			System.out.println("번호	이름	전화번호");
			// 리스트 가져와서 출력
			//dao.lists()
			for (MDTO_0323 obj : dao.lists())
			{
				System.out.printf("%3s %7s %12s\n", obj.getSid(), obj.getName(), obj.getTel() );
			}
			System.out.println("----------------------------------");					
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally 
		{
			try
			{
				DBConn.close();
				System.out.println("데이터베이스 연결 닫힘");
				System.out.println("프로그램 종료");
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
	}
}


// 실행 결과
/*
이름 전화번호 입력(2) : 최현명 010-2222-2222
>> 회원 정보 입력 완료~!!!
이름 전화번호 입력(3) : 신가은 010-3333-3333
>> 회원 정보 입력 완료~!!!
이름 전화번호 입력(4) : 베리 010-1223-0108
>> 회원 정보 입력 완료~!!!
이름 전화번호 입력(5) : .

----------------------------------
전체 회원 수 : 4명
----------------------------------
번호	이름	전화번호
  1     신시은 010-1111-1111
  2     최현명 010-2222-2222
  3     신가은 010-3333-3333
  4      베리 010-1223-0108
----------------------------------
데이터베이스 연결 닫힘
프로그램 종료

*/
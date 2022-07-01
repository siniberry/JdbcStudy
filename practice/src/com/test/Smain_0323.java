/*
○ 성적 처리 프로그램 구현 → 데이터베이스 연동 → SDAO, SDTO 클래스 활용

	여러 명의 이름, 국어점수, 영어 점수, 수학점수를 입력받아
	총점, 평균을 연산하여 내용을 출력하는 프로그램을 구현한다.
	출력 시 번호(이름, 총점 등) 오름차순 정렬하여 출력한다.
	
실행 예)

1번 학생 성적 입력(이름 국어 영어 수학) : 신시은 95 90 100
2번 학생 성적 입력(이름 국어 영어 수학) : 최현명 85 95 100
3번 학생 성적 입력(이름 국어 영어 수학) : 베리    8  5   1
4번 학생 성적 입력(이름 국어 영어 수학) : .

-------------------------------------------------------
번호 	이름	국어   영어   수학   총점	평균
-------------------------------------------------------
1	   신시은	95		90	   100	 xxx	xx.x
2	   최현명	85	    95	   100	 xxx	xx.x
3	     베리	 8		 5		 1 	 xxx	xx.x
-------------------------------------------------------
*/

package com.test;

import java.util.Scanner;

import com.util.DBConn;


public class Smain_0323
{
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			SDAO_0323 dao = new SDAO_0323();
			
			int count = dao.count();
			
			do
			{
				System.out.printf("%d번 학생 성적 입력(이름 국어 영어 수학) : ", ++count);
				String name = sc.next();
				
				if (name.equals("."))
					break;
				
				int kor = sc.nextInt();
				int eng = sc.nextInt();
				int mat = sc.nextInt();
				
				SDTO_0323 dto = new SDTO_0323();
				
				dto.setName(name);
				dto.setKor(kor);
				dto.setEng(eng);
				dto.setMat(mat);
				dto.setTot(kor, eng, mat);
				dto.setAvg(kor, eng, mat);
				
				dao.add(dto);
	
			} while (true);
			
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println("번호	이름	국어	영어	수학	총점	평균");
			System.out.println("-------------------------------------------------------");

			for (SDTO_0323 obj : dao.lists())
			{
				System.out.printf("%d %8s \t%d \t%d \t%d \t%d \t%.1f\n", obj.getSid(), obj.getName(), obj.getKor(), obj.getEng(), obj.getMat(), obj.getTot(), obj.getAvg());
			}
			System.out.println("-------------------------------------------------------");
	
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		finally 
		{
			try
			{
				DBConn.close();
				System.out.println("데이터베이스 연결 종료");
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
1번 학생 성적 입력(이름 국어 영어 수학) : 신시은 95 90 100
2번 학생 성적 입력(이름 국어 영어 수학) : 최현명 85 95 100
3번 학생 성적 입력(이름 국어 영어 수학) :   베리  8  5   1
4번 학생 성적 입력(이름 국어 영어 수학) : .

-------------------------------------------------------
번호	이름	국어	영어	수학	총점	평균
-------------------------------------------------------
13      신시은 	95 	90 	100 	285 	95.0
14      최현명 	85 	95 	100 	280 	93.3
15       베리 	8 	5 	1 	14 	4.7
-------------------------------------------------------
데이터베이스 연결 종료
프로그램 종료
*/
SELECT USER
FROM DUAL;
--==>> SCOTT

--○ 실습 테이블 생성
CREATE TABLE TBL_MEMBER
( SID   NUMBER
, NAME  VARCHAR(30)
, TEL   VARCHAR(60)
, CONSTRAINT MEMBER_SID_PK PRIMARY KEY(SID)
);
--==>> Table TBL_MEMBER이(가) 생성되었습니다.

--○ 샘플데이터 입력
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(1, '홍길동', '010-1111-1111');
--==>> 1 행 이(가) 삽입되었습니다.


--○ 확인
SELECT *
FROM TBL_MEMBER;
--==>> 1	홍길동	010-1111-1111


--○ 커밋
COMMIT;
--==>> 커밋 완료.


--○ 자바에서 Test003.java 실행 후 다시 확인
SELECT *
FROM TBL_MEMBER;
--==>>
/*
1	홍길동	010-1111-1111
2	신시은	010-6267-0734
*/


UPDATE TBL_MEMBER
SET NAME = '최길동'
WHERE SID = 2;
--==>> 1 행 이(가) 업데이트되었습니다.


COMMIT;
--==>> 커밋 완료.

--○ 자바에서 Test004.java 실행 후 다시 확인
SELECT *
FROM TBL_MEMBER;
--==>> 
/*
3	김정용	010-3333-3333
4	오이삭	010-4444-4444
5	김태형	010-5555-5555
1	홍길동	010-1111-1111
2	최길동	010-6267-0734
*/


--○ 조회 쿼리문 준비
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
--> 한 줄 구성
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID
;
SELECT USER
FROM DUAL;
--==>> SCOTT

--○ 테이블 생성
CREATE TABLE PRACTICE_MEMBER0322
( SID   NUMBER
, NAME  VARCHAR(30)
, TEL   VARCHAR(60)
, CONSTRAINT MEMBER0322_SID_PK PRIMARY KEY(SID)
);
--==>> Table PRACTICE_MEMBER0322이(가) 생성되었습니다.

--○ 샘플 데이터 입력
INSERT INTO PRACTICE_MEMBER0322(SID, NAME, TEL) VALUES (1, '신시은', '010-6267-0734');
--==>>1 행 이(가) 삽입되었습니다.


--○ 확인
SELECT *
FROM PRACTICE_MEMBER0322;
--==>> 1	신시은	010-6267-0734

--○ 커밋
COMMIT;
--==>> 커밋 완료.

--○ 자바에서 T3_0322.java 실행 후 다시 확인
SELECT *
FROM PRACTICE_MEMBER0322;
--==>> 
/*
1	신시은	010-6267-0734
2	최현명	010-2493-1902
*/

UPDATE PRACTICE_MEMBER0322
SET NAME = '최현명'
WHERE SID = 2;
--==>> 1 행 이(가) 업데이트되었습니다.

COMMIT;

--○ 자바에서 T4_0322.java 실행 후 다시 확인
SELECT *
FROM PRACTICE_MEMBER0322;
--==>>
/*
1	신시은	010-6267-0734
2	최현명	010-2493-1902
3	신가은	010-2050-0734
4	베리	010-1223-0108
*/

--○ 조회 쿼리문 준비
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
-->>  한줄 구성
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID
;



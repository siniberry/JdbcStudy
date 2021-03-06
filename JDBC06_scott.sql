SELECT USER
FROM DUAL;
--==>> SCOTT


SELECT *
FROM TBL_MEMBER;
--==>>
/*
1	이호석	010-1111-1111
2	오이삭	010-2222-2222
3	임소민	010-3333-3333
*/


--○ 데이터 입력 쿼리문 구성
INSERT INTO TBL_MEMBER(SID, NAME, TEL)
VALUES(MEMBERSEQ.NEXTVAL, '김상기','010-4444-4444');
--==>> 1 행 이(가) 삽입되었습니다.
--> 한줄 구성
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(MEMBERSEQ.NEXTVAL, '김상기','010-4444-4444')
;
--==>> 1 행 이(가) 삽입되었습니다.


--○ 확인
SELECT *
FROM TBL_MEMBER;
--==>>


--○ 커밋
COMMIT;


--○ 데이터 전체 조회 쿼리문 구성
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
--> 한 줄 구성
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID;
/*
1	이호석	010-1111-1111
2	오이삭	010-2222-2222
3	임소민	010-3333-3333
4	김상기	010-4444-4444
*/

SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
--==>>
/*
1	이호석	010-1111-1111
2	오이삭	010-2222-2222
3	임소민	010-3333-3333
4	김상기	010-4444-4444
5	한충희	010-5555-5555
*/


SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
--==>>
/*
1	이호석	010-1111-1111
2	오이삭	010-2222-2222
3	임소민	010-3333-3333
4	김상기	010-4444-4444
5	한충희	010-5555-5555
6	박현수	010-6666-6666
*/


SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
--==>>
/*
1	이호석	010-1111-1111
2	오이삭	010-2222-2222
3	임소민	010-3333-3333
4	김상기	010-4444-4444
5	한충희	010-5555-5555
6	박현수	010-6666-6666
30	정은정	010-3030-3030
31	김정용	010-3131-3131
*/



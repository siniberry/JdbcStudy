SELECT USER
FROM DUAL;
--==>> SCOTT

--�� �ǽ� ���̺� ����
CREATE TABLE TBL_MEMBER
( SID   NUMBER
, NAME  VARCHAR(30)
, TEL   VARCHAR(60)
, CONSTRAINT MEMBER_SID_PK PRIMARY KEY(SID)
);
--==>> Table TBL_MEMBER��(��) �����Ǿ����ϴ�.

--�� ���õ����� �Է�
INSERT INTO TBL_MEMBER(SID, NAME, TEL) VALUES(1, 'ȫ�浿', '010-1111-1111');
--==>> 1 �� ��(��) ���ԵǾ����ϴ�.


--�� Ȯ��
SELECT *
FROM TBL_MEMBER;
--==>> 1	ȫ�浿	010-1111-1111


--�� Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�.


--�� �ڹٿ��� Test003.java ���� �� �ٽ� Ȯ��
SELECT *
FROM TBL_MEMBER;
--==>>
/*
1	ȫ�浿	010-1111-1111
2	�Ž���	010-6267-0734
*/


UPDATE TBL_MEMBER
SET NAME = '�ֱ浿'
WHERE SID = 2;
--==>> 1 �� ��(��) ������Ʈ�Ǿ����ϴ�.


COMMIT;
--==>> Ŀ�� �Ϸ�.

--�� �ڹٿ��� Test004.java ���� �� �ٽ� Ȯ��
SELECT *
FROM TBL_MEMBER;
--==>> 
/*
3	������	010-3333-3333
4	���̻�	010-4444-4444
5	������	010-5555-5555
1	ȫ�浿	010-1111-1111
2	�ֱ浿	010-6267-0734
*/


--�� ��ȸ ������ �غ�
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
--> �� �� ����
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID
;
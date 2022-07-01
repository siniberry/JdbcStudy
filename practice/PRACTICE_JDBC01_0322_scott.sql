SELECT USER
FROM DUAL;
--==>> SCOTT

--�� ���̺� ����
CREATE TABLE PRACTICE_MEMBER0322
( SID   NUMBER
, NAME  VARCHAR(30)
, TEL   VARCHAR(60)
, CONSTRAINT MEMBER0322_SID_PK PRIMARY KEY(SID)
);
--==>> Table PRACTICE_MEMBER0322��(��) �����Ǿ����ϴ�.

--�� ���� ������ �Է�
INSERT INTO PRACTICE_MEMBER0322(SID, NAME, TEL) VALUES (1, '�Ž���', '010-6267-0734');
--==>>1 �� ��(��) ���ԵǾ����ϴ�.


--�� Ȯ��
SELECT *
FROM PRACTICE_MEMBER0322;
--==>> 1	�Ž���	010-6267-0734

--�� Ŀ��
COMMIT;
--==>> Ŀ�� �Ϸ�.

--�� �ڹٿ��� T3_0322.java ���� �� �ٽ� Ȯ��
SELECT *
FROM PRACTICE_MEMBER0322;
--==>> 
/*
1	�Ž���	010-6267-0734
2	������	010-2493-1902
*/

UPDATE PRACTICE_MEMBER0322
SET NAME = '������'
WHERE SID = 2;
--==>> 1 �� ��(��) ������Ʈ�Ǿ����ϴ�.

COMMIT;

--�� �ڹٿ��� T4_0322.java ���� �� �ٽ� Ȯ��
SELECT *
FROM PRACTICE_MEMBER0322;
--==>>
/*
1	�Ž���	010-6267-0734
2	������	010-2493-1902
3	�Ű���	010-2050-0734
4	����	010-1223-0108
*/

--�� ��ȸ ������ �غ�
SELECT SID, NAME, TEL
FROM TBL_MEMBER
ORDER BY SID;
-->>  ���� ����
SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID
;



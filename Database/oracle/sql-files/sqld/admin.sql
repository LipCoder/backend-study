-- sqlp용 유저 생성 
CREATE USER sqlp_user IDENTIFIED BY xnths8686;

-- 생성 확인
SELECT USERNAME FROM DBA_USERS;

-- 권한 부여
GRANT CONNECT,RESOURCE,DBA TO sqlp_user;
GRANT CREATE TABLE, CREATE VIEW TO sqlp_user;
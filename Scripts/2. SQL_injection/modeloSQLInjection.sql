CREATE TABLE USUARIO 
(
    username VARCHAR2(20) NOT NULL, 
    pwd VARCHAR2(20), 
    CONSTRAINT USUARIO_PK PRIMARY KEY(username)
  ENABLE 
);

INSERT INTO USUARIO VALUES ('admin', '123');
INSERT INTO USUARIO VALUES ('adrian', '456');
INSERT INTO USUARIO VALUES ('amanda', '321');
INSERT INTO USUARIO VALUES ('carlos', '234');
INSERT INTO USUARIO VALUES ('juan', '345');

commit;

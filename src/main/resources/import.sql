INSERT INTO member (user_name) VALUES ('member1');
INSERT INTO board (content,member_id) VALUES ('content1',1);
INSERT INTO board (content,member_id) VALUES ('content2',1);

INSERT INTO member (user_name) VALUES ('member2');
INSERT INTO member (user_name) VALUES ('member5');
INSERT INTO board (content,member_id) VALUES ('content3',2);
INSERT INTO board (content,member_id) VALUES ('content4',2);

INSERT INTO member (user_name) VALUES ('member3');
INSERT INTO board (content,member_id) VALUES ('content5',3);
INSERT INTO board (content,member_id) VALUES ('content6',3);

INSERT INTO member (user_name) VALUES ('member4');
INSERT INTO board (content,member_id) VALUES ('content7',4);
INSERT INTO board (content,member_id) VALUES ('content8',4);


INSERT INTO comment (content,member_id,board_id) VALUES ('comment1',1,3);
INSERT INTO comment (content,member_id,board_id) VALUES ('comment2',2,3);
INSERT INTO comment (content,member_id,board_id) VALUES ('comment3',3,3);
INSERT INTO comment (content,member_id,board_id) VALUES ('comment4',1,3);
INSERT INTO comment (content,member_id,board_id) VALUES ('comment5',1,3);
INSERT INTO comment (content,member_id,board_id) VALUES ('comment6',1,3);
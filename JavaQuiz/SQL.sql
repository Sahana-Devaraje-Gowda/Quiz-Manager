create table QUESTION( 
   ques_id INT auto_increment primary key, 
   questions VARCHAR(250) NOT NULL, 
   topics ARRAY NOT NULL, 
   difficulty INT, 
   ismcq boolean,
);

CREATE TABLE MCQ_CHOICE(
mcq_id INT auto_increment primary key,
choice VARCHAR(250) NOT NULL,
ques_id int  NOT NULL,
FOREIGN KEY(ques_id)    REFERENCES QUESTION(ques_id)
) ;

CREATE TABLE ANSWER(
ans_id INT auto_increment primary key,
actual_ans VARCHAR(250) NOT NULL,
user_ans   VARCHAR(250) NOT NULL,
ques_id INT NOT NULL,
mcq_id INT NOT NULL,
FOREIGN KEY(ques_id)    REFERENCES QUESTION(ques_id),
FOREIGN KEY(mcq_id )    REFERENCES MCQ_CHOICE(mcq_id ),
) ;

CREATE TABLE STUDENT(
std_id INT auto_increment primary key,
std_name VARCHAR(250) NOT NULL,
score int (250) NOT NULL,
) ;

insert into QUESTION( questions, topics,difficulty,ismcq) values ('Which Set class should be most popular in a multi-threading environment, considering performance constraint? ', 'Exception Handling', 3,'TRUE');

insert into QUESTION( questions, topics,difficulty,ismcq) values ('Which allows the removal of elements from a collection?	', 'Collections', 2,'TRUE');

insert into QUESTION( questions, topics,difficulty) values ('What should we tend to use once add and remove operations are more frequent than get operations?, inheriting them directly from class Object?', 'Arrays', 1,'TRUE');

insert into QUESTION( questions, topics,difficulty,ismcq) values ('The Java interpreter is used for the execution of the source code.','Garbage Collections',2,'TRUE');

insert into QUESTION( questions, topics,difficulty,ismcq) values ('What is a JVM?. ', 'Garbage Collections', 2,'FALSE');

insert into QUESTION( questions, topics,difficulty,ismcq) values ('The default capacity of an ArrayList is:','Arrays',1,'TRUE');

insert into QUESTION( questions, topics,difficulty,ismcq) values ('What are the four cornerstones of OOP?', 'Basics of OOPS', 1, 'FALSE');

insert into QUESTION( questions, topics,difficulty,ismcq) values ('Which of those isnt an interface within the Collections Framework?', 'Collections', 2, 'TRUE');

insert into QUESTION( questions, topics,difficulty,ismcq) values ('Deque and Queue are derived from:', 'Data Structures', 2, 'TRUE');

insert into QUESTION( questions, topics,difficulty,ismcq) values ('Deletion is faster in LinkedList than ArrayList:', 'Data Structures', 2, 'TRUE');



insert into MCQ_CHOICE( choice,ques_id) values ('1-HashSet',2);
insert into MCQ_CHOICE( choice,ques_id) values ('2-ConcurrentSkipListSet',1);
insert into MCQ_CHOICE( choice,ques_id) values ('3-LinkedHashSet',1);
insert into MCQ_CHOICE( choice,ques_id) values ('4-CopyOnWriteArraySet',1);


insert into MCQ_CHOICE( choice,ques_id) values ('1-Enumeration',2);
insert into MCQ_CHOICE( choice,ques_id) values ('2-Iterator',2);
insert into MCQ_CHOICE( choice,ques_id) values ('3-Both',2);
insert into MCQ_CHOICE( choice,ques_id) values ('4-None',2);


insert into MCQ_CHOICE( choice,ques_id) values ('1-LinkedList',3);
insert into MCQ_CHOICE( choice,ques_id) values ('2-ArrayList',3);
insert into MCQ_CHOICE( choice,ques_id) values ('3-Vector',3);
insert into MCQ_CHOICE( choice,ques_id) values ('4-Collection',3);

insert into MCQ_CHOICE( choice,ques_id) values ('1-TRUE',4);
insert into MCQ_CHOICE( choice,ques_id) values ('1-FALSE',4);

insert into MCQ_CHOICE( choice,ques_id) values ('JVM is Java Virtual Machine that is runtime environment for the compile java class files.',5);

insert into MCQ_CHOICE( choice,ques_id) values ('1-12.',6);
insert into MCQ_CHOICE( choice,ques_id) values ('2-16',6);
insert into MCQ_CHOICE( choice,ques_id) values ('3-1',6);
insert into MCQ_CHOICE( choice,ques_id) values ('4-10',6);

insert into MCQ_CHOICE( choice,ques_id) values ('Polymorphism, Abstraction, Encapsulation, and Inheritance.',7);

insert into MCQ_CHOICE( choice,ques_id) values ('1-Collection',8);
insert into MCQ_CHOICE( choice,ques_id) values ('2-Group',8);
insert into MCQ_CHOICE( choice,ques_id) values ('3-Set',8);
insert into MCQ_CHOICE( choice,ques_id) values ('4-List',8);


insert into MCQ_CHOICE( choice,ques_id) values ('1-AbstractList',9);
insert into MCQ_CHOICE( choice,ques_id) values ('2-Collection',9);
insert into MCQ_CHOICE( choice,ques_id) values ('3-AbstractCollection',9);
insert into MCQ_CHOICE( choice,ques_id) values ('4-List',9);

insert into MCQ_CHOICE( choice,ques_id) values ('1-TRUE',10);
insert into MCQ_CHOICE( choice,ques_id) values ('1-FALSE',10);



insert into ANSWER( actual_ans, user_ans,ques_id,mcq_id) values ('ConcurrentSkipListSet',' ',1, 2);

insert into ANSWER( actual_ans, user_ans,ques_id,mcq_id) values ('Iterator',' ',2, 6);

insert into ANSWER( actual_ans, user_ans,ques_id,mcq_id) values ('LinkedList',' ',3, 9);

insert into ANSWER( actual_ans, user_ans,ques_id,mcq_id) values ('TRUE',' ',4, 13);

insert into ANSWER( actual_ans, user_ans,ques_id,mcq_id) values ('JVM is Java Virtual Machine that is runtime environment for the compile java class files',' ',5, 15);

insert into ANSWER( actual_ans, user_ans,ques_id,mcq_id) values ('10',' ',6, 19);

insert into ANSWER( actual_ans, user_ans,ques_id,mcq_id) values ('Polymorphism, Abstraction, Encapsulation, and Inheritance.',' ',7, 20);

insert into ANSWER( actual_ans, user_ans,ques_id,mcq_id) values ('Group',' ',8, 22);

insert into ANSWER( actual_ans, user_ans,ques_id,mcq_id) values ('Collection',' ',9, 26);

insert into ANSWER( actual_ans, user_ans,ques_id,mcq_id) values ('TRUE',' ',10, 29);


select * from QUESTION;
select * from MCQ_CHOICE;
select * from ANSWER;

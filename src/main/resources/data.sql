--Create Member entries
Insert INTO Member(id,email,firstName,lastName,role)
VALUES (1111,'email1@gmail.com','Kidus','lname1','STUDENT');
Insert INTO Member(id,email,firstName,lastName,role)
VALUES (1112,'email2@gmail.com','Vishal','lname2','STUDENT');
Insert INTO Member(id,email,firstName,lastName,role)
VALUES (1113,'email3@gmail.com','Sumayya','lname3','STAFF');
Insert INTO Member(id,email,firstName,lastName,role)
VALUES (1114,'email1@gmail.com','Suzana','lname1','FACULTY');
Insert INTO Member(id,email,firstName,lastName,role)
VALUES (1115,'email1@gmail.com','Hiradya','lname1','STUDENT');

-- Create Badge entries
Insert INTO Badge(id, active,member_id)
VALUES (1111, 'TRUE',1111);
Insert INTO Badge(id, active,member_id)
VALUES (1112, 'TRUE',1112);
Insert INTO Badge(id, active,member_id)
VALUES (1113, 'TRUE',1113);
Insert INTO Badge(id, active,member_id)
VALUES (1114, 'TRUE',1114);
Insert INTO Badge(id, active,member_id)
VALUES (1115, 'TRUE',1115);
Insert INTO Badge(id, active,member_id)
VALUES (1116, 'false',1112);

--Create Schedule entries
Insert INTO Schedule(id,name)
VALUES (1111,'Morning');
Insert INTO Schedule(id,name)
VALUES (1112,'Lunch');
Insert INTO Schedule(id,name)
VALUES (1113,'Evening');
Insert INTO Schedule(id,name)
VALUES (1114,'All day');

--Create WeekDay entries
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1111,'SUNDAY',1111);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1112,'SUNDAY',1112);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1113,'SUNDAY',1113);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1114,'SUNDAY',1114);

Insert INTO WeekDay(id,name,scheduleID)
VALUES (1121,'MONDAY',1111);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1122,'MONDAY',1112);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1123,'MONDAY',1113);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1124,'MONDAY',1114);

Insert INTO WeekDay(id,name,scheduleID)
VALUES (1131,'TUESDAY',1111);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1132,'TUESDAY',1112);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1133,'TUESDAY',1113);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1134,'TUESDAY',1114);

Insert INTO WeekDay(id,name,scheduleID)
VALUES (1141,'WEDNESDAY',1111);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1142,'WEDNESDAY',1112);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1143,'WEDNESDAY',1113);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1144,'WEDNESDAY',1114);

Insert INTO WeekDay(id,name,scheduleID)
VALUES (1151,'THURSDAY',1111);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1152,'THURSDAY',1112);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1153,'THURSDAY',1113);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1154,'THURSDAY',1114);

Insert INTO WeekDay(id,name,scheduleID)
VALUES (1161,'FRIDAY',1111);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1162,'FRIDAY',1112);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1163,'FRIDAY',1113);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1164,'FRIDAY',1114);

Insert INTO WeekDay(id,name,scheduleID)
VALUES (1171,'SATURDAY',1111);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1172,'SATURDAY',1112);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1173,'SATURDAY',1113);
Insert INTO WeekDay(id,name,scheduleID)
VALUES (1174,'SATURDAY',1114);

--Create TimeSlot entries
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1111,'08:30','10:00',1111);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1112,'12:00','13:30',1112);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1113,'18:00','19:30',1113);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1114,'09:00','21:00',1114);

Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1121,'08:30','10:00',1121);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1122,'12:00','13:30',1122);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1123,'18:00','19:30',1123);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1124,'09:00','21:00',1124);

Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1131,'08:30','10:00',1131);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1132,'12:00','13:30',1132);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1133,'18:00','19:30',1133);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1134,'09:00','21:00',1134);

Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1141,'08:30','10:00',1141);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1142,'12:00','13:30',1142);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1143,'18:00','19:30',1143);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1144,'09:00','21:00',1144);

Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1151,'08:30','10:00',1151);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1152,'12:00','13:30',1152);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1153,'18:00','19:30',1153);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1154,'09:00','21:00',1154);

Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1161,'08:30','10:00',1161);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1162,'12:00','13:30',1162);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1163,'18:00','19:30',1163);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1164,'09:00','21:00',1164);

Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1171,'08:30','10:00',1171);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1172,'12:00','13:30',1172);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1173,'18:00','19:30',1173);
Insert INTO TimeSlot(id,startTime,endTime,weekDayID)
VALUES (1174,'09:00','21:00',1174);

--Create PlanEntity entries
Insert INTO PlanEntity(id,name,description)
VALUES (1111,'Dining Student','Argiro description');
Insert INTO PlanEntity(id,name,description)
VALUES (1112,'Dining Staff','Argiro description');
Insert INTO PlanEntity(id,name,description)
VALUES (1113,'Dining Faculty','Argiro description');

Insert INTO PlanEntity(id,name,description)
VALUES (1121,'Recreation Center','Recreation description');
Insert INTO PlanEntity(id,name,description)
VALUES (1131,'Meditation Center','Meditation description');
Insert INTO PlanEntity(id,name,description)
VALUES (1141,'Dormitory','Dormitory description');
Insert INTO PlanEntity(id,name,description)
VALUES (1151,'Classroom','Classroom description');
Insert INTO PlanEntity(id,name,description)
VALUES (1161,'Flying Hall','Flying Hall description');

--Create Location entries

Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (111101,'Dining Hall','DINING_HALL','Dining Student',200,1111,1111);
Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (111102,'Dining Hall','DINING_HALL','Dining Student',200,1111,1112);
Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (111103,'Dining Hall','DINING_HALL','Dining Student',200,1111,1113);

Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (111201,'Dining Hall','DINING_HALL','Dining Staff',200,1112,1111);
Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (111202,'Dining Hall','DINING_HALL','Dining Staff',200,1112,1112);
Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (111203,'Dining Hall','DINING_HALL','Dining Staff',200,1112,1113);

Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (111301,'Dining Hall','DINING_HALL','Dining Faculty',200,1113,1111);
Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (111302,'Dining Hall','DINING_HALL','Dining Faculty',200,1113,1112);
Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (111303,'Dining Hall','DINING_HALL','Dining Faculty',200,1113,1113);


Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (1121,'Recreation Center','GYMNASIUM','gym',200,1121,1114);

Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (1131,'Meditation Center','MEDITATION_HALL','Meditation Center',200,1131,1114);

Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (1141,'Dormitory','DORMITORY','Dormitory',200,1141,1114);

Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (1151,'Classroom','CLASSROOM','Classroom',200,1151,1114);

Insert INTO Location(id,name,type,description,capacity,planEntity_id,schedule_Id)
VALUES (1161,'Flying Hall','FLYING_HALL','Flying Hall',200,1161,1114);

-- --Create Membership entries
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1111,'2023-01-1','2023-12-12','LIMITED','WEEKLY','2023-12-12',20,10,1111,1111);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1112,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1111,1121);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1113,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1111,1131);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1114,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1111,1141);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1115,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1111,1151);
--Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
--VALUES (1116,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1111,1161);

Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1121,'2023-01-1','2023-12-12','LIMITED','WEEKLY','2023-12-12',20,10,1112,1111);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1122,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1112,1121);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1123,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1112,1131);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1124,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1112,1141);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1125,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1112,1151);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1126,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1112,1161);

Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1131,'2023-01-1','2023-12-12','LIMITED','WEEKLY','2023-12-12',50,10,1113,1112);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1132,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1113,1121);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1133,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1113,1131);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1134,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1113,1141);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1135,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1113,1151);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1136,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1113,1161);

Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1141,'2023-01-1','2023-12-12','LIMITED','WEEKLY','2023-12-12',30,10,1114,1113);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1142,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1114,1121);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1143,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1114,1131);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1144,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1114,1141);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1145,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1114,1151);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1146,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1114,1161);

Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1151,'2023-01-1','2023-12-12','LIMITED','WEEKLY','2023-12-12',20,10,1115,1111);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1152,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1115,1121);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1153,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1115,1131);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1154,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1115,1141);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1155,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1115,1151);
Insert INTO Membership(id,startDate,endDate,membershipType,resetCycle,lastRestDate,allowedCheckIn,currentCheckIn,member_id,plan_id)
VALUES (1156,'2023-01-1','2023-12-12','UNLIMITED','WEEKLY','2023-12-12',1000,10,1115,1161);

--Create TransactionEntity entries
--Kidus transaction to dining hall and gym on 2023-07-7
Insert INTO TransactionEntity(id,dateTime,transactionType,transactionTypeDescription,badgeID,locationID,membershipID)
VALUES (1111,'2023-07-7 21:46:27.000000','ALLOWED','Food Good',1111,111101,1111);
Insert INTO TransactionEntity(id,dateTime,transactionType,transactionTypeDescription,badgeID,locationID,membershipID)
VALUES (1112,'2023-07-7 21:46:27.000000','ALLOWED','fitness',1111,1121,1112);

--Sumayya transaction to dining hall and gym on 2023-07-7
Insert INTO TransactionEntity(id,dateTime,transactionType,transactionTypeDescription,badgeID,locationID,membershipID)
VALUES (1113,'2023-07-7 21:46:27.000000','ALLOWED','Food Good',1113,111201,1131);
Insert INTO TransactionEntity(id,dateTime,transactionType,transactionTypeDescription,badgeID,locationID,membershipID)
VALUES (1114,'2023-07-7 21:46:27.000000','ALLOWED','Meditation',1113,1131,1133);
-- Insert INTO TransactionEntity(id,dateTime,transactionType,transactionTypeDescription,badgeID,locationID,membershipID)
-- VALUES (1113,'2023-07-7 21:46:27.000000','ALLOWED','Food Good',1113,1113,1113);
-- Insert INTO TransactionEntity(id,dateTime,transactionType,transactionTypeDescription,badgeID,locationID,membershipID)
-- VALUES (1114,'2023-07-7 21:46:27.000000','ALLOWED','Food Good',1114,1114,1114);
-- Insert INTO TransactionEntity(id,dateTime,transactionType,transactionTypeDescription,badgeID,locationID,membershipID)
-- VALUES (1115,'2023-07-7 21:46:27.000000','ALLOWED','Food Good',1115,1115,1115);

-- Create Roles
INSERT INTO users(id, email, firstname, lastname, password)
VALUES(1111, 'email1@gmail.com','Kidus','lname1', '$2a$10$sLZONS6iMQnnyvY3e5Y5nOYKgwdTGJRhT9e8nk7SJGnLehjjrw3BC');
INSERT INTO users(id, email, firstname, lastname, password)
VALUES(1112,'email2@gmail.com','Vishal','lname2', '$2a$10$sLZONS6iMQnnyvY3e5Y5nOYKgwdTGJRhT9e8nk7SJGnLehjjrw3BC');
INSERT INTO users(id, email, firstname, lastname, password)
VALUES(1113,'email3@gmail.com','Sumayya','lname3', '$2a$10$sLZONS6iMQnnyvY3e5Y5nOYKgwdTGJRhT9e8nk7SJGnLehjjrw3BC');
INSERT INTO users(id, email, firstname, lastname, password)
VALUES(1114,'email4@gmail.com','Hiradaya','lname4', '$2a$10$sLZONS6iMQnnyvY3e5Y5nOYKgwdTGJRhT9e8nk7SJGnLehjjrw3BC');

INSERT INTO role(id, role) VALUES(6001, 'ADMIN');
INSERT INTO role(id, role) VALUES(6002, 'STAFF');
INSERT INTO role(id, role) VALUES(6003, 'STUDENT');
INSERT INTO role(id, role) VALUES(6004, 'FACULTY');

INSERT INTO users_role(users_id, roles_id) VALUES(1111, 6001);
INSERT INTO users_role(users_id, roles_id) VALUES(1112, 6002);
INSERT INTO users_role(users_id, roles_id) VALUES(1113, 6003);
INSERT INTO users_role(users_id, roles_id) VALUES(1114, 6004);
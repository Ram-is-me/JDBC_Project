use hospital;

create table Doctor(doctorId smallint, doctorName varchar(26), specialization varchar(26), pId smallint, constraint pk_doctor PRIMARY KEY(doctorId));

create table Manager(managerId smallint, managerName varchar(26), constraint pk_manager PRIMARY KEY(managerId));

create table Patient(patientId smallint, patientName varchar(26), history varchar(100), contact varchar(10), bedAllocation smallint, dId smallint, rId smallint, prescription varchar(100), constraint pk_patient PRIMARY KEY(patientId));

create table Receptionist(receptionistId smallint, receptionistName varchar(26), constraint pk_receptionist PRIMARY KEY(receptionistId));

create table Room(roomId smallint, pId smallint, dId smallint, constraint pk_room PRIMARY KEY(roomId));

alter table Patient add constraint fk_patient_doctor FOREIGN KEY (dId) REFERENCES Doctor(doctorId);

alter table Patient add constraint fk_patient_room FOREIGN KEY (rId) REFERENCES Room(roomId);

alter table Room add constraint fk_room_patient FOREIGN KEY (pId) REFERENCES Patient(patientId);

alter table Room add constraint fk_room_doctor FOREIGN KEY (dId) REFERENCES Doctor(doctorId);

alter table Doctor add constraint fk_doctor_patient FOREIGN KEY (pId) REFERENCES Patient(patientId);

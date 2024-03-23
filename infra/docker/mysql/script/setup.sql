create database if not exists timesheetdb character set utf8mb4 collate utf8mb4_0900_ai_ci;

create user if not exists 'sys_hackathon_timesheet'@'%' identified with mysql_native_password by 'hackathon_timesheet_6#233zJMNTjkQb#sgps#';

grant all privileges on timesheetdb.* to 'sys_hackathon_timesheet'@'%';

flush privileges;
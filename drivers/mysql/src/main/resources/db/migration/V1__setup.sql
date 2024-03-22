create table timesheet(
    id bigint auto_increment not null primary key,
    employee_id varchar(36) not null,
    date date not null,
    year_and_month varchar(14) not null,
    uuid_start_record varchar(36),
    start_timestamp time,
    uuid_end_record varchar(36),
    end_timestamp time,
    total_work_hours time,
    created datetime not null,
    last_updated datetime not null,
    version integer not null
);


ALTER TABLE timesheet ADD CONSTRAINT unique_timesheet UNIQUE (employee_id, uuid_start_record, uuid_end_record);

CREATE INDEX get_timesheet_index ON timesheet (employee_id, date, year_and_month, uuid_start_record, uuid_end_record, total_work_hours);
create database db_hotel_management_system;
use db_hotel_management_system;
show tables;

select * from room where category_id = 1 and status = 1;
select * from user;
select * from role;
select * from user_role;
insert into user_role values(1,1);
insert into user_role values(1,2);
insert into user_role values(2,2);

use db_hotel_management_system;
select * from user;
select * from categories;
select * from room;
select * from customer;
select * from booking;
select * from image_of_cate;
alter table customer auto_increment = 1;

-- delete from booking;
-- delete from customer;

select room_number from room, booking where room.category_id = 1 and room.id = booking.room_id 
and ( ( booking.start_stay_day >= '2022-06-05' and booking.start_stay_day <= '2022-06-13' )
or ( booking.last_stay_day >= '2022-06-05' and booking.last_stay_day <= '2022-06-13' ) )
group by room_number;

select * from booking;

select room_number from room, booking where room.id = booking.room_id 
and ( ( booking.start_stay_day >= '2022-06-05' and booking.start_stay_day <= '2022-06-13')
or ( booking.last_stay_day >= '2022-06-05' and booking.last_stay_day <= '2022-06-13' ) );


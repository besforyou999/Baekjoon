-- 코드를 입력하세요
select count(*) as USERS
from USER_INFO
where joined like "%2021%"
and age >= 20 and age <= 29
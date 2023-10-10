select member_id, member_name, gender, DATE_FORMAT(date_of_birth, "%Y-%m-%d") as date_of_birth
from member_profile
where TLNO is not null
and gender = 'W'
and month(date_of_birth) = 3
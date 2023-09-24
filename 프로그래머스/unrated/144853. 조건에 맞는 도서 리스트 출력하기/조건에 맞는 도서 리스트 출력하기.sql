select book_id, DATE_FORMAT(published_date, '%Y-%m-%d') as published_date
from book
where DATE_FORMAT(published_date, "%Y") = '2021'
and category = '인문'
order by published_date
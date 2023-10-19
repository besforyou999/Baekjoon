-- 코드를 입력하세요
select b.category as CATEGORY, sum(bs.sales) as TOTAL_SALES
from book as b
inner join book_sales as bs
on b.book_id = bs.book_id
where DATE_FORMAT(bs.sales_date, "%Y-%m") = '2022-01'
group by b.category
order by CATEGORY
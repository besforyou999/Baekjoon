-- 코드를 입력하세요
select  board_id,
        writer_id, 
        title, 
        price, 
        case status
            when 'sale' then '판매중'
            when 'reserved' then '예약중'
            when 'done' then '거래완료'
        end as status
from used_goods_board
where DATE_FORMAT(created_date, "%Y-%m-%d") = '2022-10-05'
order by 1 desc


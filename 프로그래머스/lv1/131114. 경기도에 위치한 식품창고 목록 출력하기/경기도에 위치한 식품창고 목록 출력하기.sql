-- 코드를 입력하세요
select warehouse_id, warehouse_name, address, IFNULL(freezer_yn, 'N')
from food_warehouse
where (left(address, 3) = '경기도')
order by warehouse_id
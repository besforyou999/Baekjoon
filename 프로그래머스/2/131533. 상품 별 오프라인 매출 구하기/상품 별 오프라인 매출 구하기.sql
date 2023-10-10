select P.product_code, sum(O.sales_amount) * P.price as sales
from PRODUCT P
inner join OFFLINE_SALE O
on P.product_id = O.product_id
group by P.product_code
order by sales desc, P.product_code
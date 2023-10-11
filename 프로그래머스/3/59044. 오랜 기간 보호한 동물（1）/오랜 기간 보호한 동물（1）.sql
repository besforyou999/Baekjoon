select a.name, a.datetime
from animal_ins as a
left join animal_outs as o
on a.animal_id = o.animal_id
where o.animal_id is null
order by a.datetime 
limit 3
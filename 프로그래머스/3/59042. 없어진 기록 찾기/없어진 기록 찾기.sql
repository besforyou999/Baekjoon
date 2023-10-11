select O.animal_id, O.name
from animal_ins as I
right join animal_outs as O
on I.animal_id = O.animal_id
where I.animal_id is null
order by O.animal_id
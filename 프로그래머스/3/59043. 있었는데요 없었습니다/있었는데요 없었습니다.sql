select I.animal_id, I.name
from animal_ins as I
inner join animal_outs as O
on I.animal_id = O.animal_id
where I.datetime > O.datetime
order by I.datetime
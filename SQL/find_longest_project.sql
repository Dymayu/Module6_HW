select t.NAME, a.MONTH_COUNT
from (select cl.NAME as NAME, TIMESTAMPDIFF(MONTH, p.START_DATE, p.FINISH_DATE) as MONTHS 
from project p, client cl 
where cl.ID=p.CLIENT_ID) t,
(select MAX(TIMESTAMPDIFF(MONTH, START_DATE, FINISH_DATE)) MONTH_COUNT from project)
a
where a.MONTH_COUNT=t.MONTHS
;
select 
pw.PROJECT_ID
,(TIMESTAMPDIFF(MONTH, p.START_DATE, p.FINISH_DATE) * sum(w.SALARY)) as PRICE
from project p
JOIN project_worker pw on pw.PROJECT_ID=p.ID
JOIN worker w on w.ID=pw.WORKER_ID
group by pw.PROJECT_ID
order by PRICE desc; 
select cl.NAME, count(pr.ID) as PROJECT_COUNT from client cl
LEFT JOIN project pr on cl.ID=pr.CLIENT_ID
group by cl.NAME
having count(pr.ID) = (
SELECT max(t.project_count) 
FROM (select cl.NAME as name, count(pr.ID) as project_count from client cl
LEFT JOIN project pr on cl.ID=pr.CLIENT_ID
group by cl.NAME
order by project_count desc
) t
)





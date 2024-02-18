select "YOUNGEST", NAME, BIRTHDAY from worker
where BIRTHDAY = (
select max(BIRTHDAY) from worker
)
UNION
select "ELDEST", NAME, BIRTHDAY from worker
where BIRTHDAY = (
select min(BIRTHDAY) from worker
);
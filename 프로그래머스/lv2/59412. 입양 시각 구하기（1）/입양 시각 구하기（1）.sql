SELECT HOUR(A.DATETIME) AS HOUR, COUNT(HOUR(A.DATETIME)) AS COUNT
FROM ANIMAL_OUTS AS A
GROUP BY HOUR(A.DATETIME)
HAVING HOUR >= 9 AND HOUR <= 19
ORDER BY HOUR
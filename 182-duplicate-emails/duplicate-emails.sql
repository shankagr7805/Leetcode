SELECT DISTINCT P1.email AS Email
FROM Person P1
JOIN Person P2
    ON P1.email = P2.email
   AND P1.id <> P2.id;
1)SElECT COUNT(*) FROM film WHERE length > 
  (SELECT ROUND(AVG(length),3) FROM film)
  
2)SElECT COUNT(*) FROM film WHERE rental_rate = 
  (SELECT MAX(rental_rate) FROM film)
  
3)(SELECT * FROM film ORDER BY rental_rate LIMIT 5)
UNION
(SELECT * FROM film ORDER BY replacement_cost LIMIT 5)

4)SELECT customer_id, SUM(amount) AS customer_alisveris
FROM payment 
GROUP BY customer_id 
ORDER BY SUM(amount) DESC 
LIMIT 10

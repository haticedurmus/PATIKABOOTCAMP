1)SElECT COUNT(*) FROM film WHERE length > 
  (SELECT ROUND(AVG(length),3) FROM film)
  
2)SElECT COUNT(*) FROM film WHERE rental_rate = 
  (SELECT MAX(rental_rate) FROM film)

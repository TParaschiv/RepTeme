USE facturi;

# Factura cu pretul cel mai mare
SELECT * FROM facturi
WHERE id = 
(SELECT idFactura FROM `produs factura` GROUP BY idFactura ORDER BY SUM(pret) DESC LIMIT 1);

# Produsul cu cele mai multe incasari
SELECT * FROM produse
WHERE id = 
(SELECT idProdus FROM `produs factura` GROUP BY idProdus ORDER BY SUM(pret) DESC LIMIT 1);

# Produsul cu cea mai mare cantitate vanduta
SELECT * FROM produse
WHERE id = 
(SELECT idProdus FROM `produs factura` GROUP BY idProdus ORDER BY SUM(cantitate) DESC LIMIT 1);

# Clientii si suma cumparaturilor
SELECT cl.*, SUM(res.cost) cost FROM clienti cl,
(SELECT cl.id, SUM(pret) cost FROM `produs factura` pf, facturi fc, clienti cl
WHERE fc.idClient = cl.id AND pf.idFactura = fc.id GROUP BY pf.idFactura) res
WHERE cl.id = res.id
GROUP BY res.id;

# Clientii si nr de facturi pe care le au
SELECT cl.*, COUNT(fc.id) 'nr facturi' FROM clienti cl, facturi fc
WHERE cl.id = fc.idClient GROUP BY cl.id;

# Clientii care au o val a tva-ului > 20
SELECT cl.*, res.tva FROM clienti cl,
(SELECT cl.id, SUM(res.tva) tva FROM clienti cl, facturi fc,
(SELECT pf.idFactura, SUM(pd.tva * pf.pret) tva FROM produse pd, `produs factura` pf
WHERE pd.id = pf.idProdus GROUP BY pf.idFactura) res
WHERE fc.idClient = cl.id AND fc.id = res.idFactura
GROUP BY cl.id) res
WHERE cl.id = res.id AND res.tva > 20;

# Media vanzarilor pe zi
SELECT data, COUNT(*)/(SELECT COUNT(*) FROM facturi) medie FROM facturi GROUP BY data;

# Media vanzarilor pe client
SELECT cl.nume,
(SELECT COUNT(*) FROM facturi WHERE idClient = cl.id) / (SELECT COUNT(*) FROM facturi) medie
FROM clienti cl;
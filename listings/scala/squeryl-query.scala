from(songs)(s => where(s.title like "%funk%") select(s))

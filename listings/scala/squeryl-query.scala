val songsFromThe60sInFunkAndLatinJazzPlaylist =
  from(songs)(s=>
    where(s.id in 
      from(funkAndLatinJazz.songsInPlaylistOrder)
      (s2 => select(s2.id))
    )
    select(s)
  )

  for(s <- songsFromThe60sInFunkAndLatinJazzPlaylist)
    println(s.title + " : " + s.year)

// Unikalni znajomi znajomych johna którzy mają więcej niż 20 lat
// Wyniki posortowane po wieku
{ john knows { some[Person] knows fof } } where {
  fof.age > 20
} orderBy {
  fof.age
} select(unique(fof))

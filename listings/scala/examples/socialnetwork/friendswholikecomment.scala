def friendsWhoLikeComment(person: Person, content: String) = {
  val (friend, comment) = (p[Person], p[Comment])
  val q = { person knows { friend likes comment } } where {
            comment.content == content
          } select(friend, comment)

  q.exec((f, c) => (f, c))
}

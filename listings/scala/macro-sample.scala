object Macros {
  def assert(cond: Boolean, msg: Any) = macro Asserts.assertImpl

  def assertImpl(c: Context)(cond: c.Expr[Boolean], msg: c.Expr[Any]) : c.Expr[Unit] = ???
}

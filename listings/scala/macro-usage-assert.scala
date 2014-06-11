// Przykładowe zastosowanie makra
val zero = 0
assert(zero == 10, "Not equal 10!")

// Jeden z przykładowych efektów makra 
// kod wstawiony w miejsce wywołania assert
// na etapie kompilacji
if(!(zero == 10)) {
  println("Assertion failed: Not equal 10! Expression: zero == 10");
}

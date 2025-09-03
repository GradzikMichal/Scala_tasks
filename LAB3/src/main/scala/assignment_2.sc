def fM(x: String): String = "f("+x+")"
def gM(x: String): String = "g("+x+")"
val fF: String => String = (x:String) => "f("+x+")"
val gF: String => String = (x:String) => "g("+x+")"
(fF andThen gF)("x")
(fM _ andThen gM _)("x")

def gM(x: String, leftPar:Char, rightPar:Char): String = {
  "g"+leftPar+x+rightPar
}
//(fM _ andThen gM(_: String, '[', ']'))("x")
(fM _ andThen (gM(_: String, '[', ']')))("x")
/*
* In the first command, second part needs an String argument
* but we didn't provide it at the start. Second command in the other hand
* is a partially applied function which mean we can later provide argument
* */

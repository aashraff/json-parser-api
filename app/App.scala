object App {
    def main(args: Array[String]) = {
        if(args.length > 0)
          println("JSON Parser API Demo " + args(0))
        else 
          println("JSON Parser API Demo!")
    }
}
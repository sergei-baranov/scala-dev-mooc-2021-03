package module1


import scala.language.{existentials, postfixOps}
import scala.math._

object App {

  def sqrtOpt(num: Double): Option[Double] = if (0 >= num) None else Some(Math.sqrt(num))
  def sqrtOptOpt(num: Double): opt.Option[Double] = if (0 >= num) opt.Option.None else opt.Option.Some(Math.sqrt(num))

  def main(args: Array[String]): Unit = {
    // нативный Option
    println("\n==== Option:")
    val boo: Option[Double] = sqrtOpt(-9)
    val moo: Option[Double] = sqrtOpt(144.0)
    val woo: Option[Double] = sqrtOpt(121.0)
    println("\nnative Option sum:")
    println(boo.getOrElse(0.0) + moo.getOrElse(0.0) + woo.getOrElse(0.0))
    // наш opt.Option
    println("\n==== opt.Option:")
    val boo2: opt.Option[Double] = sqrtOptOpt(-9)
    val moo2: opt.Option[Double] = sqrtOptOpt(144.0)
    val woo2: opt.Option[Double] = sqrtOptOpt(121.0)
    println("\nopt.Option sum:")
    println(boo2.getOrElse(0.0) + moo2.getOrElse(0.0) + woo2.getOrElse(0.0))

    // printIfAny
    println("\n==== printIfAny:")
    println("\nnative Option printIfAny: no such method for Option")
    println("\nopt.Option printIfAny:")
    boo2.printIfAny()
    moo2.printIfAny()
    woo2.printIfAny()

    // zip
    println("\n==== zip:")
    println("\nnative Option zip:")
    println(boo.zip(moo))
    println(moo.zip(boo))
    println(moo.zip(woo))
    println(moo.zip(woo).zip(moo))
    println("\nopt.Option zip:")
    println(boo2.zip(moo2))
    println(moo2.zip(boo2))
    println(moo2.zip(woo2))
    println(moo2.zip(woo2).zip(moo2))

    // filter
    println("\n==== filter:")
    println("\nnative Option filter:")
    println(boo.filter((n: Double) => {n % 2 == 0}))
    println(moo.filter((n: Double) => {n % 2 == 0}))
    println(woo.filter((n: Double) => {n % 2 == 0}))
    // filter
    println("\nopt.Option filter:")
    println(boo2.filter((n: Double) => {n % 2 == 0}))
    println(moo2.filter((n: Double) => {n % 2 == 0}))
    println(woo2.filter((n: Double) => {n % 2 == 0}))

    // map
    println("\n==== map:")
    println("\nnative Option map:")
    println(boo.map((n: Double) => n/2))
    println(moo.map((n: Double) => n/2))
    println(woo.map((n: Double) => n/2))
    println("\nopt.Option map:")
    println(boo2.map((n: Double) => n/2))
    println(moo2.map((n: Double) => n/2))
    println(woo2.map((n: Double) => n/2))

    // flatMap
    println("\n==== flatMap:")
    println("\nnative Option flatMap:")
    println(boo.flatMap((n: Double) => Option(n/2)))
    println(moo.flatMap((n: Double) => Option(n/2)))
    println(woo.flatMap((n: Double) => Option(n/2)))
    println("\nopt.Option flatMap:")
    println(boo2.flatMap((n: Double) => opt.Option.Some(n/2)))
    println(moo2.flatMap((n: Double) => opt.Option.Some(n/2)))
    println(woo2.flatMap((n: Double) => opt.Option.Some(n/2)))
  }
}


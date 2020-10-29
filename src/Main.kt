fun main () {
//    var p1 = Point(2F, 5F)
//    var p2 = Point(4F, 7F)
//    var p3 = Point(2F, 5F)
//
//    println(p1.equals(p2));
//    println(p1.equals(p3));
//
//    println(p1)

    var f2 = Fraction(3F, 4F)

    var f1 = Fraction(16F, 24F)

    f1.add(f2)

    f1 = Fraction(5F, 4F)
    f1.divide(f2)

    f1.simplify()

    println(f1)
}

fun GCD (n : Float, d: Float): Float {
    var n1: Int = n.toInt();
    var n2: Int = d.toInt();

    while (n1 != 0 && n2 != 0) {
        if (n1 > n2)
            n1 %= n2;
        else
            n2 %= n1;
    }

    return (n1 or n2).toFloat();
}

class Point (var x : Float, var y: Float) {

    override fun toString(): String {
        return "x = $x; y = $y"
    }

    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            return x == other.x && y == other.y;
        }

        return false;
    }
}

class Fraction(n: Float, d: Float) {

    private var numerator: Float = n
    private var denominator: Float = d

    override fun equals(other: Any?): Boolean {
        if (other is Fraction) {
            if (numerator * other.denominator / denominator == other.numerator) {
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

    fun baseMul (toMul: Float): Fraction {
        return Fraction(numerator * toMul, denominator * toMul);
    }

    fun simplify () {
        var div: Float = GCD(numerator, denominator);

        numerator /= div;
        denominator /= div;
    }

    fun add (toAdd: Fraction) {
        val f1: Fraction = this.baseMul(toAdd.denominator)
        val f2: Fraction = toAdd.baseMul(this.denominator)

        this.numerator = f1.numerator + f2.numerator;
        this.denominator = f1.denominator
    }

    fun divide (divider: Fraction) {
        numerator *= divider.denominator;
        denominator *= divider.numerator;
    }

    fun multiply (multiplier: Fraction) {
        numerator *= multiplier.numerator;
        denominator *= multiplier.denominator;
    }
}
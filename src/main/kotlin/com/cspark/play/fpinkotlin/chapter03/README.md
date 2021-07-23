# 3. 함수로 프로그래밍하기

내부에 아무 효과가 없어서 오로지 인자에 의해서만 반환 값이 결정되는 코틀린 함수느 수학 함수에 비유할 수 있다. 프로그래머들은 이런 함수르 종종 순수 함수(pure function)라고 부른다.

## 함수란 무엇인가

함수는 소스 집합(정의역, domain)과 타깃 집합(공역, codomain) 사이에서 어떤 조건을 만족시키는 대응 관계다.

### 두 함수 집합 사이의 대응 관계 이해하기

함수가 되기 위해서는 대응 관계가 한 가지 조건을 만족해야 한다. 정의역에 있는 모든 원소는 자신에 대응하는 원소가 공역에 꼭 하나 있어야 한다.

f(x) = x + 1

여기서 x는 양의 정수이다. 이 함수는 각 정수와 그 자신의 다음 값(successor)을 대응시킨다.
함수가 어떤 동작을 하는지가 아닌 어떤 것인지(정의)를 이야기하고 있음에 유의하라.

### 코틀린 역함수

함수에 역함수(inverse function)가 있을 수도 있고 없을 수도 있다.

> 코틀린은 함수 타입을 표현할 때 (A) -> B와 (B) -> A처럼 약간 다른 표현을 사용한다.

### 부분 함수 다루기

### 함수 합성 이해하기

### 인자를 여럿 받는 함수 사용하기

지금까지는 인자를 하나만 받는 함수에 대해 이야기했다. 함수가 인자를 여럿 받는다면 어떻게 될까? 간단히 말해, 인자가 여럿 있는 함수는 없다 함수의 정의를 기억하는가? 함수는 소스 집합과 타킷 집합 사이의 대응 관계다. 
두 집합의 곱(product)도 집합이다. 이런 곱집합을 정의역으로 하느 ㄴ함수를 만들면 여러 인자를 받는 함수처럼 보인다. 

f(x, y) -> x + y

이 함수는 N ᳵ N에서 N으로 가는 대응 관계이고 함수다. 하지만 이 함수의 인자는 N ᳵ N의 원소 하나뿐이다. N ᳵ N는 모든 정수 쌍으 집합이다. 이 집합의 원소는 정수의 쌍이고, 쌍은 여러 원소의 조합을 표현할 때 사용하는 **튜플(tuple)**이라는 개념의 특별한 경우다.
**쌍(Pair)**은 원소가 두 개인 튜플이다.

### 커리한 함수

튜플을 인자로 받는 함수를 다른 방식으로 생각할 수 있다. f(3,5)를 N을 정의역으로 하고 N상에 정의된 함수를 공역으로 하는 함수라고 생각할 수 있다.
f(x, y) -> x + y를 다음과 같이 다시 쓸 수 있다.

f(x)(y) -> x + y , f(x) -> g ∴ g(y) = x + y

g를 적용할 때 x는 더 이상 변수가 아니고 상수(constant)다. x의 값은 g에 전달되는 인자나 다른 외부 환경에 따라 결정되지 않는다. 

f(3)(5) = g(5) = 3 + 5 = 8

여기서 유일하게 새로운 것은 f의 공역이 수의 집합이 아니라 **함수의 집합**이라는 점이다.

f(x, y)를 f(x)(y)의 **커리한 형태(curried form)**라고 한다. 튜플에 대한 함수에 대해 이런 식의 변환을 적용해서 함수를 반환하는 함수로 바꾸는 과정을 **커링(currying)**이라고 한다.

### 부분 적용 함수 사용하기

커링의 유용성을 이해하기 위해 세율을 적용한 최종 가격을 게산하는 계산기를 사용하면서 세율이 다른 여러 나라를 다니는 경우를 생각해 보자.

f(rate, price) = price / 100 ( 100 + rate )
g(price, rate) = price / 100 ( 100 + rate )

이 두 함수를 커링한 버전은

f(rate)(price)
g(price)(rate)

f(rate)는 rate라는 세율로 고정된 경우 인자를 받은 가격에 대한 거래세를 알려주는 함수다.
g(price)는 price라는 고정된 가격에 인자로 받은 세율을 적용한 최종 금액을 돌려주는 함수다.

f(rate, price)와 g(price, rate) 같은 형태와 대비해 f(rate)나 g(price) 같은 형태의 함수를 때로는 부분 적용 함수(partially applied function)라고 부른다. 함수 인자를 평가할 때 부분 적용 함수가 큰 역할을 한다.

## 코틀린 함수

### 함수를 데이터를 이해하기

### 데이터를 함수로 이해하기

### 객체 생성자를 함수로 사용하기

객체 생성자는 사실 함수이다. 객체 생성 시 특별한 구문을 사용하는 자바와 달리, 코틀린은 함수 호출 구문을 사용한다.

순수 함수는 인자가 같을 때 같은 결과를 돌려줘야 한다 생성자는 순수 함수인가?

[생성자는 순수 함수?](pcspapa/play-fpinkotlin/src/test/kotlin/com/cspark/play/fpinkotlin/chapter03/ConstructorTest.kt)

### 코틀린 fun 함수 사용하기

[순수 함수와 순수하지 않은 함수](pcspapa/play-fpinkotlin/src/test/kotlin/com/cspark/play/fpinkotlin/chapter03/FunFunctionsTest.kt)

### 객체 표기법과 함수 표기법 비교

### 함수 값 사용하기

``` kotlin
val double: (Int) -> Int = { x -> x * 2 }
```

- double 함수의 타입은 (Int) -> Int다. 화살표의 왼쪽에는 파라미터 타입을 괄호로 둘러싸서 표시한다.
- 반환 타입은 화살표 오른쪽에 위치 한다.
- 함수 정의는 등호 뒤에 온다. 이때 함수 정의를 중괄호({})로 둘러싼 람다 식 형태를 사용한다.

> double은 함수 이름이 아니다. (람다로 정의한) 함수에는 이름이 없다. 여기서는 일반적인 데이터를 나중에 조직하기 위해 같은 타입의 참조에 대입하는 것처럼 이름이 없는 함수를 그 함수와 일치하는 타입의 참조에 대입한다.

### 함수 참조 사용하기

자바의 메소드 참조를 코틀린에서는 함수 참조라고 부른다.

### 함수 합성

```kotlin
fun square(n: Int) = n * n

fun triple(n: Int) = n * 3

println(square(triple(2)))
```

이는 함수 합성이 아니다. 이 코드는 함수 적용을 합성한 것이다.

> 연습문제 3-1
> 
> Q: Int에서 Int로 가는 함수의 합성을 허용하는 compose 함수를 작성하다.
> 
> A: Exercises.composeIntFun

### 함수 재사용하기

> 연습문제 3-2
>
> Q: compose 함수를 타입 파라미터를 사용하는 다형적 함수로 만들라.
>
> A: Exercises.composeFun

## 고급 함수 기능

"함수를 데이터로 표현할 필요가 있는가?" 이 질문에 답하기 전에 다인자(multi-argument) 함수의 문제를 생각해 봐야 한다.

### 인자가 여럿 있는 함수 처리하기

인자가 여럿 있는 함수란 존재하지 않는다. 단지 원소가 여러 개 들어 있는 튜플을 유일한 인자로 받는 함수만 존재한다고 말했다.

덧셈 함수의 타입은 다음과 같다.

```kotlin
(Int) -> (Int) -> Int

(Int) -> ((Int) -> Int)
```

> 연습문제 3-3
> 
> Q: 두 Int 값을 더하는 함수를 작성하라.
> 
> A: Exercises.add, Exercises.addTA

### 커리한 함수 적용하기

커리한 함수에 첫 번째 인자를 적용하 다음, 다시 두 번째 인자를 적용하라.

See ExercisesKtTest.add 
```kotlin 
println(add(3)(5))

8
``` 

### 고차 함수 구현하기

fun 함수(실제로는 메서드)로 작성한 함수 합성을 대신에 함수 값을 사용할 수도 있다. 함수를 인자로 받거나 함수를 결과로 돌려주는 함수를 고차 함수(HOF, Higher-Order Function)라고 부른다.

> 연습문제 3-4
> 
> Q: 두 함수를 합성하는 함수 값을 만들어라.
> 
> A: Exercises.compose, Exercises.composeTI, Exercises.composeTA

### 다형적 HOF 정의하기

코틀린에서는 다형적 프로퍼티를 정의할 수 없다.

> 연습문제 3-5
>
> Q: 다형적 compose 함수를 작성하라.
>
> A: Exercises.higherCompose

> 연습문제 3-5
>
> Q: 함수를 합성하되 적용 순서가 반대인 higherAndThen 함수를 정의하라.
>
> A: Exercises.higherAndThen

### 익명 함수 사용하기

```kotlin
val f: (Double) -> Double = { Math.PI / 2 - it }
val sin: (Double) -> Double = Math::sin
val cos: Double = compose(f, sin)(2.0)

val cosValue: Double = compose({Math.PI / 2 - it}, Math::sin)(2.0)
```

```kotlin
val cos = higherCompose<Double, Double, Double>()({ Math.PI / 2 - it })(Math::sin)

val cosValue: Double = cos(2.0)
```
```kotlin
// 권장함
val beset = (higherCompose<Double, Double, Double>()){ Math.PI / 2 - it }(Math::sin)
```

익명 함수 생성을 걱정하지 말라. 코틀린은 함수가 호출될 때마다 항상 객체를 생성하지는 않는다. 그리고 이런 익명 함수 객체를 생성하는 비용도 싸다.
대신 코드의 명확성과 유지 보수성만을 고려해 함수에 이름을 부여할지 익명 함수를 사용할지 결정하라. 성능이나 재사용성을 걱정한다면 함수 참조를 가능한 한 자주 사용하라.

### 로컬 함수 정의하기

함수 안에서 함수 값을 정의할 수 있다. 또한 함수 안에서 fun 함수도 선언할 수 있다.

### 클로저 구현하기

```kotlin
val taxRate = 0.09

fun addTax(price: Double) = price + price * taxRate
```
이 코드에서 addTax 함수는 taxRate라는 변수에 닫혀 있다. 하지만 이를 (price, taxRate)라는 튜플에 대한 함수로 볼 수 있다.

```kotlin
fun addTax(taxRate: Double, price: Double) = price + price * taxRate
```
이와 동일한 방법ㅂ을 함수 값세도 적용할 수 있다.

```kotlin
val addTax = { taxRate: Double, price: Double -> price + price * taxRate }
```
그런데 커리한 버전을 사용해 같은 결과를 얻을 수 있다.

```kotlin
val taxRate = 0.09

val addTax = { taxRate: Double ->
    { price: Double ->
        price + price * taxRate
    }
}

println(addTax(taxRate)(12))
```

### 함수 부분 적용과 자동 커링
앞의 코드에서 클로저 버전과 커리한 함수 버전은 같은 결과를 내놓기 때문에 동등한 것으로 보인다. 하지만 실제로 이 둘은 의미상 다르다.

```kotlin
class TaxComputer(private val rate: Double) {
    fun compute(price: Double): Doubel = price + price * taxRate
}

val tc9 = TaxComputer(0.09)
val price = tc9.compute(12.0)
```
커리한 함수를 부분 적용하면 똑같은 결과를 얻을 수 있다.

```kotlin
val tc9 = addTax(0.09)
val price = tc9(12.0)
```

커링과 부분 적용이 서로 밀접히 연관됐음을 알 수 있다. **커링은 튜플을 인자로 받는 함수를 한 번에 하나씩 인자를 부분 적용할 수 이쓴 함수로 대치하는 과정이다.**
튜플을 받는 함수의 경우 함수를 적용하기 전에 모든 인자를 평가해야 한다.

커링과 부분 적용 함수를 자동으로 수행하기 위해 추상화한다. 커리한 함수를 사용하면 부분 적용이 아주 단순하다는 장점이 있다.

> 연습문제 3-7
> 
> Q: 인자 두 개 받는 fun 함수르 작성하라. 이 함수의 두 번째 인자는 인자를 두 개 받는 커리한 함수이고, 첫 번째 인자의 타입은 두 번째 함수 인자(함수 값)의 첫 번째 인자와 같은 타입이다. 
> 이 함수는 두 번째 인자(함수 값)에 첫 번째 인자(값)을 적용한 결과(함수 값)를 돌려준다.
> 
> A: Exercises.partialA

> 연습문제 3-8
> 
> Q: 인자 두 개 받는 fun 함수를 작성하라. 이 함수의 두 번째 인자는 인자를 두 개 받는 커리한 함수이고, 첫 번째 인자의 타입은 두 번째 인자(함수 값)의 두 번째 인자와 같은 타입니다.
> 이 함수는 두 번째 인자(함수 값)의 두 번째 인자에 첫 번째 인자(값)을 적용한 값(함수 값)를 돌려준다.
> 
> A: Exercises.partialB

가장 중요한 사실은 함수의 커리한 버전을 사용한다는 점이다. 
재사용할 수 있는 프로그램을 만든기 위해 추상화를 한계까지 밀어붙이는 과장에서 자주 수행해야 할 작업 하나는 튜플을 인자로 받는 함수를 커리한 함수로 바꾸는 것이다.

> 연습문제 3-9
>
> Q: 다음 함수를 커리한 함수로 변환하라.
>    fun <A, B, C, D> func(a: A, b: B, c: C, d: D): String = "$a $b $c $d"
> 
> A: Exercises.curried

> 연습문제 3-10
>
> Q: (A, B)에서 C로 가는 함수를 커리한 함수로 바꾸는 함수를 작성하라. 
> 
> A: Exercises.curry

### 부분 적용 함수의 인자 뒤바꾸기

> 연습문제 3-11
>
> Q: 커리한 함수의 두 인자의 순서를 뒤바꾼 새로운 함수를 반환하는 fun 함수를 작성하라.
>
> A: Exercises.swapArgs

### 항등 함수 정의하기

```kotlin
val identity = { it }  // 구체적인 타입을 지정해야 컴파일 오류가 나지 않음
```

### 올바른 타입 사용하기

표준 타입을 사용할 때 생기는 문제 파하기

```kotlin
data class Product(val name: String, val price: Double, val weight: Double)

data class OrderLine(val product: Product, val count: Int) {
    fun weight() = product.weight * count
    fun amount() = product.price * count
}
```

값 타입 정의하기

```kotlin
data class Price(val value: Double) {
    operator fun plus(price: Price) = Price(this.value + price.value)
    
    operator fun times(num: Int) = Price(this.value * num)
}

data class Weight(val value: Double) {
    operator fun plus(weight: Weight) = Weight(this.value = weight.value)

    operator fun times(num: Int) = Weight(this.value * num)
}

data class Product(val name: String, val price: Price, val weight: Weight)

data class OrderLine(val product: Product, val count: Int) {
    fun weight() = product.weight * count
    fun amount() = product.price * count
}
```

이 보다 더 잘 할 수 있다. 우선 Price와 Weight에 검증을 추가한다.

```kotlin
data class Price private constructor (private val value: Double) {
    override fun toString() = value.toString() 
    operator fun plus(price: Price) = Price(this.value + price.value)
    operator fun times(num: Int) = Price(this.value * num)
    
    companion object {
        val identity = Price(0.0)
        operator fun invoke(value: Double) =
            if (value > 0)
                Price(value)
            else
                throw IllegalArgumentException("Price must be positive or null")
    }
}
```
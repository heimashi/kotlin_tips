# 怎么用Kotlin去提高生产力：Kotlin Tips

汇总Kotlin相对于Java的优势，以及怎么用Kotlin去简洁、务实、高效、安全的开发，每个小点tip都有详细的说明和案例代码，争取把每个tip弄得清楚易懂。


## Tip1- 更简洁的字符串

详见案例代码[KotlinTip1](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip1/KotlinTip1.kt)

Kotlin中的字符串基本Java中的类似，有一点区别是加入了三个引号"""来方便长篇字符的编写。
而在Java中，这些都需要转义，先看看java中的式例
```java
    public void testString1() {
        String str1 = "abc";
        String str2 = "line1\n" +
                "line2\n" +
                "line3";
        String js = "function myFunction()\n" +
                "{\n" +
                "    document.getElementById(\"demo\").innerHTML=\"My First JavaScript Function\";\n" +
                "}";
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(js);
    }
```
kotlin除了有单个双引号的字符串，还对字符串的加强，引入了**三个引号**，"""中可以包含换行、反斜杠等等特殊字符：
```kotlin
/*
* kotlin对字符串的加强，三个引号"""中可以包含换行、反斜杠等等特殊字符
* */
fun testString() {
    val str1 = "abc"
    val str2 = """line1\n
        line2
        line3
        """
    val js = """
        function myFunction()
        {
            document.getElementById("demo").innerHTML="My First JavaScript Function";
        }
        """.trimIndent()
    println(str1)
    println(str2)
    println(js)
}
```
同时，Kotlin中引入了**字符串模版**，方便字符串的拼接，可以用$符号拼接变量和表达式
```kotlin
/*
* kotlin字符串模版，可以用$符号拼接变量和表达式
* */
fun testString2() {
    val strings = arrayListOf("abc", "efd", "gfg")
    println("First content is $strings")
    println("First content is ${strings[0]}")
    println("First content is ${if (strings.size > 0) strings[0] else "null"}")
}
```

## Tip2- Kotlin中大多数控制结构都是表达式

首先，需要弄清楚一个概念**语句和表达式**，然后会介绍控制结构表达式的优点：**简洁**
#### 语句和表达式是什么？
- 表达式有值，并且能作为另一个表达式的一部分使用
- 语句总是包围着它的代码块中的顶层元素，并且没有自己的值
#### Kotlin与Java的区别
- Java中，所有的控制结构都是语句，也就是控制结构都没有值
- Kotlin中，除了循环（for、do和do/while）以外，大多数控制结构都是表达式(if/when等)


详见案例代码[tip2](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip2)
#### Example1：if语句
java中，if 是语句，没有值，必须显示的return
```java
/*
* java中的if语句
* */
public int max(int a, int b) {
    if (a > b) {
        return a;
    } else {
        return b;
    }
}
```
kotlin中，if 是表达式，不是语句，因为表达式有值，可以作为值return出去
```kotlin
/*
* kotlin中，if 是表达式，不是语句，类似于java中的三木运算符a > b ? a : b
* */
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
```
上面的if中的分支最后一行语句就是该分支的值，会作为函数的返回值。这其实跟java中的三元运算符类似，
```java
/*
* java的三元运算符
* */
public int max2(int a, int b) {
    return a > b ? a : b;
}
```
上面是java中的三元运算符，kotlin中if是表达式有值，完全可以替代，**故kotlin中已没有三元运算符了**，用if来替代。
上面的max函数还可以简化成下面的形式
```kotlin
/*
* kotlin简化版本
* */
fun max2(a: Int, b: Int) = if (a > b) a else b
```

#### Example2：when语句
Kotlin中的when非常强大，完全可以取代Java中的switch和if/else，同时，**when也是表达式**，when的每个分支的最后一行为当前分支的值
先看一下java中的switch
```java
    /*
    * java中的switch
    * */
    public String getPoint(char grade) {
        switch (grade) {
            case 'A':
                return "GOOD";
            case 'B':
            case 'C':
                return "OK";
            case 'D':
                return "BAD";
            default:
                return "UN_KNOW";
        }
    }
```
java中的switch有太多限制，我们再看看Kotlin怎样去简化的
```kotlin
/*
* kotlin中，when是表达式，可以取代Java 中的switch，when的每个分支的最后一行为当前分支的值
* */
fun getPoint(grade: Char) = when (grade) {
    'A' -> "GOOD"
    'B', 'C' -> {
        println("test when")
        "OK"
    }
    'D' -> "BAD"
    else -> "UN_KNOW"
}
```
同样的，when语句还可以取代java中的if/else if，其是表达式有值，并且更佳简洁
```java
    /*
    * java中的if else
    * */
    public String getPoint2(Integer point) {
        if (point > 100) {
            return "GOOD";
        } else if (point > 60) {
            return "OK";
        } else if (point.hashCode() == 0x100) {
            //...
            return "STH";
        } else {a
            return "UN_KNOW";
        }
    }
```
再看看kotlin的版本，使用**不带参数的when**，只需要6行代码
```kotlin
/*
* kotlin中，when是表达式，可以取代java的if/else，when的每个分支的最后一行为当前分支的值
* */
fun getPoint2(grade: Int) = when {
    grade > 90 -> "GOOD"
    grade > 60 -> "OK"
    grade.hashCode() == 0x100 -> "STH"
    else -> "UN_KNOW"
}
```

## Tip3- 更好调用的函数：显示参数名/默认参数值

Kotlin的函数更加好调用，主要是表现在两个方面：1，显示的**标示参数名**，可以方便代码阅读；2，函数可以有**默认参数值**，可以大大**减少Java中的函数重载**。
例如现在需要实现一个工具函数，打印列表的内容：
详见案例代码[KotlinTip3](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip3/KotlinTip3.kt)
```kotlin
/*
* 打印列表的内容
* */
fun <T> joinToString(collection: Collection<T>,
                     separator: String,
                     prefix: String,
                     postfix: String): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
/*
* 测试
* */
fun printList() {
    val list = listOf(2, 4, 0)
    /*不标明参数名*/
    println(joinToString(list, " - ", "[", "]"))
    /*显示的标明参数名称*/
    println(joinToString(list, separator = " - ", prefix = "[", postfix = "]"))
}
```
如上面的代码所示，函数joinToString想要打印列表的内容，需要传人四个参数：列表、分隔符、前缀和后缀。
由于参数很多，在后续使用该函数的时候不是很直观的知道每个参数是干什么用的，这时候可以显示的标明参数名称，增加代码可读性。
同时，定义函数的时候还可以给函数默认的参数，如下所示：
```kotlin
/*
* 打印列表的内容，带有默认的参数，可以避免java的函数重载
* */
fun <T> joinToString2(collection: Collection<T>,
                      separator: String = ", ",
                      prefix: String = "",
                      postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
/*
* 测试
* */
fun printList3() {
    val list = listOf(2, 4, 0)
    println(joinToString2(list, " - "))
    println(joinToString2(list, " , ", "["))
}
```
这样有了默认参数后，在使用函数时，如果不传入该参数，默认会使用默认的值，这样可以避免Java中大量的函数重载。

## Tip4- 扩展函数和属性
扩展函数和属性是Kotlin非常方便实用的一个功能，它可以让我们随意的扩展第三方的库，你如果觉得别人给的SDK的api不好用，或者不能满足你的需求，这时候你可以用扩展函数完全去自定义。
例如String类中，我们想获取最后一个字符，String中没有这样的直接函数，你可以用.后声明这样一个扩展函数：
详见案例代码[KotlinTip4](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip4/KotlinTip4.kt)
```kotlin
/*
* 扩展函数
* */
fun String.lastChar(): Char = this.get(this.length - 1)
/*
*测试
* */
fun testFunExtension() {
    val str = "test extension fun";
    println(str.lastChar())
}
```
这样定义好lastChar()函数后，之后只需要import进来后，就可以用String类直接调用该函数了，跟调用它自己的方法没有区别。这样可以避免重复代码和一些静态工具类，而且代码更加简洁明了。
例如我们可以改造上面tip3中的打印列表内容的函数：
```kotlin
/*
* 用扩展函数改造Tip3中的列表打印内容函数
* */
fun <T> Collection<T>.joinToString3(separator: String = ", ",
                                    prefix: String = "",
                                    postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun printList4() {
    val list = listOf(2, 4, 0)
    println(list.joinToString3("/"))
}
```
除了扩展函数，还可以扩展属性，例如我想实现String和StringBuilder通过属性去直接获得最后字符：
```kotlin
/*
* 扩展属性 lastChar获取String的最后一个字符
* */
val String.lastChar: Char
    get() = get(length - 1)
/*
* 扩展属性 lastChar获取StringBuilder的最后一个字符
* */
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        setCharAt(length - 1, value)
    }
/*
* 测试
* */
fun testExtension(){
    val s = "abc"
    println(s.lastChar)
    val sb = StringBuilder("abc")
    println(sb.lastChar)
}
```
定义好扩展属性后，之后只需import完了就跟使用自己的属性一样方便了。

#### Why？Kotlin为什么能实现扩展函数和属性这样的特性？
在Kotlin中要理解一些语法，只要认识到**Kotlin语言最后需要编译为class字节码，Java也是编译为class执行，也就是可以大致理解为Kotlin需要转成Java一样的语法结构**，
Kotlin就是一种**强大的语法糖**而已，Java不具备的功能Kotlin也不能越界的。
- 那Kotlin的扩展函数怎么实现的呢？介绍一种万能的办法去理解Kotlin的语法：**将Kotlin代码转化成Java语言**去理解，步骤如下：
    - 在Android Studio中选择Tools ---> Kotlin ---> Show Kotlin Bytecode 这样就把Kotlin转化为class字节码了
    - class码阅读不太友好，点击左上角的Decompile就转化为Java
- 再介绍一个小窍门，在前期对Kotlin语法不熟悉的时候，可以先用Java写好代码，再利用AndroidStudio工具**将Java代码转化为Kotlin代码**，步骤如下：
    - 在Android Studio中选中要转换的Java代码 ---> 选择Code ---> Convert Java File to Kotlin File

我们看看将上面的扩展函数转成Java后的代码
```java
/*
* 扩展函数会转化为一个静态的函数，同时这个静态函数的第一个参数就是该类的实例对象
* */
public static final char lastChar(@NotNull String $receiver) {
    Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
    return $receiver.charAt($receiver.length() - 1);
}
/*
* 获取的扩展属性会转化为一个静态的get函数，同时这个静态函数的第一个参数就是该类的实例对象
* */
public static final char getLastChar(@NotNull StringBuilder $receiver) {
    Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
    return $receiver.charAt($receiver.length() - 1);
}
/*
* 设置的扩展属性会转化为一个静态的set函数，同时这个静态函数的第一个参数就是该类的实例对象
* */
public static final void setLastChar(@NotNull StringBuilder $receiver, char value) {
    Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
    $receiver.setCharAt($receiver.length() - 1, value);
}
```
查看上面的代码可知：对于扩展函数，转化为Java的时候其实就是一个静态的函数，同时这个静态函数的第一个参数就是该类的实例对象，这样把类的实例传人函数以后，函数内部就可以访问到类的公有方法。
对于扩展属性也类似，获取的扩展属性会转化为一个静态的get函数，同时这个静态函数的第一个参数就是该类的实例对象，设置的扩展属性会转化为一个静态的set函数，同时这个静态函数的第一个参数就是该类的实例对象。
函数内部可以访问公有的方法和属性。
- 从上面转换的源码其实可以看到**扩展函数和扩展属性适用的地方和缺陷**，有两点：
    - 扩展函数和扩展属性内**只能访问到类的公有方法和属性**，私有的和protected是访问不了的
    - 扩展函数**不能被override**，因为Java中它是静态的函数
- 下面再举几个扩展函数的例子，让大家感受一下扩展函数的方便：
```kotlin
/*
* show toast in activity
* */
fun Activity.toast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

val Context.inputMethodManager: InputMethodManager?
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

/*
* hide soft input
* */
fun Context.hideSoftInput(view: View) {
    inputMethodManager?.hideSoftInputFromWindow(view.windowToken, 0)
}


/**
 * screen width in pixels
 */
val Context.screenWidth
    get() = resources.displayMetrics.widthPixels

/**
 * screen height in pixels
 */
val Context.screenHeight
    get() = resources.displayMetrics.heightPixels

/**
 * returns dip(dp) dimension value in pixels
 * @param value dp
 */
fun Context.dip2px(value: Int): Int = (value * resources.displayMetrics.density).toInt()
```

## Tip5- 懒初始化by lazy 和 延迟初始化lateinit
#### 懒初始化by lazy
懒初始化是指推迟一个变量的初始化时机，变量在使用的时候才去实例化，这样会更加的高效。因为我们通常会遇到这样的情况，一个变量直到使用时才需要被初始化，或者仅仅是它的初始化依赖于某些无法立即获得的上下文。
详见案例代码[KotlinTip5](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip5/KotlinTip5.kt)
```kotlin
/*
* 懒初始化api实例
* */
val purchasingApi: PurchasingApi by lazy {
    val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    retrofit.create(PurchasingApi::class.java)
}
```
像上面的代码，retrofit生成的api实例会在首次使用到的时候才去实例化。需要注意的是by lazy一般只能修饰val不变的对象，不能修饰var可变对象。
```kotlin
class User(var name: String, var age: Int)

/*
* 懒初始化by lazy
* */
val user1: User by lazy {
    User("jack", 15)
}
```

#### 延迟初始化lateinit
另外，对于var的变量，如果类型是非空的，是必须初始化的，不然编译不通过，这时候需要用到lateinit延迟初始化，使用的时候再去实例化。
```kotlin
/*
* 延迟初始化lateinit
* */
lateinit var user2: User

fun testLateInit() {
    user2 = User("Lily", 14)
}
```
#### by lazy 和 lateinit 的区别
- by lazy 修饰val的变量
- lateinit 修饰var的变量，且变量是非空的类型

## Tip6- 不用再手写findViewById
在Android的View中，会有很多代码是在声明一个View，然后通过findViewById后从xml中实例化赋值给对应的View。在kotlin中可以完全解放出来了，不用再手写findViewById。步骤如下：
详见案例代码[KotlinTip6](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip6/KotlinTip6.kt)
- 步骤1，在项目的gradle中 apply plugin: 'kotlin-android-extensions'
- 步骤2，按照原来的习惯书写布局xml文件
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tip6_tv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <ImageView
        android:id="@+id/tip6_img"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:id="@+id/tip6_btn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
```
- 步骤3，在java代码中import对应的布局就可以开始使用了，View不用提前声明，插件会自动根据布局的id生成对应的View
```kotlin
import com.sw.kotlin.tips.R
/*
* 导入插件生成的View
* */
import kotlinx.android.synthetic.main.activity_tip6.*

class KotlinTip6 : Activity(){

    /*
    * 自动根据layout的id生成对应的view
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip6)
        tip6_tv.setText("Auto find view for TextView")
        tip6_img.setImageBitmap(null)
        tip6_btn.setOnClickListener{
            //todo sth
        }
    }

}
```
像上面代码这样，Activity里的三个View自动生成了，不用再去声明，然后findViewById，然后转型赋值，是不是减少了很多没必要的代码，让代码非常的干净。

## Tip7- 利用局部函数抽取重复代码
Kotlin中提供了函数的嵌套，在函数内部还可以定义新的函数。这样我们可以在函数中嵌套这些提前的函数，来抽取重复代码。如下面的案例所示:
详见案例代码[KotlinTip7](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip7/KotlinTip7.kt)
```kotlin
class User(val id: Int, val name: String, val address: String, val email: String)

fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }
    if (user.email.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Email")
    }
    //save to db ...
}
```
上面的代码在判断name、address等是否为空的处理其实很类似。这时候，我们可以利用在函数内部嵌套的声明一个通用的判空函数将相同的代码抽取到一起：
```kotlin
/*
*利用局部函数抽取相同的逻辑，去除重复的代码
* */
fun saveUser2(user: User) {
    fun validate(value: String, fildName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty $fildName")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
    validate(user.email, "Email")
    //save to db ...
}
```
除了利用嵌套函数去抽取，此时，其实也可以用扩展函数来抽取，如下所示：
```kotlin
/*
* 利用扩展函数抽取逻辑
* */
fun User.validateAll() {
    fun validate(value: String, fildName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fildName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
    validate(email, "Email")
}

fun saveUser3(user: User) {
    user.validateAll()
    //save to db ...
}
```

## Tip8- 使用数据类来快速实现model类
在java中要声明一个model类需要实现很多的代码，首先需要将变量声明为private，然后需要实现get和set方法，还要实现对应的hashcode equals toString方法等，如下所示：
详见案例代码[Tip8](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip8)
```java
    public static class User{

        private String name;
        private int age;
        private int gender;
        private String address;
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    ", address='" + address + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (age != user.age) return false;
            if (gender != user.gender) return false;
            if (name != null ? !name.equals(user.name) : user.name != null) return false;
            return address != null ? address.equals(user.address) : user.address == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            result = 31 * result + gender;
            result = 31 * result + (address != null ? address.hashCode() : 0);
            return result;
        }
    }
```
这段代码Java需要70行左右，而如果用kotlin，只需要一行代码将可以做到。
```kotlin
/*
* Kotlin会为类的参数自动实现get set方法
* */
class User(val name: String, val age: Int, val gender: Int, var address: String)

/*
* 用data关键词来声明一个数据类，除了会自动实现get set，还会自动生成equals hashcode toString
* */
data class User2(val name: String, val age: Int, val gender: Int, var address: String)
```
对于Kotlin中的类，会为它的参数自动实现get set方法。而如果加上data关键字，还会自动生成equals hashcode toString。原理其实数据类中的大部分代码都是模版代码，Kotlin聪明的将这个模版代码的实现放在了编译器处理的阶段。


## Tip9- 用类委托来快速实现装饰器模式
通过继承的实现容易导致脆弱性，例如如果需要修改其他类的一些行为，这时候Java中的一种策略是采用**装饰器模式**：创建一个新类，实现与原始类一样的接口并将原来的类的实例作为一个成员变量。
与原始类拥有相同行为的方法不用修改，只需要直接转发给原始类的实例。如下所示：
详见案例代码[KotlinTip9](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip9/KotlinTip9.kt)
```kotlin
/*
* 常见的装饰器模式，为了修改部分的函数，却需要实现所有的接口函数
* */
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> {

    var objectAdded = 0
    
    override val size: Int
        get() = innerSet.size

    /*
    * 需要修改的方法
    * */
    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    /*
    * 需要修改的方法
    * */
    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }

    override fun contains(element: T): Boolean {
        return innerSet.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return innerSet.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return innerSet.isEmpty()
    }

    override fun clear() {
        innerSet.clear()
    }

    override fun iterator(): MutableIterator<T> {
        return innerSet.iterator()
    }

    override fun remove(element: T): Boolean {
        return innerSet.remove(element)
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        return innerSet.removeAll(elements)
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        return innerSet.retainAll(elements)
    }

}
```
如上所示，想要修改HashSet的某些行为函数add和addAll，需要实现MutableCollection接口的所有方法，将这些方法转发给innerSet去具体的实现。虽然只需要修改其中的两个方法，其他代码都是模版代码。
**只要是重复的模版代码，Kotlin这种全新的语法糖就会想办法将它放在编译阶段再去生成。**
这时候可以用到**类委托by关键字**，如下所示：
```kotlin
/*
* 通过by关键字将接口的实现委托给innerSet成员变量，需要修改的函数再去override就可以了
* */
class CountingSet2<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {

    var objectAdded = 0

    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }
}
```
通过by关键字将接口的实现委托给innerSet成员变量，需要修改的函数再去override就可以了，通过类委托将10行代码就可以实现上面接近100行的功能，简洁明了，去掉了模版代码。

## Tip10- Lambda表达式简化代码
详见案例代码[KotlinTip10](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip10/KotlinTip10.kt)
lambda表达式可以简化我们的代码。以Android中常见的OnClickListener来说明，在Java中我们一遍这么去设置：
```java
        TextView textView = new TextView(context);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //handle click
            }
        });
```
Java中需要声明一个匿名内部类去处理，这种情况可以用lambda表达式来简化。
- lambda表达式一般长这样
    - { x:Int, y:Int -> x+y }
    - 参数 -> 表达式 并且始终在大括号中
    - it作为默认参数名
    - lambda捕捉，当捕捉final变量时，它的值和lambda代码一起存储
    - 而非final变量，它的值被封装在一个特殊的包装器中，而这个包装器的引用会和lambda代码一起存储
    
我们来看看Kotlin中的例子：
```kotlin
    val textView = TextView(context)

    /*
    * 传统形势
    * */
    textView.setOnClickListener(object : android.view.View.OnClickListener {
        override fun onClick(v: android.view.View?) {
            //handle click
        }
    })

    /*
    * lambda的形势
    * */
    textView.setOnClickListener({ v ->
        {
            //handle click
        }
    })
```
当lambda的参数没有使用时可以省略，省略的时候用it来替代
```kotlin
    /*
    * lambda的参数如果没有使用可以省略，省略的时候用it来替代
    * */
    textView.setOnClickListener({
        //handle click
    })
```
lambda在参数的最后一个的情况可以将之提出去
```kotlin
    /*
    * lambda在参数的最后一个的情况可以将之提出去
    * */
    textView.setOnClickListener() {
        //handle click
    }
```
lambda提出去之后，函数如果没有其他参数括号可以省略
```kotlin
    /*
    * lambda提出去之后，函数如果没有其他参数括号可以省略
    * */
    textView.setOnClickListener {
        //handle click
    }
```
我们再看看如果自己去实现一个带lambda参数的函数应该怎么去定义：
```kotlin
interface OnClickListener {
    fun onClick()
}

class View {
    var listener: OnClickListener? = null;

    /*
    * 传统方式的
    * */
    fun setOnClickListener(listener: OnClickListener) {
        this.listener = listener
    }

    fun doSth() {
        //some case:
        listener?.onClick()
    }

    /*
    * 声明lambda形势，listener: () -> Unit
    * */
    fun setOnClickListener(listener: () -> Unit) {

    }
}
```
在函数参数中需要声明lambda的类型后，再调用该函数的时候就可以传人一个lambda表达式了。

## Tip11- with语句来简化代码

- with 函数原型：
```kotlin
inline fun <T, R> with(receiver: T, f: T.() -> R): R = receiver.f()
```
- with函数并不是扩展函数，返回值是最后一行，可以直接调用对象的方法


Kotlin中可以用with语句来省略同一个变量的多次声明，例如下面的函数
详见案例代码[KotlinTip11](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip11/KotlinTip11.kt)
```kotlin
/*
*打印字母表函数，在函数内result变量在好几处有使用到
* */
fun alphabet(): String {
    val result = StringBuilder()
    result.append("START\n")
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nEND")
    return result.toString()
}
```
在上面的函数中，result变量出现了5次，如果用with语句，可以将这5次都不用再出现了，我们来一步一步地看是怎么实现的：
```kotlin
/*
* 通过with语句，将result作为参数传人，在内部就可以通过this来表示result变量了
* */
fun alphabet2(): String {
    val result = StringBuilder()
    return with(result) {
        this.append("START\n")
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("\nEND")
        this.toString()
    }
}
```
通过with语句，将result作为参数传人，在内部就可以通过this来表示result变量了，而且这个this是可以省略的

```kotlin
/*
* 通过with语句，将result参数作为参数，在内部this也可以省略掉
* */
fun alphabet3(): String {
    val result = StringBuilder()
    return with(result) {
        append("START\n")
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nEND")
        toString()
    }
}
```
在内部this省略掉后，现在只有一个result了，这个其实也是没必要的，于是出现了下面的最终版本：
```kotlin
/*
* 通过with语句，可以直接将对象传人，省掉对象的声明
* */
fun alphabet4(): String {
    return with(StringBuilder()) {
        append("START\n")
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nEND")
        toString()
    }
}
```
像上面这样的，我们把同一个变量的声明从5次变为了0次，发现Kotlin的魅力了吧。

## Tip12- apply语句来简化代码

- apply 函数原型：
```kotlin
inline fun <T> T.apply(block: T.() -> Unit): T { block(); return this }
```
- apply函数，在函数范围内，可以任意调用该对象的任意方法，并返回该对象


除了用上面的with可以简化同一个变量的多次声明，还可以用apply关键字，我们来改造一下tip11中的函数：
详见案例代码[KotlinTip12](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip12/KotlinTip12.kt)
```kotlin
/*
* 用apply语句简化代码，在apply的大括号里可以访问类的公有属性和方法
* */
fun alphabet5() = StringBuilder().apply {
    append("START\n")
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nEND")
}.toString()
```
像上面这样的，通过apply后，在apply的大括号里可以访问类的公有属性和方法。这在对应类的初始化是非常方便的，例如下面的例子
```kotlin
/*
* 用apply语句简化类的初始化，在类实例化的时候，就可以通过apply把需要初始化的步骤全部实现，非常的简洁
* */
fun testApply(context: Context) {
    var imgView = ImageView(context).apply {
        setBackgroundColor(0)
        setImageBitmap(null)
    }

    var textView = TextView(context).apply {
        text = "content"
        textSize = 20.0f
        setPadding(10, 0, 0, 0)
    }
    
    var user = User().apply { 
        age = 15
        name = "Jack"
        val a = address
        address = "bbb"
    }
}
```
在类实例化的时候，就可以通过apply把需要初始化的步骤全部实现，非常的简洁

## Tip13- 在编译阶段避免掉NullPointerException

NullPointerException是Java程序员非常头痛的一个问题，我们知道Java 中分受检异常和非受检异常，NullPointerException是非受检异常，也就是说NullPointerException不需要显示的去catch住，
往往在运行期间，程序就可能报出一个NullPointerException然后crash掉，Kotlin作为一门高效安全的语言，它尝试在编译阶段就把空指针问题显式的检测出来，把问题留在了编译阶段，让程序更加健壮。
详见案例代码[KotlinTip13](https://github.com/heimashi/kotlin_tips/blob/master/app/src/main/java/com/sw/kotlin/tip13/KotlinTip13.kt)
- Kotlin中类型分为可空类型和不可空类型，通过？代表可空，不带？代表不可为空
```kotlin
fun testNullType() {
    val a: String = "aa"
    /*
    * a是非空类型，下面的给a赋值为null将会编译不通过
    * */
    //a = null
    a.length

    /*
   * ？声明是可空类型，可以赋值为null
   * */
    var b: String? = "bb"
    b = null
    
    /*
   * b是可空类型，直接访问可空类型将编译不通过，需要通过?.或者!!.来访问
   * */
    //b.length
    b?.length
    b!!.length
}
```
- 对于一个不可为空类型：如果直接给不可为空类型赋值一个可能为空的对象就在编译阶段就不能通过
- 对于一个可空类型：通过？声明，在访问该类型的时候直接访问不能编译通过，需要通过?.或者!!.
    - ?.  代表着如果该类型为空的话就返回null不做后续的操作，如果不为空的话才会去访问对应的方法或者属性
    - !!. 代表着如果该类型为空的话就抛出NullPointerException，如果不为空就去访问对应的方法或者属性，
    所以只有在很少的特定场景才用这种符号，代表着程序不处理这种异常的case了，会像java代码一样抛出NullPointerException。
    而且代码中一定不用出现下面这种代码，会让代码可读性很差而且如果有空指针异常，我们也不能马上发现是哪空了：
```kotlin
    /*
    * 不用链式的连续用!!.
    * */
    val user = User()
    user!!.name!!.subSequence(0,5)!!.length
```
对应一个可空类型，每次对它的访问都需要带上?.判断
```kotlin
val user: User? = User()

    /*
    * 每次访问都用用?.判断
    * */
    user?.name
    user?.age
    user?.toString()
```
但这样多了很多代码，kotlin做了一些优化，
```kotlin
    /*
    * 或者提前判断是否为空，如果不为空在这个分支里会自动转化为非空类型就可以直接访问了
    * */
    if (user != null) {
        user.name
        user.age
        user.toString()
    }
```
通过if提前判断类型是否为空，如果不为空在这个分支里会**自动转化为非空类型**就可以直接访问了。
#### let语句简化对可空对象对访问
- let 函数原型：
```kotlin
inline fun <T, R> T.let(block: (T) -> R): R = block(this)
```
- let函数默认当前这个对象作为闭包的it参数，返回值是函数里面最后一行，或者指定return。


上面的代码还可以用?.let语句进行，如下所示：
```kotlin
    /*
    * 通过let语句，在?.let之后，如果为空不会有任何操作，只有在非空的时候才会执行let之后的操作
    * */
    user?.let {
        user.name
        user.age
        user.toString()
    }
```
通过let语句，在?.let之后，如果为空不会有任何操作，只有在非空的时候才会执行let之后的操作

## Tip14-


## Tip15-


## Tip16-




### 参考文档
* 《Kotlin in Action》
* https://savvyapps.com/blog/kotlin-tips-android-development

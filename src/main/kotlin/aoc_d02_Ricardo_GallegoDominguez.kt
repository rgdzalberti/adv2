import java.io.File

val movesetList = mutableListOf<String>()
val upList = mutableListOf<String>()
val downList = mutableListOf<String>()
val forwardList = mutableListOf<String>()


fun main() {

    var file: File = File("C:\\Users\\usuarioT\\Desktop\\advent\\input.txt")

    file.forEachLine { movesetList.add(it)}

    movesetList.forEach {if (it.contains("up")) {upList.add(it)} }
    movesetList.forEach {if (it.contains("down")) {downList.add(it)} }
    movesetList.forEach {if (it.contains("forward")) {forwardList.add(it)} }


    val upNumbers = mutableListOf<Int>()
    val downNumbers = mutableListOf<Int>()
    val forwardNumbers = mutableListOf<Int>()

    upList.forEach {upNumbers.add(it.removeRange(0,3).toInt())}
    downList.forEach {downNumbers.add(it.removeRange(0,5).toInt())}
    forwardList.forEach {forwardNumbers.add(it.removeRange(0,8).toInt())}

    var horizontal: Int = 0
    var depth:  Int = 0

    var down:  Int = 0
    var up: Int = 0

    for (i in 0 until forwardNumbers.size) {horizontal = horizontal + forwardNumbers[i]}
    for (i in 0 until upNumbers.size) {up = up + upNumbers[i]}
    for (i in 0 until downNumbers.size) {down = down + downNumbers[i]}

    depth = down - up

    var result = horizontal * depth
    println(result)

    //Parte 2

    var aim : Int = 0
    horizontal = 0
    depth = 0

    //Con un algoritmo parecido a este de abajo podría haber hecho la parte 1 en 80% menos de líneas pero no se me ha ocurrido antes
    file.forEachLine {
        when{
            it.contains("forward") -> {horizontal = horizontal + it.removeRange(0,8).toInt(); if (aim != 0) {depth = depth + aim * it.removeRange(0,8).toInt()  }}
            it.contains("up") -> {aim = aim - it.removeRange(0,3).toInt()}
            it.contains("down") -> {aim = aim + it.removeRange(0,5).toInt() }
        }
    }
    aim = horizontal * depth
    println(aim)


}
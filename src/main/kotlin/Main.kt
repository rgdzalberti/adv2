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

    var upDelimiter = "up"
    var downDelimiter = "down"
    var forwardDelimiter = "forward"

    val upNumbers = upList.split(upDelimiter)
    //val upNumbers = upList.forEach {split(upDelimiter)}

}
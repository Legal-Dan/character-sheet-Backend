import java.util.*
interface CommandReader{
    fun getNextLine():String
}

class Reader(val scanner: Scanner): CommandReader {
    override fun getNextLine():String {
        return scanner.nextLine().trim()
    }
}
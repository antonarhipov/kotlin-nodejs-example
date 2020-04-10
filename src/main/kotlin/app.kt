external fun require(module:String):dynamic

fun main() {
    println("Hello JavaScript!")

    val http = require("http")
    val hostname = "127.0.0.1"
    val port = 3000

    println("Server will try to run at http://${hostname}:${port}/")

    val server = http.createServer{req, res ->
        res.statusCode = 200
        res.setHeader("Content-Type", "text/plain")
        res.end("Hello World!!!!\n")
    }

    server.listen(port, hostname, fun() {
        println("Server running at http://${hostname}:${port}/")
    })
}
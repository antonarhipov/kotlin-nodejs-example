//region http type mapping for node.js
@JsModule("http")
@JsNonModule
external object http {
    fun createServer(
            options: dynamic = definedExternally,
            requestListener: (request: IncomingMessage, response: ServerResponse) -> Unit
    ): Server
    class Server {
        fun listen(port: Int, hostname: String, callback: () -> Unit)
    }
    interface IncomingMessage
    interface ServerResponse {
        var statusCode: Int
        fun setHeader(key: String, value: String)
        fun end(s: String)
    }
}
//endregion

fun main() {
    println("Hello JavaScript!")
    val hostname = "127.0.0.1"
    val port = 3000
    println("Server will try to run at http://${hostname}:${port}/")
    val server = http.createServer { req, res ->
        res.statusCode = 200
        res.setHeader("Content-Type", "text/plain")
        res.end("Hello World!!!!\n")
    }
    server.listen(port, hostname) {
        println("Server running at http://${hostname}:${port}/")
    }
}
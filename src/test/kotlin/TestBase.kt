import com.load.more.ConsoleKernel
import com.load.more.addRoutes
import com.load.more.database.factories.ImageFactory
import dev.alpas.auth.Authenticatable
import dev.alpas.make
import dev.alpas.ozone.from
import dev.alpas.pulsar.TestBase
import dev.alpas.routing.Router
import io.restassured.specification.RequestSpecification

@Suppress("unused")
abstract class TestBase : TestBase(ConsoleKernel::class.java) {
    override fun Router.loadRoutes() {
        addRoutes()
    }

    fun <T> asRandomUser(block: (user: Authenticatable) -> T): T {
        val user = from(ImageFactory(app.make()))
        becomeUser(user, true)
        return block(user)
    }

    fun RequestSpecification.asRandomUser() = apply {
        becomeUser(from(ImageFactory(app.make())), true)
    }
}

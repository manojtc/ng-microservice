import com.google.inject.AbstractModule
import java.time.Clock
import services._

class Module extends AbstractModule {
    override def configure() = {
        bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)
        bind(classOf[NGContract]).to(classOf[NGServiceImpl]).asEagerSingleton()
    }
}

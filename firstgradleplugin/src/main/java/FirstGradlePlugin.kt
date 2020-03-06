import org.gradle.api.Plugin
import org.gradle.api.Project

class FirstGradlePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.tasks.create("sayHello") {

            println("Hello World!")

            it.group = "firstgradleplugin"
            it.description = "Say hello to the world"
        }
    }
}
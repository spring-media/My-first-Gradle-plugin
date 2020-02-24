import org.gradle.api.Plugin
import org.gradle.api.Project

class FirstGradlePlugin: Plugin<Project> {

    override fun apply(project: Project) {
        project.afterEvaluate {
            it.allprojects {
                val task = project.tasks.create("SayHello") {
                    println("Hello World!")
                }
                task.group = "firstgradleplugin"
                task.description = "Say hello to the world"
            }
        }
    }
}
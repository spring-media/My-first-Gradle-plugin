import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.File

open class GreetingsTask: DefaultTask() {

    @Input
    var greeting = "Hello world!"

    @Input
    var greetingPath = "/generated/source/firstGradlePlugin/greeting.txt"

    @OutputFile
    var configFile = File(project.buildDir, greetingPath)

    @TaskAction
    fun sayHello() {
        if (configFile.exists()) {
            val path = configFile.parentFile
            configFile.delete()
            path.delete()
        }

        if (configFile.parentFile.mkdirs()) {
            configFile.createNewFile()
            configFile.appendText(greeting)
        }

        println(greeting)
    }
}
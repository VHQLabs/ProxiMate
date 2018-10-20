import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//75054940610-uvbsrkg1dqhc0jo7acd8gc6ofhfl7a39.apps.googleusercontent.com
//Client Secret
//29GWtk9oh86J-OmwXVYg_3PU

class TriviaQuizGeneratorTask extends DefaultTask {

    File appDirectory

    @TaskAction
    void action() {
        println 'tiviaquiz'

        File flavorsDirectory = new File(appDirectory, 'flavors')
        flavorsDirectory.listFiles().each { File f ->
            println f.name
        }




    }




}
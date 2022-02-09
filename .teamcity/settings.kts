import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.githubConnection
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.2"

project {

    buildType(AutomationOfSicFile)

    features {
        githubConnection {
            id = "PROJECT_EXT_7"
            displayName = "GitHub.com"
            clientId = "59130ad5c782d63b6c4d"
            clientSecret = "credentialsJSON:7ca68268-a349-4d05-b41a-fef724493d2d"
        }
    }
}

object AutomationOfSicFile : BuildType({
    name = "AUTOMATION_OF_.SIC_FILE"
    
    steps {
        python {
            name = "Build"
            command = script {
                    content = """print("Hello")"""
            }
        }
    }

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }
})

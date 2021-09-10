import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()
def EMAILS = "arcadiobuelvas@gmail.com"
pipeline{
	agent any
	stages {
		stage('Obtener Fuentes')
		{
		 	steps
		 	{
				checkout([$class: 'GitSCM', branches: [[name: "master"]],
                doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [
                [credentialsId: "ArcadioJenkins", url:"https://github.com/ArcadioGitHub/CI.git"]
                ]])
			}
		}

		stage('Run Tests') {
			steps {
				script {
					try {
						//bat ("gradle clean test -DRunner=\"${Runner}\" aggregate") //Ejecución en agente Windows con parametro jenkins
						/*sh ("gradle clean test -DRunner=\"${Runner}\" aggregate") //Ejecución en agente Linux con parametro jenkins*/
						bat ("gradle clean test aggregate  -Denvironment=dev  -Dcontext=firefox -Dwebdriver.driver=firefox") //Ejecución en agente windows sin parametro jenkins
						echo 'TESTS EXECUTED SUCCESSFULLY'
						currentBuild.result = 'SUCCESS'
					}
					catch(ex) {
	    				echo 'TESTS FAILED'
	    				currentBuild.result ='UNSTABLE'
					}
				}
			}
		}
		stage('GENERATE EVIDENCE') {
			steps {
			    script {
			        bat " rename \"${WORKSPACE}\\target\\site\\serenity\" serenity_${timestamp}"
			    }
			    junit "**/build/test-results/**/*.xml"
			    publishHTML(target:[
			        allowMissing: false,
			        alwaysLinkToLastBuild: true,
			        keepAll: true,
			        reportDir: "${WORKSPACE}/target/site/serenity_${timestamp}",
			        reportFiles: 'index.html',
			        reportName: 'Serenity Report'])
				echo 'HTML REPORT IS DONE'
			}
		}

		stage('NOTIFICATION') {
			steps {
				script {
					if (currentBuild.result == 'UNSTABLE')
         				currentBuild.result = 'FAILURE'

         			if (currentBuild.result == 'SUCCESS')
   						emailext(
							subject: "PROJECT NAME - SUCCESSFUL EXECUTION SCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
          					body: """<p><b style="color:MediumSeaGreen;">EJECUCION EXITOSA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            				<p><b>To check the execution status, go to:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
         					to:"${EMAILS}"
        				)
        			if (currentBuild.result == 'FAILURE')
    					emailext(
          					subject: "PROJECT NAME - FAILED EXECUTION SCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
          					body: """<p><b style="color:red;">EJECUCION FALLIDA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            				<p><b>To check the execution status, go to:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
         					to:"${EMAILS}"
        				)
				}
			}
		}
	}
}
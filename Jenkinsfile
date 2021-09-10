import java.text.SimpleDateFormat

def dateFormat = new SimpleDateFormat("yyyyMMddHHmm")
def date = new Date()
def timestamp = dateFormat.format(date).toString()
def CORREOS = "arcadiobuelvas@gmail.com"
pipeline{
	agent any
	stages {
		stage('Obtener Fuentes')
		{
		 	steps
		 	{
				checkout([$class: 'GitSCM', branches: [[name: "develop"]],
                doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [
                [credentialsId: "ArcadioJenkins", url:"http://10.30.30.248/banbif/pruebas_automatizadas_bxi_empresa.git"]
                ]])
			}
		}

		stage('Ejecutar Pruebas') {
			steps {
				script {
					try {
						//bat ("gradle clean test -DRunner=\"${Runner}\" aggregate") //Ejecución en agente Windows con parametro jenkins
						/*sh ("gradle clean test -DRunner=\"${Runner}\" aggregate") //Ejecución en agente Linux con parametro jenkins*/
						bat ("gradle clean test aggregate") //Ejecución en agente windows sin parametro jenkins
						echo 'Test Ejecutados sin Fallo'
						currentBuild.result = 'SUCCESS'
					}
					catch(ex) {
	    				echo 'Test Ejecutados con Fallo'
	    				currentBuild.result ='UNSTABLE'
					}
				}
			}
		}
		stage('Generar Evidencias') {
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
				echo 'Reporte Html realizado con exito'
			}
		}

	/*	stage('Notificar') {
			steps {
				script {
					if (currentBuild.result == 'UNSTABLE')
         				currentBuild.result = 'FAILURE'

         			if (currentBuild.result == 'SUCCESS')
   						emailext(
							subject: "NOMBREPROYECTO - EJECUCION EXITOSA ESCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
          					body: """<p><b style="color:MediumSeaGreen;">EJECUCION EXITOSA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            				<p><b>Para verificar el estado de la ejecucion ingrese a:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
         					to:"${CORREOS}"
        				)
        			if (currentBuild.result == 'FAILURE')
    					emailext(
          					subject: "NOMBREPROYECTO - EJECUCION FALLIDA ESCENARIOS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
          					body: """<p><b style="color:red;">EJECUCION FALLIDA:</b> Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
            				<p><b>Para verificar el estado de la ejecucion ingrese a:</b> &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
         					to:"${CORREOS}"
        				)
				}
			}
		}*/
	}
}
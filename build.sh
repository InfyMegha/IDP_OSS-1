#!/bin/sh

#Script Behaviour Modifying Parameters (Change after throughly reading documentation)
EXEC_DIR=$PWD
SKIP_TESTS=true
REMOVE_OLDER=true
SKIP_BUILD=false
ANSIBLE_IMAGE=williamyeh/ansible:centos7
MAVEN_BUILD_IMAGE=maven:3.5.4-jdk-8-alpine
ANGULAR_BUILD_IMAGE=alexsuch/angular-cli:6.2
ARCHIVE_MGMT_IMAGE=alexsuch/angular-cli:6.2
ARCHIVE_CREATE_IMAGE=kramos/alpine-zip
WGET_IMAGE=mwendler/wget
LOCAL_M2_CACHE="-v /root/.m2/:/root/.m2/"
#export HTTP_PROXY="http://<username>:<password>@<proxy-ip>"
#export HTTPS_PROXY="http://<username>:<password>@<proxy-ip>"
#WGET_PROXY="-e use_proxy=yes -e http_proxy=http://<username>:<password>@<proxy-ip> -e https_proxy=http://<username>:<password>@<proxy-ip> -e ftp_proxy=http://<username>:<password>@<proxy-ip>"
#PIP_PROXY="--proxy http://<username>:<password>@<proxy-ip>"
#NPM_PROXY="npm config set proxy http://<username>:<password>@<proxy-ip> && npm config set https-proxy http://<username>:<password>@<proxy-ip>"
export HOSTNAME=$(hostname)

#Intializing Environment Parameters
export GRAFANA_HOSTNAME=$HOSTNAME
export GRAFANA_PORT=3000


export ZOOKEEPER_HOSTNAME=zookeeper
export ZOOKEEPER_PORT=2181

export KAFKA_HOSTNAME=kafka
export KAFKA_PORT=9092

export CONFIG_HOSTNAME=config
export CONFIG_PORT=8888
export CONFIG_USERNAME=idpadmin
export CONFIG_PASSWORD=idpadmin@123

export EUREKA_HOSTNAME=eureka
export EUREKA_PORT=8761

export SCHEDULER_HOSTNAME=$HOSTNAME
export SCHEDULER_PORT=8222

export POSTGRES_HOSTNAME=postgres
export POSTGRES_PORT=5432
export POSTGRES_DEFAULT=keycloak
export POSTGRES_USER=postgres
export POSTGRES_PASSWORD=root

export KEYCLOAK_HOSTNAME=$HOSTNAME
export KEYCLOAK_PORT=8989
export KEYCLOAK_USER=admin
export KEYCLOAK_PASSWORD=admin

export JENKINS_HOSTNAME=$HOSTNAME
export JENKINS_PORT=8085
export JENKINS_SLAVE_PORT=50000
export JENKINS_USERNAME=idpadmin
export JENKINS_PASSWORD=650f0ef465ef16b5a8e1bdcbd461973c

export OAUTH_HOSTNAME=$HOSTNAME
export OAUTH_PORT=8181

export DASHBOARD_HOSTNAME=$HOSTNAME
export DASHBOARD_PORT=8184

export IDPAPP_HOSTNAME=$HOSTNAME
export IDPAPP_PORT=8080

export SUBSCRIPTION_HOSTNAME=$HOSTNAME
export SUBSCRIPTION_PORT=8090

export SERVICES_HOSTNAME=$HOSTNAME
export SERVICES_PORT=8889

export PROFILE=paas

#Intializing Data directories
export MOUNT_DIR=$EXEC_DIR/datafiles
mkdir -p $MOUNT_DIR/postgresdata/
mkdir -p $MOUNT_DIR/dsldata/
mkdir -p $MOUNT_DIR/jenkinsdata/


#Checking SSL Preferences
if [ "$SSL_ENABLED" = true ]
then
	export PROTOCOL=https
else
	export PROTOCOL=http
fi


#Remove older stack
if [ "$REMOVE_OLDER" = true ]
then 
	echo "Removing Older IDP Stack"
	docker stack rm IDP
	echo "Waiting for Stack to release resources"
	sleep 20
fi

if [ "$SKIP_BUILD" != true ]
then
	#Setting Test Status
	MAVEN_TESTS=-Dmaven.test.skip=$SKIP_TESTS
	DSL_EXEC=-Dmaven.exec.skip=$SKIP_TESTS
	
	#Cloud Config
	if [ "$SKIP_CLOUD" != true ]
	then
		echo "Compiling Cloud Config ......."
		cd $EXEC_DIR/service/Cloud-Config
		docker run --rm -v $PWD:/Config $LOCAL_M2_CACHE -w=/Config $MAVEN_BUILD_IMAGE  mvn clean install $MAVEN_TESTS
		echo "Building Cloud Config Docker Image"
		docker build -t idp/idpconfig ./
	fi
	
	
	#Eureka
	if [ "$SKIP_EUREKA" != true ]
	then
		echo "Compiling Eurkea ......."
		cd $EXEC_DIR/service/eureka-service
		docker run --rm -v $PWD:/eureka $LOCAL_M2_CACHE -w=/eureka $MAVEN_BUILD_IMAGE mvn clean install $MAVEN_TESTS
		echo "Building Eureka Docker Image"
		docker build -t idp/idpeureka ./
	fi
	
	
	#Services & OAuth
	if [ "$SKIP_SERVICES" != true ]
	then
		echo "Compiling Services & OAuth ......."
		cd $EXEC_DIR/service/Services
		docker run --rm -v $PWD:/Services $LOCAL_M2_CACHE -w=/Services $MAVEN_BUILD_IMAGE mvn clean install $MAVEN_TESTS
		
		echo "Building OAuth Docker Image"
		cd $EXEC_DIR/service/Services/authservice
		docker build -t idp/idpoauth ./
		
		echo "Building Services Docker Image"
		cd $EXEC_DIR/service/Services/restapi
		docker build -t idp/idpservices ./
	fi
	
	#DSL 
	if [ "$SKIP_DSL" != true ]
	then
		echo "Compiling DSL"
		cd $EXEC_DIR/dsl
		docker run --rm -v $PWD:/dsl -v $PWD/../service/Services/entities/target/:/entities -e WGET_PROXY="$WGET_PROXY" -w=/dsl --entrypoint "sh" $WGET_IMAGE libs_download.sh
		docker run --rm -v $PWD:/dsl $LOCAL_M2_CACHE -w=/dsl $MAVEN_BUILD_IMAGE mvn clean package $DSL_EXEC
		docker run --rm -v $PWD:/dsl -v $MOUNT_DIR:$MOUNT_DIR -w=/dsl $ARCHIVE_MGMT_IMAGE unzip -o target/DSL.zip -d $MOUNT_DIR/dsldata/
	fi
	
	#UI
	if [ "$SKIP_UI" != true ]
	then
		echo "Compiling UI ......."
		cd $EXEC_DIR/ui
		docker run --rm -v $PWD:/idpapp -w=/idpapp $ANGULAR_BUILD_IMAGE sh node_build.sh
		docker run --rm -v $PWD:/idpapp $LOCAL_M2_CACHE -w=/idpapp $MAVEN_BUILD_IMAGE mvn clean install $MAVEN_TESTS
		echo "Building UI Docker Image"
		docker build -t idp/idpapp ./
	fi
	
	#Subscription
	if [ "$SKIP_SUBSCRIPTION" != true ]
	then
		echo "Compiling Subscription Module ......."
		cd $EXEC_DIR/subscription
		docker run --rm -v $PWD:/subscription $LOCAL_M2_CACHE -w=/subscription $MAVEN_BUILD_IMAGE mvn clean install $MAVEN_TESTS
		echo "Building Subscription Docker Image"
		docker build -t idp/idpsubscription ./
	fi
	
	#Dashboard
	if [ "$SKIP_DASHBOARD" != true ]
	then
		echo "Compiling Dashboard Module ......."
		cd $EXEC_DIR/dashboard
		docker run --rm -v $PWD:/dashboard $LOCAL_M2_CACHE -w=/dashboard $MAVEN_BUILD_IMAGE mvn clean install $MAVEN_TESTS
		echo "Building Dashboard Docker Image"
		docker build -t idp/idpdashboard ./
	fi
	
	#Scheduler
	if [ "$SKIP_SCHEDULER" != true ]
	then
		echo "Compiling Scheduler Module ......."
		cd $EXEC_DIR/scheduler/SchedulerService
		docker run --rm -v $PWD:/scheduler $LOCAL_M2_CACHE -w=/scheduler $MAVEN_BUILD_IMAGE mvn clean install $MAVEN_TESTS
		echo "Building Scheduler Docker Image"
		docker build -t idp/idpscheduler ./
	fi
	
	
	#Jenkins
	if [ "$SKIP_JENKINS" != true ]
	then
		echo "Building Custom Tools ......."
		cd $EXEC_DIR/jenkins/custom_tools
		docker run --rm -v $PWD/DevopsJsonConv:/custom_tools $LOCAL_M2_CACHE -w=/custom_tools $MAVEN_BUILD_IMAGE mvn clean install $MAVEN_TESTS
		docker run --rm -v $PWD/MetricsProcessor:/custom_tools $LOCAL_M2_CACHE -w=/custom_tools $MAVEN_BUILD_IMAGE mvn clean install $MAVEN_TESTS
		docker run --rm -v $PWD/ReportFetchUtil:/custom_tools $LOCAL_M2_CACHE -w=/custom_tools $MAVEN_BUILD_IMAGE mvn clean install $MAVEN_TESTS
		docker run --rm -v $PWD/SchedulerUtility:/custom_tools $LOCAL_M2_CACHE -w=/custom_tools $MAVEN_BUILD_IMAGE mvn clean install $MAVEN_TESTS
		
		echo "Configuring Jenkins for Startup ......."
		cd $EXEC_DIR/jenkins
		docker run --rm -v $PWD:/jenkins -v $MOUNT_DIR/jenkinsdata/:/jenkinsdata/ -e WGET_PROXY="$WGET_PROXY" -w=/jenkins --entrypoint "sh" $WGET_IMAGE libs_download.sh
		docker run --rm -v $PWD:/jenkins -v $MOUNT_DIR/jenkinsdata/:/jenkinsdata/ -e WGET_PROXY="$WGET_PROXY" -w=/jenkins --entrypoint "sh" $ARCHIVE_CREATE_IMAGE libs_pack_move.sh
		
		echo "Building Jenkins Docker Image"
		docker build -t idp/jenkins ./
	fi
else
	echo "Skipping Build...."
	echo "WARNING: Since build was skipped. The images are supposed to be in place"
fi

#Configuring Tools for Access
if [ "$SKIP_TOOLS_CONFIG" != true ]
then
	cd $MOUNT_DIR
	docker run --rm -v $PWD:/datafiles -v $PWD/grafanadata/:/grafanadata -v $PWD/jenkinsdata/:/jenkinsdata -v $PWD/dsldata/:/dsldata -e PIP_PROXY="$PIP_PROXY" -e HOSTNAME=$HOSTNAME -e PROTOCOL=$PROTOCOL -e JENKINS_PORT=$JENKINS_PORT -e JENKINS_USERNAME=$JENKINS_USERNAME -e JENKINS_PASSWORD=$JENKINS_PASSWORD  -e DASHBOARD_PORT=$DASHBOARD_PORT -e KEYCLOAK_PORT=$KEYCLOAK_PORT -e IDPAPP_PORT=$IDPAPP_PORT  -w=/datafiles $ANSIBLE_IMAGE sh config.sh
fi

#Docker Stack Deployment
echo "Deploying IDP Stack"
cd $EXEC_DIR
chmod -R 0777 $EXEC_DIR/datafiles
docker stack deploy -c $EXEC_DIR/docker_compose.yml IDP
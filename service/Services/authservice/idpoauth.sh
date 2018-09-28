#!/bin/bash
if [ "$SSL_ENABLED" = true ]
then
	export PROTOCOL=https
else
	export PROTOCOL=http
fi
while [ "$status" != true ]
 do
	wget -q -O - ${PROTOCOL}://${CONFIG_HOSTNAME}:${CONFIG_PORT}/idpoauth/paas --user=${CONFIG_USERNAME} --password=${CONFIG_PASSWORD} --no-check-certificate
	if [ $? -ne 0 ]
	  then status="false"
	else status="true"
	fi
  	echo "Waiting for Config Server to start. Sleeping for 5 sec ....."
	sleep 5
done
status="false";
while [ "$status" != true ]
 do
	wget -q -O - ${PROTOCOL}://${KEYCLOAK_HOSTNAME}:${KEYCLOAK_PORT}/auth --no-check-certificate
	if [ $? -ne 0 ]
	  then status="false"
	else status="true"
	fi
  	echo "Waiting for Keycloak Server to start. Sleeping for 5 sec ....."
	sleep 5
done
if [ "$SSL_ENABLED" = true ]
then
	echo "Starting IDP Services in SSL mode"
	if [ -z "$SSL_CA_LOC" ]	
	then
		java -jar -Djava.security.egd=file:/dev/./urandom `dirname $0`/idpoauth.jar
	else
		java -jar -Djavax.net.ssl.trustStore=${SSL_CA_LOC} -Djavax.net.ssl.keyStorePassword=${SSL_CA_PASS} -Djava.security.egd=file:/dev/./urandom `dirname $0`/idpoauth.jar
	fi   
else
	export SSL_ENABLED=false 
	echo "Starting IDP Services in non-secure mode"
	java -jar -Djava.security.egd=file:/dev/./urandom `dirname $0`/idpoauth.jar 
fi
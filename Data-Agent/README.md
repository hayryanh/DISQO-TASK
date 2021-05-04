# Building the Data Agent
Before proceeding, install a [JDK](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) (must be Java 8 or later) and [Apache Maven](https://maven.apache.org/install.html).

Ensure `JAVA_HOME` is set correctly and the `mvn` executable is available on your PATH.

## 1. Project Structure
**cicd**                - directory with configuration properties file for supporting CI/CD deployment
<br/>
**data-agent-bom**      - project's module for supporting maven bom based dependencies
<br/>
**data-agent-common**   - common components and utility implementation
<br/>
**data-agent-services** - services and publisher implementation
<br/>
**data-agent-starter**  - Spring Boot main starter class
<br/>
**etc**                 - Spring configuration files

##2 Build Project
* Before starting build add env. related configuration value for APP_LOGGER_DIR properties
<br/>
* Run Maven Build /> mvn clean package -Pdevelop


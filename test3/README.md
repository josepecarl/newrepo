Para la generación del jar, se realizaría:

mvn clean package

Los jars son creados dentro de la carpeta target.

Para ver los informes del jacaco igualmente se crearán dentro de la carpeta target,
Para la generación de los informes basta con mvn test, ya que he incluido la ejecución
dentro del pom.xml para esa fase tipo test.
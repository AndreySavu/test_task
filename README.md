# Тестовое задание


[Maven 4.0.0](https://maven.apache.org/guides/index.html)\
[Springf Boot 3.2.1](https://spring.io/projects/spring-framework/)\
[H2 database](https://www.h2database.com/html/tutorial.html)\
[Hibernate-core 6.4.2.Final](https://hibernate.org/search/documentation/)

### Функциональные возможности
1. Получение по REST API массивов с интервалами цифр или букв в формате JSON        
   Для POST запроса с цифрами используется http://localhost:8080/api/v1/intervals/merge?kind=digits   
   Для POST запроса с буквами используется http://localhost:8080/api/v1/intervals/merge?kind=letters
2. Последующее объединение пересекающихся интервалов и сохранение массива из непересекающихся интервалов в in-memory SQL базу
   данных H2.
3. Выдача по REST API минимального интервал в формате JSON.

   Для GET запроса с цифрами используется http://localhost:8080/api/v1/intervals/min?kind=digits   
   Для GET запроса с буквами используется http://localhost:8080/api/v1/intervals/min?kind=letters

### Инструкция по сборке приложения
* При помощи IntelliJ IDEA: перейти в src\main\java\com.common.test_task\TestTaskApplication и нажать ▶
* При помощи Maven в консоли:
  
   1. Перейти в директорию, где был скачан проект️
   2. Ввести команду для сборки: mvn compile
   3. Ввести команду для запуска скомпилированной программы:
  
        mvn exec:java -Dexec.mainClass="com.common.test_task.TestTaskApplication"

### Настройка и конфигурирование
* Инструкция для сборки - pom.xml
* Свойстра проекта - src\main\resources\application.properties


### Развёртывание
Произвести развертывание(deploy) приложение можно при помощи команды: mvn deploy

Требуется указать ip:port pom.xml -> distributionManagement -> repository

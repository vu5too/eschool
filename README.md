# eschool 

1.1 Чтобы скачать проект запускаем команду в терминале: 

    git clone https://github.com/vu5too/eschool.git

1.2 Прежде чем запустить приложение необходимо внести изменения в файлы для установки соединиеня с базой данных PostgreSQL: 
    
    eschool/src/main/resources/db-mybatis.properties
    eschool/src/main/resources/application.properties
    
    Переменным url, password, username присваиваем значения для соединения с базой данных.
    
2.1 В корне каталога eschool/ 

    для запуска тестов вводим в терминале команду "./mvnw test" - linux или "mvnw.cmd test" - windows
    для запуска приложения вводим в терминале команду "./mvnw spring-boot:run" или "mvnw.cmd spring-boot:run"
    
    Предполагается, что в системе уже установлена JDK и настроена переменная JAVA_HOME для запуска maven
    
3.1 После запуска сервера в браузере по адресу "http://localhost:8081" появится страница авторизации. Логин - admin, Пароль - admin. 

3.2 После авторизации появится страница со списком стдентов и двумя кнопками "Delete" для удаления студента из базы, "Add Student" для добавления пользователя в базу.

3.3 По нажатию на кнопку "Add Student" откроется форма для добавления студента в базу с копками "Save changes" и "Close".

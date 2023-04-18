# charity-organization
Структура базы данных:
 
![изображение](https://user-images.githubusercontent.com/102044344/232735152-6d579468-a24b-462f-b17c-94ac1d1683ac.png)

В приложении реализовано 4 сущности:
1.	Project
2.	Donation
3.	Sponsor
4.	DonationDistributionRecord

В приложении реализовано 4 сущности:
1.	Project
2.	Donation
3.	Sponsor
4.	DonationDistributionRecord

Для взаимодействия реализованы 2 контроллера:
1.	ProjectController (/projects/). Имеет 6 методов-действий:
1.1.	getAllProjects – (GET) получить список всех проектов
1.2.	getProjectById – (GET) получить проект по ID
1.3.	createProject – (POST) создать проект, необходимо передать в теле запроса необходимо передать название, начальный бюджет и коэффициент вовлеченности (от 1 до 5)
1.4.	 deactivateProject – (GET) приостановить внесение в проект пожертвований
1.5.	activateProject – (GET) возобновить внесение в проект пожертвований
2.	DonationController
2.1.	findAllDonations – (GET) получить список всех пожертвований
2.2.	getDonationById – (GET) получить пожертвование по ID
2.3.	createDonation – (POST) создать пожертвование, нужно передать сумму пожертвования и название(имя) спонсора

После создания пожертвования, оно распределяется по существующим активным проектам согласно их коэффициенту вовлеченности. Это реализовано в сервис классе DonationDistributionEngine, который получает из базы данных сумму коэффициентов вовлеченности всех проектов. Потом добавляет в бюджет каждого активного проекта пропорционально его коэффициенту вовлеченности сумму из пожертвования. 
Для работы с базой данных созданы сервис классы DonationService, ProjectService, SponsorService и интерфейсы репозитория для каждой сущности.
Для валидации входящих данных POST запросов используются ProjectDTO и DonationDTO классы. Для маппинга данных созданы сервисные классы ProjectMapper и DonationMapper.

Использованный стек технологий:
<b>Spring Boot 3.0.5</b>
<br>
<b>Java 17</b>
<br>
<b>Gradle</b>
<br>
<b>PostgreSQL</b>
<br>
<b>Liquibase</b> – для внесения дальнейших изменений в базу данных.
<br>
<b>Docker</b> – в корне репозитория находится docker-compose файл для разворачивания контейнера с базой данных и сервиса взаимодействия с базой.
<br>
<b>Swagger UI</b> доступен по пути /swagger-doc/swagger-ui/index.html
<br>
<b>Lombok</b> для сокращения кода
<br>
<b>Junit5</b> и <b>Mockito</b> для тестов
<br>

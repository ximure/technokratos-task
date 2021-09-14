<h2>Тестовое задание для Технократии</h2>

initSql.sql в корне - __скрипт инициализации БД__  
/src/main/resources/application.properties - __параметры подключения к базе данных__

<h5>GET запросы:  </h5>

__/api/products__ - список всех продуктов  
__/api/orders__ - список всех заказов  
__/api/orders/find/email?email=почта__ - найти заказы, где есть выбранная почта  
__/api/orders/find/article?article=артикул__ - найти заказы, где есть выбранный артикул  
__/api/orders/find/date?from=дата1&to=дата2__ - найти заказы между двумя датами, где __дата1/2__ в формате: __"yyyy-MM-dd"__

<h5>POST запрос:  </h5>

__/api/orders/new__


<h2>Скриншот запросов</h2>
<div display="grid">
  <img width="80%" height="auto" src="/img/requests.png"/>
</div>

<!DOCTYPE html>
<html>
<head>
    <title>CyberKirych</title>
</head>
<body>
<h1>CyberKirych</h1><hr>
<h4>Информация о товаре</h4>
<#if images?? && images?size gt 0>
    <#list images as img>
        <img src="/images/${img.id}" height="360px"/><br><br>
    </#list>
<#else>
    <p>Нет изображений</p>
</#if>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена: </b>${product.price}<br>
<b>Город: </b>${product.city}<br>
<b>Автор: </b>${product.author}<br>
<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>
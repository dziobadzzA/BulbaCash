<h1 align="center">BulbaCash</h1>

<p align="center">

  <a href="https://android-arsenal.com/api?level=21">
    <img alt="API" src="/previews/1.svg"/>
  </a>

  <a href="https://github.com/dziobadzzA/BulbaCash/commits/">
    <img alt="Build Status" src="/previews/badge.svg"/>
  </a> 

  <a href="https://github.com/dziobadzzA">
    <img alt="Profile" src="/previews/account.svg"/>  
  </a> 

</p>

<p align="center">  
  BulbaCash — это демонстрационное приложение, основанное на современных технологических стеках приложений Android и архитектуре MVVM.
  Извлечение данных из сети и интеграция сохраненных данных в базу данных с помощью шаблона репозитория. Предназначен для получения
  информации о корзинах валют от НБ РБ и хранении ежемесячных расходов человеком (мини-кошелек)
</p>

<br>


## Tech stack & Open-source libraries
- Минимальный уровень SDK 21
- [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) для асинхронности.
- JetPack
    - Flow - уведомляет данные для View.
    - Lifecycle - удаление наблюдаемых данных при изменении состояния жизненного цикла.
    - ViewModel - держатель данных, связанных с пользовательским интерфейсом, с учетом жизненного цикла.
    - Realm - создание базы данных с использованием абстрактного слоя.
- Architecture
    - MVVM Architecture (View - DataBinding - ViewModel - Model)
    - [Hilt] - dependency injection.
    - [Retrofit2 & Gson](https://github.com/square/retrofit) - создание REST API.

## Architecture
BulbaCash основан на архитектуре MVVM и шаблоне репозитория.
![architecture](https://user-images.githubusercontent.com/24237865/77502018-f7d36000-6e9c-11ea-92b0-1097240c8689.png)



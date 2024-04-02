
#MEME APP


This project is your guide to building better Android apps! It teaches you two important things:

__Using Retrofit:__ 
Learn how to make the API calls in your application by using the RETROFIT library.

__Navigations in Compose:__ 
Learn how to navigate between the screen and the arguments between them.


By exploring this code, you'll:

_Boost your application by using API_:   Make api calls and how to use the @GET annotation  
Improve user experience: Make it easy for users to navigate your app.
Get started and learn how to build awesome apps!_

# Demo

https://github.com/Kota-Kun22/Meme_App/assets/68362699/e3593607-f8f0-4ef4-94de-cda22210ad1d

# Tech Stack

1. **Language:** Kotlin

2. **Design :** JetPackCompose


4. **Dependencies ::**


__a.__ Dependency for   Retrofit library :

`implementation ("com.squareup.retrofit2:retrofit:2.9.0")` 
`implementation ("com.squareup.retrofit2:converter-gson:2.9.0")`

__b.__ Dependency for  coil library:

` implementation ("io.coil-kt:coil-compose:2.2.2")`
`implementation ("com.google.accompanist:accompanist-coil:0.10.0")`

__c.__ Dependency for Navigation :

` implementation("androidx.navigation:navigation-compose:2.7.3")`


5. **Plugins ::**

**.**  `id("com.android.application")`

**.** `id("org.jetbrains.kotlin.android")`





#  Lessons Learned


What did I learn while building this project? What challenges did I face ?

### *_Composing UI with Jetpack Compose:_*
The code utilizes Jetpack Compose for building the UI. This is a modern and declarative way to create user interfaces in Android.


### *_Data Fetching with Retrofit:_*
Retrofit is used for making API calls to retrieve a list of memes. This demonstrates how to handle network requests and responses.

### *_Navigation with Compose Navigation: _*
The code implements navigation between different screens using Compose Navigation. This allows for a smooth user experience when transitioning between views.

### *_Asynchronous Image Loading with AsyncImage:_*
AsyncImage is used to load images asynchronously, improving performance and preventing the UI from freezing.

### *_State Management with remember/mutableStateOf:_*
The code utilizes remember and mutableStateOf to manage the state of UI elements like the search text and meme list.








## Silly Mistakes and Best Practise


### Error 1: Potential Issue with Search Functionality

**_Problem:_** 
The search filtering might not work efficiently.

**_Reason:_**
Filtering the memeList within the LazyVerticalStaggeredGrid composable's items lambda can lead to unnecessary filtering on every recomposition.

**_Best Practice:_** 
Filter the memeList before passing it to the LazyVerticalStaggeredGrid composable. This improves performance as filtering happens only once.


### Error 2: Direct UI Update on Background Thread

**_Problem:_** Updating memeList directly inside the coroutine launched on Dispatchers.IO might cause issues.

**_Reason:_** UI elements should be updated on the main thread to avoid exceptions.

**_Best Practice:_** Use withContext(Dispatchers.Main) within the coroutine to safely update memeList after successful API call and data processing.


### Best Practice 1: Consider Using ViewModel

**_Recommendation:_** 
Use ViewModel to manage UI state like the list of memes and search text. This ensures data survival across configuration changes and improves maintainability.

**_Benefit:_** ViewModel provides a centralized location for handling UI data and simplifies data sharing between composables.

### Best Practice 2: Implement Robust Error Handling

**_Current Approach_**:The code handles IOException and HttpException but could be improved.

**_Recommendation:_** Consider catching specific exceptions related to the API call or a general Throwable for broader error handling. Additionally, provide more informative error messages to the user.

**_Benefit:_** Robust error handling prevents unexpected crashes and provides better user experience.
### Best Practice 3: Content Description for AsyncImage

**_Current Approach:_** itemName is used as content description for AsyncImage.

**_Recommendation:_** Provide a more specific content description related to the actual image content. This improves accessibility for users with screen readers.

**_Benefit:_** Descriptive content descriptions enhance accessibility for users who rely on screen readers.

# Pull Requests

**..** Fork the repository and create a new branch for your feature or bug fix:

**..** git checkout -b  feature-name Make your changes and commit them :

**..** git commit -m  "Description of changes" Push your changes to your fork :

**..** git push origin feature-name Open a pull request to the main branch of the original repository.



## *Explore the symphony of Android development!*

Join the journey - 
craft beautiful, 
innovative apps, unlock new skills, and push the boundaries of what's possible!  No matter your level, this project is your playground.  ***Let's build something amazing together!*** ✨

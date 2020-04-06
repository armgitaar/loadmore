### Load More / Show More example using Alpas, Kotlin, and JS/Ajax

This is an example app of using [Alpas kotlin-based web framework](https://alpas.dev) and JS/Ajax to load more images on click of a **show more** button without refreshing the page. Has there ever been a bigger improvement to user experience than Ajax? Seriously, such a delight. 

In this example, you will need to do a little bit of setup to get the 'show more' functionality up and running. The example loads images and titles from [Unsplash](https://unsplash.com). 

### Instructions
After you clone the project, -  
1. Setup a MySQL database on your local named "showmore"
2. In showmore root directory, run the following command: `./alpas db:migrate && ./alpas db:seed`
3. Run the project and go to your local host

Voila! 

The guts of the functionality are in the WelcomeController.kt, welcome.peb, and route.kt files. 

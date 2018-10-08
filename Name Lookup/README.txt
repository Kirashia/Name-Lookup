Here are some notes about the projects this week (written Monday 8th October 2018):

---Simple name lookup by ID---
This was alright, no problems here

---Related people---
Although I don't doubt that this *could* be simple, my program would only return the login page, 
since the page where related people are found is on the secure intranet, requiring a personal
login. I couldn't work out how to bypass this as of writing

---Home page---
Returning the first <a> in an HTML file. Easy? I thought so...
Firstly, google doesn't like programs accessing their pages without a proper agent identifying them,
so you have to modify your code (see https://stackoverflow.com/questions/13670692/403-forbidden-with-java-but-not-web-browser)
so that it actually returns some semblance of HTML. Initially I found this rather difficult, since the page
I was using as a base was a more complex one. I modified the program to work with the name found in the ID section, which
makes the page much simpler.

---Anagrams---
Actually alright. The few problems I encountered were easy enough to fix on my own

---Translate---
This *looked* simple. The page is nicely structured so a <span> object with ID "result_box"
holds the translated text. Unfortunately, when retrieving the webpage via a buffered reader, 
the translated text is nowhere to be found (not in whole page, .indexOf([translation]) literally 
returns -1 --> not in the text). This leads me to assume the translation happens client side? 
Either way there doesn't seem like a way to get it back.

---Twitter---
As I of writing I have not attempted to access Twitter's API, although using codecademy or something
I might be able to pull it off...

Jon James
08/10/2018


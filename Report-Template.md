# The God We Trust



[![img](https://github.com/MMDPROJECT/PacmanProject/raw/main/Images/SBU.png)](https://github.com/MMDPROJECT/PacmanProject/blob/main/Images/SBU.png)

# cinema information project



## hamed pouraghniaei



## Introduction:

#### Briefly describe the project:

- this is the second practice of advance programming course in shahid beheshti university.
  in this project we have to learn the concept of json and op in this course .

#### Objectives of the project:

- The app should provide many information about acters and celebrities
- It has give many information about movies .
- The app should provide a beautiful and user-friendly interface for user to interact with the program.

#### Provide a high-level overview of the approach taken to complete the project:

1. Figure out an algorithm to generate the a URL.
2. Design structs.
3. request information with AOI.
4. get information from API
5. change information and show them to users 

## Getting Started

### Dependencies

* java 
* ex. Windows 11
* gradle 8.6
* oracle 21
* IDLE(for example Intellij idea)

### Installing

* you can install our program with clone this project from this page  
* for using this program you have to keep the java classes in one folder

### Executing program

* **json parsing**
  when I send request to API with some name , that give me a json that including information of that name  and we shoud pars it to give the data we want 
* first we shoud convert that string we get from API to json object so that we can use and pars infomation :
```
        JSONObject jsonObject =  new JSONObject(actorsInfoJson) ;
```

* for get a special inform from that json we shoud use this command

```
boolean statues = false;
statues = jsonObject.getBoolean("is_alive");
```

* and i want to provide a code that get you all information of json  

```
try {
    json = movie.getMovieData(title);

    ObjectMapper objectMapper = new ObjectMapper();
    try {
        JsonNode rootNode = objectMapper.readTree(json);

        Iterator<String> fieldNames = rootNode.fieldNames();
        while (fieldNames.hasNext()) {
            String key = fieldNames.next();
            JsonNode node = rootNode.get(key);
            System.out.print(key + " : ");
            System.out.println(node.toString());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
} catch (IOException e) {
    e.printStackTrace();
    // Handle the IOException as needed
}
```

## bonus that I do

* Error handling 
* get all information and make a good menu
* good menu 

## Help

Any advise for common problems or issues.
```
command to run if program contains helper info
```

## Authors

Contributors names and contact info

Hamed Pouraghniaei

Mobina Kargar

Rand Rokni

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [PurpleBooth](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
* [dbader](https://github.com/dbader/readme-template)
* [zenorocha](https://gist.github.com/zenorocha/4526327)
* [fvcproductions](https://gist.github.com/fvcproductions/1bfc2d4aecb01a834b46)
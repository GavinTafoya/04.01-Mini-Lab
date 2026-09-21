# 04.01 Mini-Lab Warmup
### Description
This warmup demonstrates API usage through the Canvas API to show all user courses and assignments related to them. It displays all unlocked courses on the home page and the user can sort by term to find the courses for their current term. Underneath the courses it lists all upcoming assignments, as well as the points they can be worth and their due dates. When clicked, the assignments pull up their own card which displays all the assignment's necessary information and adds the assignment's description.

### Use
To use the app, the user must clone the repo first and have maven installed locally. Once that is done they can open teminal and inside of the directory, they can run ``mvn clean compile`` and when the build is successful, they can run ``mvn spring-boot:run`` to start the application. It should automaticlaly install the dependencies needed through the clean compile and then accessing the app should be as simple as going to http://localhost:8080

### API Usage
| Endpoint | Usage |
| -------- | -------- |
| /users/self/courses?enrollment_state=active&include[]=term | Used to get all curennt courses connected to the user. Can be filterd by the selected term |
| /courses/{id}/assignments | Gets all the assignments in a course, based on the given id |


### Reflection
I have worked with the Spring framework in the past, so working in it now was not very difficult. I understood everything for the setup, the hard part was actually working with the API. The canvass API does not seem to be uniform in what it returns, as some of the classes would return some things like no assignments, no dates for the class or even one was just labled as "done. This was really weird and I had to work with AI to figure out what I was even looking at.

Other than the weird data propigation, I learned a lot about Thymeleaf functions. Thymeleaf works very similarly to Angular where there are special attributes that you can use to make your pages more dynamic. An example of one was ``th:block`` with ``th:each`` which had the effect of creating loop logic for assignments. It was a pretty basic thing to set up, and my major thing was just not understanding data inconsitencies, but it was fun overall.
# user-analyze-system
## system feature
 + implemented basic user account management features include: add/delete/update/search user information
 + visualize users' behavior information,include:
    + visualize users' Browser preference, admin can know how many users use IE/Firefox/Chrome
    + visualize users' Operating System preference, admin can know how many users use Linux/MacOS/Windows
    + visualize users' gender/occupation/age distribution, 
    + visualize users' Login pattern as line chart, admin can know the peak hour of login
    + visualize users' current geographic location,display it in a 3D map
  + Wrote a remote login detection subsystem. alerted administrator when user's IP address changed frequently. 
  
 ## technical detail
 + Built front-end with Bootstrap,jQuery
 + Built back-end using JSP/Servlet; 
 + Parsed TCP package and tracked user’s behavior information including login pattern, IP address, types of operating system and browser

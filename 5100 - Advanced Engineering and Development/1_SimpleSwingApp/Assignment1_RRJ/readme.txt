Assignment: 1
NUID: 001052650
Name: Rashmi Rajendra Joshi

Details: 
The program has a UI that allows user to define the attributes of their favorite car and then view them with the help of the view button. 
The 'Define' button opens a page on the right hand side of the screen with 16 attributes for the user to enter. 
15 of the attributes can be entered in the text boxes provided. 
16th attribute is the image of the car that can be uploaded with the help of the jFileChooser. 
User is prompted if a file is uploaded OR if no file is chosen after an attempt to choose the file.
User is not however stopped if no image is chosen OR if user selects a non image file.

The Define screen sets the values entered along with the file path of the image uploaded onto a car object. 

Once the user selects 'View', the data is retrieved from the car object and then assigned to the respective text fields on the view screen. 
The text fields in View are not editable as there is no action for the user to perform on the view screen. 
The car image is fetched from the location it was uploaded from, and resized to a scale to fit into the program window and then displayed. 
The logic used to find a image, fetch it and display it is done with the help of jFileChooser, ImageIcon, Image and jLabel. 
Some of the other components used for the overall application are jFrame, jPanel, Text field, button and Dialog boxes. 

To run the application: 
Run the application using NetBeans 8.2. 
Alternatively, the executable of the application is provided in "Assignment1_RRJ\dist"

A default image is provided for sample purposes, any image on the machine can be used as long as the path of the image remains same throughout the run of the program. 
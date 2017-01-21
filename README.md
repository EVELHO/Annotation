# Annotation

## 3 - Automation 

#### ***PLEASE FIND GUIDE.DOCX it has images embebed*** ##

### Steps to Run
1 - Go to http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html  and download java jdk accordingly with you system.

2 - Go to http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/marsr and download eclipse, accordingly with you system, from the right side "Download Links" section.

3 - Install Java JDK with the default options

4 – Add installation folder in the Path under "Environment Variables" -> "Systems Variables":
_C:\Program Files (x86)\Java\jre1.8.0\_91\bin_

5 - Unzip Eclipse to a chosen folder

6 - Open eclipse.exe and chose a workspace destination folder

7- Click on the Workbench icon

8 –  Go to File -> Import -> Git -> Projects from Git and click the "Next" button

9 – Select "Clone URI" and click the "Next" Button


10 – Set URI = [https://github.com/EVELHO/Annotation.git](https://github.com/EVELHO/Annotation.git) and hit the "Next" button:

11 – Select "Master Branch" and hit the "Next" Button
 
12 – Select the Directory Destination and hit "Next" button

13 – Select the "Import existing Eclipse projects" option and hit "Next"

14 – Click on the "Finish" button

15 - Right Click on the "Project" -> "Build Path" -> "Configure Build Path"

16 – Remove all the missing JARs that are missing (red x icon) – select with shift+click. Click on the "Apply" button.

17 – Click on Add external JARs,  go to the folder where you cloned the git repo (ex. **C:\Users\User\git\Annotation)** and browse _C:\Users\User\git\Annotation \bin\libs\libs_ <br />
Add all jars – ctrl + shift is a valid option.
 
18 – Click again on "Add External Jars", navigate to "C:\Users\User\git\Annotation\bin\libs" and add the selenium jars.

19 - Click on "Apply" and then OK. Now we are able to run the tests.
_Go to Window -> Show View -> Other and then, in the new window Java -> JUnit. Press OK button._

20 – Check if you have installed Firefox version 40.0.2 – otherwise uninstall current version and Download Firefox 40.0.2 [http://filehippo.com/download\_firefox/62757/](http://filehippo.com/download_firefox/62757/)

21 – Now you are ready to run the automated tests. 

**If you want you can create some Unit tests on the application, it's somewhat simple:**

        @Test

        public void testA() {
                try {

                        login();
                        selectBatch(5);
                        createAnnotation(4);
                        selectError("False Friend");
                        selectSeverity(1);
                        finalizeAnnotation("add";);
                        assertFalse(QT21_.equals(find("xpath";"/html/body/div/div[1]/div/div[1]/li[2]").getText()));
                }
                catch (Exception e){
                        e.printStackTrace();
                }

 - *Login()* – performs the login, as only one account is available I set the values directly as class variables.

 - *selectBatch(int batchNumber)* – Navigate to the a batch indicated by the number.

 - *createAnnotation(int translationTaskPosition)* – Create an annotation of half of the text on the task.

 - *selectError(String error)* – this method has as input the error type to be set.

 - *finalizeAnnotation(String Action)* – Adds (Add) or clears (Exit) the current annotation

 - *assertFalse(QT21.equals(find("xpath"; "/html/body/div/div[1]/div/div[1]/li[2]").getText()));* - On here I was just checking if the QT21 changed when creating the annotations. Just checks if they are different after the new Annotation.

**PS. Do not forget of the @Test notation right above the method****.**




### Security
Concerning Security, the first thing that draws attention is lack of an encrypted channel between server and client, which makes application vulnerable to attacks.
Any security tests are only worth doing after fixing this vulnerability as even credentials are sent in plain text.

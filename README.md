# Annotation

## 3 - Automation 

### Steps to Run
1 - Go to http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html  and download java jdk accordingly with you system.

 
2 - Go to http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/marsr and download eclipse, accordingly with you system, from the right side &quot;Download Links&quot; section.


3 - Install Java JDK with the default options


4 – Add installation folder in the Path under &quot;Environment Variables&quot;  &quot;Systems Variables&quot;:

C:\Program Files (x86)\Java\jre1.8.0\_91\bin


4 - Unzip Eclipse to a chosen folder

5 - Open eclipse.exe and chose a workspace destination folder


6- Click on the Workbench icon

7 –  Go to File Import  Git  Projects from Git and click the &quot;Next&quot; button


8 – Select &quot;Clone URI&quot; and click the &quot;Next&quot; Button


9 – Set URI = [https://github.com/EVELHO/Annotation.git](https://github.com/EVELHO/Annotation.git) and hit the &quot;Next&quot; button:

10 – Select &quot;Master Branch&quot; and hit the &quot;Next&quot; Button

 
11 – Select the Directory Destination and hit &quot;Next&quot; button


12 – Select the &quot;Import existing Eclipse projects&quot; option and hit &quot;Next&quot;


13 – Click on the &quot;Finish&quot; button


14 - Right Click on the &quot;Project&quot;  &quot;Build Path&quot;  &quot;Configure Build Path&quot;

 
15 – Remove all the missing JARs that are missing (red x icon) – select with shift+click. Click on the &quot;Apply&quot; button.


16 – Click on Add external JARs  go to the folder where you cloned the git repo (ex. **C:\Users\User\git\Annotation)** and browse C:\Users\User\git\Annotation \bin\libs\libs.

Add all jars – ctrl + shift is a valid option.

 
20 – Click again on &quot;Add External Jars&quot;, navigate to &quot;C:\Users\User\git\Annotation\bin\libs&quot; and add the selenium jars.


21 Click on &quot;Apply&quot; and then OK. Now we are able to run the tests.

Go to Window  Show View  Other and then, in the new window Java  JUnit. Press OK button.


22 – Check if you have installed Firefox version 40.0.2 – otherwise uninstall current version and Download Firefox 40.0.2 [http://filehippo.com/download\_firefox/62757/](http://filehippo.com/download_firefox/62757/)











23 – Now you are ready to run the automated tests. If you want you can create some Unit tests on the application, it&#39;s somewhat simple:

        @Test

        **public**** void** testA() {

                // **TODO** Auto-generated method stub

                **try** {

                        _login_();

                        _selectBatch_(5);

                        _createAnnotation_(4);

                        _selectError_(&quot;False Friend&quot;);

                        _selectSeverity_(1);

                        _finalizeAnnotation_(&quot;add&quot;);

                        _assertFalse_(_QT21_.equals(_find_(&quot;xpath&quot;, &quot;/html/body/div/div[1]/div/div[1]/li[2]&quot;).getText()));

                }

                **catch** (Exception e){

                        e.printStackTrace();

                }

Login() – performs the login, as only one account is available I set the values directly as class variables.

selectBatch(int batchNumber) – Navigate to the a batch indicated by the number.

_createAnnotation_(int translationTaskPosition) – Create an annotation of half of the text on the task.

_selectError_(&quot;String error&quot;) – this method has as input the error type to be set.

_finalizeAnnotation_(&quot;String Action&quot;) – Adds (Add) or clears (Exit) the current annotation

_assertFalse_(_QT21_.equals(_find_(&quot;xpath&quot;, &quot;/html/body/div/div[1]/div/div[1]/li[2]&quot;).getText())); - On here I was just checking if the QT21 changed when creating the annotations. Just checks if they are different after the new Annotation.

**PS. Do not forget of the @Test notation right above the method****.**




### Security
Concerning Security, the first thing that draws attention is lack of an encrypted channel between server and client, which makes application vulnerable to attacks.
Any security tests are only worth doing after fixing this vulnerability as even credentials are sent in plain text.

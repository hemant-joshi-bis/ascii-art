<h1>Welcome to Hemant's Ascii Art drawing package</h1>
<br/>
<br/>

<strong>
Java 11
Gradle 6.0.1
Intellij as an IDE Latest community version
</strong>
<br/>
<strong>
1. Clone it from the git repository or unzip the file.
2. gradle clean build
3 java -jar build/libs/asciiart-0.1.jar
</strong>
<br/>

<strong>Assumptions</strong>
<br/>
<ol>
<li>Line drawing is simple, points are calculated as per expected exercise output.</li>
<li>Any Line or Rectangle with outside the Canvas limits are not added for rendering.</li>
</ol>

<strong>
TODO
<br/>
<ol>
<li>Power mock needs to be for mocking input as final classes are prohibited for spy by mockito.</li>
<li>Pixel validation can be extended by testing pixel array.</li>
<li>Can add Spring Boot but avoided to focus on core programming.</li>
<li>Pixel Array validation can be added by pre-built and then comparing</li>
<li>Automate testing process</li>
</ol>

<h1>Test Results</h1>
<br/>
<strong>Please check results.txt for manual test</strong>

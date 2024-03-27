# QaAutomation

Qa repo with all code project samples from Workshop November 2023

# _Selenium Java set up_

You will need Java and Maven installed
Instal chrome driver that matches your version of chrome
https://chromedriver.chromium.org/downloads
https://googlechromelabs.github.io/chrome-for-testing/#stable -- for new and latest driver support for Chrome 118
Steps to install and set Java and selenium
https://www.guru99.com/installing-selenium-webdriver.html#1

Terminal command to Install and run tests
mvn install
![image](https://github.com/endaVersion1/QaAutomation/assets/122106008/f8baf99b-4018-4e53-b70e-013d32d09eea)

![image](https://github.com/endaVersion1/QaAutomation/assets/122106008/97c9077e-86a1-4d52-a6bf-c21e83205e45)

mvn test -- to just run the tests

# Selenium C#

You will need .Net
https://dotnet.microsoft.com/en-us/download
terminal command to run tests
dotnet run (as it is in the main)
Note If you need to install plugin support for your IDE
If using VsCode install
https://marketplace.visualstudio.com/items?itemName=RajUppadhyay.specflow-steps-definition-generator
https://marketplace.visualstudio.com/items?itemName=alexkrechik.cucumberautocomplete

**To Run tests**
dotnet build
![image](https://github.com/endaVersion1/QaAutomation/assets/122106008/a23c2b8e-e847-4ddc-bc4b-bab8a1cd029d)

dotnet run (Tests are in the main class)

dotnet test or use the Extion on VS code

# Playwright

you need npm and node installed
An IDE that supports Type script TypeScript plugin

**Install all packages**
npm install
![image](https://github.com/endaVersion1/QaAutomation/assets/122106008/f3fcc941-df24-42b4-a43c-52b89e87dd1a)

npx playwright install to install web drivers and any packages

** To run tests**
npm run test
![image](https://github.com/endaVersion1/QaAutomation/assets/122106008/dc351527-002a-4e13-82da-bd284a037560)

# Cypress

you need npm and node installed
npm install
![image](https://github.com/endaVersion1/QaAutomation/assets/122106008/e6cb564f-54ab-473d-86a3-5f4ecfee3218)

npx cypress open --first time
npm install cypress --save-dev

To run tests ( Be in the blazingChat Folder)
npx cypress open --Open the Cypress container
Select E2E testing
Browser Electron
![image](https://github.com/endaVersion1/QaAutomation/assets/122106008/c275944f-7783-4c09-a6ff-c37f4c5dc1d7)

![image](https://github.com/endaVersion1/QaAutomation/assets/122106008/abaeb06a-bcfd-44e1-bfcf-1df7b1046af4)

**Testing Frameworks tools Important Docs**

https://playwright.dev/docs/test-assertions

https://docs.cypress.io/api/table-of-contents

https://www.selenium.dev/documentation/webdriver/elements/locators/

**Vs Code Usful Exteions**
.Net Core Test Explorer
.NET Extention Pack
c#
C# DEV KIT
Debugger for Java
Maven for Java
Nuit Test Runner
Playwright Test For Vs Code
Playwright Test Runner

![image](https://github.com/endaVersion1/QaAutomation/assets/122106008/7a56f752-ef12-443e-ba08-f135a93c5a5d)

![image](https://github.com/endaVersion1/QaAutomation/assets/122106008/05ca3e6f-bf27-40f2-b6bd-2acb62a7a616)

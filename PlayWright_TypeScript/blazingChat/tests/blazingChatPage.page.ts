import { expect, Locator, Page } from '@playwright/test';

export class BlazingChatPage{
    readonly page : Page;
    readonly loginButton: Locator;
    readonly uploadFile: Locator;
    readonly contacts: Locator;


    constructor(page: Page){
        this.page = page;
        this.loginButton = page.getByRole('button', { name: 'Login' });
        this.uploadFile =  page.locator('input[type="file"]');
        this.contacts = page.locator("//a[normalize-space()='Contacts']");
    }

    async uploadPicture(file) {
        await this.uploadFile.setInputFiles(file);
      }

   async verifyAlertMessage(){
    // Use page.$$ to select all elements with the given class
    const alertElements = await this.page.$$('.alert.alert-primary');

    // Iterate through the selected elements and get their text
    for (const element of alertElements) {
        const text = await element.innerText();
        expect(text[0]).toContain('I');
    }

   }

    //---Code Challenge Check Create account validation--
    //Method to test Validation of Create Account
    async verifyCreateAccountValidation(){
        
    }
};
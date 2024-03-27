import { test, expect } from '@playwright/test';
import { BlazingChatPage } from './blazingChatPage.page';

test.describe( 'Open blazing Chat', ()=> {

    test(`Open page and Wait`, async ({ page }) => {
      const blazingChatPage = new BlazingChatPage(page);
      const profilePicture = '../../qa_cat.jpg'

      await page.goto('https://localhost:44323/');
      await blazingChatPage.loginButton.click();
      await expect(page).toHaveURL('https://localhost:44323/profile');
      await blazingChatPage.uploadPicture(profilePicture);
      await blazingChatPage.verifyAlertMessage();
    });

    test(`Failing test Assert name that is not in Contacts`, async ({ page }) => {
      const blazingChatPage = new BlazingChatPage(page);
      await page.goto('https://localhost:44323/');
      await blazingChatPage.loginButton.click();
      await expect(page).toHaveURL('https://localhost:44323/profile');
      await blazingChatPage.contacts.click();
      expect(page.locator('href="chat1"').innerText()).toBe('Tom jones');
    });

    //---Code Challenge Check Create account validation--
    test(`Create Account`, async ({ page }) => {

    });

    //---Code Challenge Check Create account validation--
    test(`Create Account Validation`, async ({ page }) => {

    });

});

import { test, expect } from '@playwright/test';
import { BlazingChatPage } from './blazingChatPage.page';
import * as data from '../../blazingChat/tests/data/contacts.json';

// Our Mocked API data
const mock = data[0]; // Access the first element of the array

test.describe('Open Blazing Chat', () => {
    test('Table of Attendees Mocked', async ({ page }) => {
        //Need to declare your route as soon as the call is made
        await page.route('http://localhost:4200/assets/mock-data.json', (route) => {
            route.fulfill({
                status: 200,
                contentType: 'application/json; charset=utf-8',
                body: JSON.stringify([mock]),
            });
        });

        await page.goto('http://localhost:4200');
        await expect(page.locator('td').nth(1)).toContainText('Enda Brody'); 

        //---Code Challenge Add your own name to the mock response--
    });
});
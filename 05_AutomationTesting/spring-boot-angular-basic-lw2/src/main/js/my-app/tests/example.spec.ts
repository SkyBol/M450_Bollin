import { test, expect, type Page } from '@playwright/test';

test.beforeEach(async ({ page }) => {
  await page.goto('localhost:4200/');
});

test('showing all students', async ({ page }) => {
  await page.getByRole('link', { name: 'List Students' }).click();

  // Can see all 3 Properties of Students
  await expect(page.getByRole('cell', { name: '1', exact: true })).toBeVisible();
  await expect(page.getByRole('cell', { name: 'Jonas', exact: true })).toBeVisible();
  await expect(page.getByRole('cell', { name: 'jonas@tbz.ch', exact: true })).toBeVisible();
});

test('adding a student', async ({ page }) => {
  await page.getByRole('link', { name: 'Add Students' }).click();

  // Fill out Student information
  await page.getByPlaceholder('Enter your name').fill('Tester');
  await page.getByPlaceholder('Enter your email address').fill('test@tester.test');

  await page.getByRole('button', { name: 'Submit' }).click();


  await page.waitForTimeout(1000); // Important for Server

  
  // Check for Tester Student
  await page.getByRole('link', { name: 'List Students' }).click();

  await expect(page.getByRole('cell', { name: 'Tester', exact: true }).first()).toBeVisible();
});
